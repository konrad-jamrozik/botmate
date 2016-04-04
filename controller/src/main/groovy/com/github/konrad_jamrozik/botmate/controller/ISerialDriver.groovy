// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.controller;

public interface ISerialDriver
{
  Vector<String> getSerialPortNames()

  void connect(String serialPortName) throws RobotException

  void send(String string) throws RobotException

  String receive() throws RobotException

  String receive(String expectedResponse) throws RobotException

  void close()
}