// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

fun main(args: Array<String>) {
  Demo(
    AndroidDeviceWithRobot(
      AndroidDevice(Adb(), pressDelayMillis = 0L),
      RobotControllerAdapter()
    ),
    DemoNexus10Buttons()
  ).run()
}