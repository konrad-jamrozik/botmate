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

val log = LoggerFactory.getLogger("main")

fun main(args: Array<String>) {

  if (args.isEmpty())
    printHelp()

  validateArgs(args)
  
  val demo = when {
    args.contains("full") -> demoFull
    args.contains("stubDevice") -> demoWithDeviceStub
    args.contains("stubRobot") -> demoWithRobotStub
    args.contains("stubBoth") -> demoWithDeviceStubAndRobotStub
    else -> throw IllegalStateException()
  }
  when {
    args.contains("button") -> Button(SerialDriver(RobotConfiguration()), demo).listen()
    args.contains("demo") -> demo.run()
  }
}

private fun validateArgs(args: Array<String>) {
  check (
    args.contains("button") xor args.contains("demo"),
    { "Please private as argument exactly one of: 'button' or 'demo' (without '')" }
  )
  check (
    listOf("full", "stubRobot", "stubDevice", "stubBoth").count { args.contains(it) } == 1,
    { "Please provide as argument exactly one of: full stubRobot stubDevice stubBoth" }
  )
}

private fun printHelp() {
  with(log) {
    info("[button|demo] [full|stubDevice|stubRobot|stubBoth]")
    info("Execution mode:")
    info("button: start listening to a hardware button which will launch demo when clicked. " +
      "Listening stops when user presses Enter.")
    info("demo: run demo directly.")
    info("")
    info("demo options:")
    info("full: run demo using actual Android device and robot.")
    info("stubDevice: run demo as 'full', but with fake programmatic replacement instead of actual Android device.")
    info("stubRobot: run demo as 'full', but with fake programmatic replacement instead of actual robot.")
    info("stubBoth: run demo with fake robot and Android device")
  }
}

// KJA to remove
fun main2(args: Array<String>) {

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
  Button(SerialDriver(RobotConfiguration()), demoFull).listen()
}


fun listenToButtonWithDemoStubs()
{
  Button(SerialDriver(RobotConfiguration()), demoWithDeviceStubAndRobotStub).listen()
}

private val pressDelayMillis = 0L

fun runDemo() {
  demoFull.run()
}

fun runDemoWithDeviceStubAndRobotStub() {
  demoWithDeviceStubAndRobotStub.run()
}

// KJA refactor out

private val demoWithDeviceStub = Demo(
  AndroidDeviceWithRobot(
    AndroidDeviceStub(),
    RobotControllerAdapter()
  ),
  DemoNexus10Buttons()
)

fun runDemoWithDeviceStub() {
  demoWithDeviceStub.run()
}

private val demoWithRobotStub = Demo(
  AndroidDeviceWithRobot(
    AndroidDevice(Adb(), pressDelayMillis),
    RobotStub()
  ),
  DemoNexus10Buttons()
)

fun runDemoWithRobotStub() {
  demoWithRobotStub.run()
}

private val demoFull = Demo(
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


