// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

import com.github.konrad_jamrozik.botmate.controller.RobotConfiguration
import com.github.konrad_jamrozik.botmate.controller.SerialDriver
import org.slf4j.LoggerFactory

fun main(args: Array<String>) {

  if (args.contains("stubBoth"))
    runDemoWithDeviceStubAndRobotStub()
  else if (args.contains("stubRobot"))
    runDemoWithRobotStub()
  else if (args.contains("stubDevice"))
    runDemoWithDeviceStub()
  else if (args.contains("demo"))
    runDemoFull()
  else {
    val log = LoggerFactory.getLogger("main")
    log.info("Possible arguments: demo | stubRobot | stubDevice | stubBoth")
  }
}

private val pressDelayMillis = 0L

fun runDemoFull() = Demo(
  AndroidDeviceWithRobot(
    AndroidDevice(Adb(), pressDelayMillis),
    RobotControllerAdapter()
  ),
  DemoNexus10Buttons()
).run()

fun runDemoWithDeviceStub() {
  Demo(
    AndroidDeviceWithRobot(
      AndroidDeviceStub(),
      RobotControllerAdapter()
    ),
    DemoNexus10Buttons()
  ).run()
}

fun runDemoWithRobotStub() {
  Demo(
    AndroidDeviceWithRobot(
      AndroidDevice(Adb(), pressDelayMillis),
      RobotStub()
    ),
    DemoNexus10Buttons()
  ).run()
}

private val demoWithDeviceStubAndRobotStub = Demo(
  AndroidDeviceWithRobot(
    AndroidDeviceStub(),
    RobotStub()
  ),
  DemoNexus10Buttons(),
  delayMillis = 0
)

fun runDemoWithDeviceStubAndRobotStub() {
  demoWithDeviceStubAndRobotStub.run()
}

fun startListeningToButton() 
{
  ActivationButton(SerialDriver(RobotConfiguration()), demoWithDeviceStubAndRobotStub).listen()
}

