// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

import org.slf4j.LoggerFactory

// KJA2 clean up logging output
// KJA2 document everything

fun main(args: Array<String>) {

  checkArgs(args)
  
  if (args.isEmpty()) {
    printHelp()
    return
  }

  if (args.contains("ports")) {
    SerialPorts().log()
    return
  }
  
  val demo = when {
    args.contains("full") -> Demo.full
    args.contains("stubDevice") -> Demo.withDeviceStub
    args.contains("stubRobot") -> Demo.withRobotStub
    args.contains("stubBoth") -> Demo.withDeviceStubAndRobotStub
    else -> throw IllegalStateException()
  }
  
  when {
    args.contains("button") -> Button.with(demo).listen() 
    args.contains("demo") -> demo.run()
    else -> throw IllegalStateException()
  }
}

private fun printHelp() {
  val log = LoggerFactory.getLogger("main")
  with(log) {
    info("Accepted arguments: ")
    info("  (button|demo) (full|stubDevice|stubRobot|stubBoth)")
    info("-OR-")
    info("  ports")
    info("")
    info("Execution mode:")
    info("  button - Start listening to a hardware button at serial port " +
      "denoted by environmental variable ${Button.serialPortEnvVar}. " +
      "The button will launch demo when clicked. " +
      "Listening stops when user presses Enter.")
    info("  demo   - Run demo directly.")
    info("")
    info("Demo options:")
    info("  full       - Run demo using actual Android device and robot connected through serial port " +
      "denoted by environmental variable ${RobotControllerAdapter.serialPortEnvVar}.")
    info("  stubDevice - Run demo as 'full', but with fake programmatic replacement instead of an actual Android device.")
    info("  stubRobot  - Run demo as 'full', but with fake programmatic replacement instead of an actual robot.")
    info("  stubBoth   - Run demo with fake robot and Android device.")
    info("")
    info("Special arguments:")
    info("  ports - Display a list of all available serial ports.")

  }
}

private fun checkArgs(args: Array<String>) {

  if (args.isEmpty())
    return

  if (args.contains("ports")) {
    check ((args.size == 1),
      { "You provided 'ports' argument. Please do not provide any other arguments with this argument." }
    )
    return
  }
  
  check (
    args.contains("button") xor args.contains("demo"),
    { "Please provide as argument exactly one of: 'button' or 'demo' (without '')" }
  )
  check (
    listOf("full", "stubRobot", "stubDevice", "stubBoth").count { args.contains(it) } == 1,
    { "Please provide as argument exactly one of: full stubRobot stubDevice stubBoth" }
  )
}

