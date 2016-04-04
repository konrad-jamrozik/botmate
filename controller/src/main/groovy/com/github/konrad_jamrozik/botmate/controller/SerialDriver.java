// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.controller;

import com.google.common.base.Stopwatch;
import gnu.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class SerialDriver implements ISerialDriver
{
  private static final Marker serialDriver = MarkerFactory.getMarker("MARKER_SERIAL_DRIVER");

  private InputStream serialPortIn;
  private OutputStream serialPortOut;
  private SerialPort serialPort;

  private RobotConfiguration robotConfig;

  private static Logger log = LoggerFactory.getLogger(SerialDriver.class.getSimpleName());

  SerialDriver(RobotConfiguration robotConfig)
  {
    this.robotConfig = robotConfig;
  }

  public Vector<String> getSerialPortNames()
  {
    log.debug("Getting serial port names.");

    Enumeration<CommPortIdentifier> portEnum;
    Vector<String> portVect = new Vector<>();
    portEnum = getPortIdentifiers();

    CommPortIdentifier portId;
    while (portEnum.hasMoreElements())
    {
      portId = portEnum.nextElement();
      if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
      {
        portVect.add(portId.getName());
      }
    }

    log.debug("Found {} port(s).", portVect.size());
    return portVect;
  }

  @SuppressWarnings("unchecked")
  private Enumeration<CommPortIdentifier> getPortIdentifiers()
  {
    return CommPortIdentifier.getPortIdentifiers();
  }

  public void connect(String portName) throws RobotException
  {
    log.debug("Connecting to serial port {}...", portName);

    CommPortIdentifier portIdentifier;
    try
    {
      portIdentifier = CommPortIdentifier.getPortIdentifier(portName);

      if (portIdentifier.isCurrentlyOwned())
        throw new RobotException(String.format("Port %s is currently in use.", portName));

      CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

      if (commPort instanceof SerialPort)
      {
        serialPort = (SerialPort) commPort;
        serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

        serialPortIn = serialPort.getInputStream();
        serialPortOut = serialPort.getOutputStream();

      } else
        throw new RobotException(String.format("The port %s is not instance of a SerialPort!", portName));

    } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException | IOException e)
    {
      throw new RobotException(e);
    }

    log.debug("DONE connecting to serial port {}. Connected successfully.", portName);
  }

  @Override
  public void send(String string) throws RobotException
  {
    try
    {
      log.trace("Sending to serial port: " + string);
      serialPortOut.write((string + "\n").getBytes());
    } catch (IOException e)
    {
      throw new RobotException(e);
    }
    log.trace(serialDriver, "SEND {}", string);

  }


  /**
   * The bytes will be received from {@link #serialPortIn} and converted to string until {@code ok} is encountered
   * or a fixed amount of time passes, given as a command line argument {@link RobotConfiguration}
   */
  @Override
  public String receive() throws RobotException
  {
    return receive(robotConfig.robotResponseConfirmation);
  }

  @Override
  public String receive(String expectedResponse) throws RobotException
  {
    log.trace("Receiving from serial port...");

    StringBuilder receipt = new StringBuilder();

    Stopwatch stopwatch = Stopwatch.createUnstarted();

    byte[] buffer = new byte[1024];
    try
    {
      int bytesRead = serialPortIn.read(buffer);

      // commented out because it is too verbose.
//      log.trace("Number of bytes read from serial port InputStream: {}", bytesRead);

      String answer = new String(Arrays.copyOfRange(buffer, 0, bytesRead));

      // commented out because it is too verbose.
//      log.trace("Received from serial port: " + answer);

      receipt.append(answer);

      for (int i = 0; i < bytesRead; i++)
        buffer[i] = 0;

      stopwatch.start();

      while (noExpectedResponseFromRobotYet(receipt, expectedResponse, stopwatch))
      {
        bytesRead = serialPortIn.read(buffer);

        // commented out because it is too verbose.
//        log.trace("Number of bytes read from serial port InputStream: {}", bytesRead);

        answer = new String(Arrays.copyOfRange(buffer, 0, bytesRead));

        // commented out because it is too verbose.
//        log.trace("Received from serial port: " + answer);

        receipt.append(answer);

        for (int i = 0; i < bytesRead; i++)
          buffer[i] = 0;
      }

      stopwatch.stop();

    } catch (IOException e)
    {
      throw new RobotException(e);
    }

    if (!receipt.toString().contains(expectedResponse))
      throw new RobotException(String.format(
        "Robot didn't send successful command completion confirmation.\n" +
          "Expected: %s\n" +
          "Got instead: %s",
        expectedResponse, receipt.toString()));

    log.trace("DONE receiving from serial port. Message received: {}", receipt.toString());
    log.trace(serialDriver, "RECV {}", receipt.toString());

    return receipt.toString();
  }

  private boolean noExpectedResponseFromRobotYet(StringBuilder receipt, String expectedResponse, Stopwatch stopwatch)
  {
    return !receipt.toString().contains(expectedResponse)
      && stopwatch.elapsed(TimeUnit.MILLISECONDS) <= robotConfig.robotResponseTimeout;
  }

  @Override
  public void close()
  {
    log.info("Closing serial port.");
    serialPort.close();
  }
}
