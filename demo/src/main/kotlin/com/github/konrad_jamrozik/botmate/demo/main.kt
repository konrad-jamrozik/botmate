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

// KJA2 clean up logging output
// KJA2 document everything

fun main(args: Array<String>) {

  // KJA two params [button|demo] and [stubRobot] [stubDevice]
  if (args.contains("button"))
    listenToButtonWithDemo()
  else if (args.contains("buttonWithStubs"))
    listenToButtonWithDemoStubs()
  else if (args.contains("stubBoth"))
    runDemoWithDeviceStubAndRobotStub()
  else if (args.contains("stubRobot"))
    runDemoWithRobotStub()
  else if (args.contains("stubDevice"))
    runDemoWithDeviceStub()
  else if (args.contains("demo"))
    runDemo()
  else {
    val log = LoggerFactory.getLogger("main")
    log.info("Possible arguments: button | demo | stubRobot | stubDevice | stubBoth")
  }
}

fun listenToButtonWithDemo()
{
  Button(SerialDriver(RobotConfiguration()), demo).listen()
}


fun listenToButtonWithDemoStubs()
{
  Button(SerialDriver(RobotConfiguration()), demoWithDeviceStubAndRobotStub).listen()
}

private val pressDelayMillis = 0L

fun runDemo() {
  demo.run()
}

fun runDemoWithDeviceStubAndRobotStub() {
  demoWithDeviceStubAndRobotStub.run()
}

// KJA refactor out

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

private val demo = Demo(
  AndroidDeviceWithRobot(
    AndroidDevice(Adb(), pressDelayMillis),
    RobotControllerAdapter()
  ),
  DemoNexus10Buttons()
)

private val demoWithDeviceStubAndRobotStub = Demo(
  AndroidDeviceWithRobot(
    AndroidDeviceStub(),
    RobotStub()
  ),
  DemoNexus10Buttons(),
  delayMillis = 0
)


