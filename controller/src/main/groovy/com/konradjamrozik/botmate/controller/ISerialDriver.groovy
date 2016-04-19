// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.konradjamrozik.botmate.controller

import gnu.io.SerialPortEventListener;

public interface ISerialDriver
{
  Vector<String> getSerialPortNames()

  boolean connect(String serialPortName) throws RobotException
  
  void observeCTS(SerialPortEventListener serialPortEventListener)

  void send(String string) throws RobotException

  String receive() throws RobotException

  String receive(String expectedResponse) throws RobotException

  void close()
}