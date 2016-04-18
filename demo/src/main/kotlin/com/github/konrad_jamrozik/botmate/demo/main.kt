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

// KJA document everything

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
    info("")
    info("  button : Start listening to a hardware button at serial port ")
    info("           denoted by the environment variable ${Button.serialPortEnvVar}. ")
    info("           The button will launch demo when clicked. ")
    info("           Listening stops when user presses Enter.")
    info("")
    info("  demo   : Run demo directly.")
    info("")
    info("Demo options:")
    info("")
    info("  full       : Run demo using actual Android device and robot connected through serial port ")
    info("               denoted by the environment variable ${RobotControllerAdapter.serialPortEnvVar}.")
    info("")
    info("  stubDevice : Run demo as 'full', but with fake programmatic replacement instead of an actual Android device.")
    info("")
    info("  stubRobot  : Run demo as 'full', but with fake programmatic replacement instead of an actual robot.")
    info("")
    info("  stubBoth   : Run demo with fake robot and Android device.")
    info("")
    info("Special arguments:")
    info("")
    info("  ports : Display a list of all available serial ports. Useful for setting")
    info("          the ${RobotControllerAdapter.serialPortEnvVar} and ${Button.serialPortEnvVar} environment variables.")
    info("")
    info("--------------------")
    info("")
    info("Usage examples:")
    info("")
    info("  button stubDevice")
    info("    : Listen to hardware button clicks until the user presses Enter.")
    info("      If clicked, the button will run the robot demo, ") 
    info("      but won't communicate with an Android device even if connected.")
    info("")
    info("  demo full")
    info("    : Immediately start a full demo, i.e. sending commands both to the robot and connected Android device.")

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

