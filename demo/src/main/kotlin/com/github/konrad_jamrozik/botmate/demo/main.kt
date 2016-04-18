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

  if (args.isEmpty()) {
    printHelp()
    return
  }

  validateArgs(args)
  
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
  }
}

private fun validateArgs(args: Array<String>) {
  check (
    args.contains("button") xor args.contains("demo"),
    { "Please provide as argument exactly one of: 'button' or 'demo' (without '')" }
  )
  check (
    listOf("full", "stubRobot", "stubDevice", "stubBoth").count { args.contains(it) } == 1,
    { "Please provide as argument exactly one of: full stubRobot stubDevice stubBoth" }
  )
}

private fun printHelp() {
  val log = LoggerFactory.getLogger("main")
  with(log) {
    info("Accepted arguments: [button|demo] [full|stubDevice|stubRobot|stubBoth]")
    info("")
    info("Execution mode:")
    info("  button - start listening to a hardware button which will launch demo when clicked. " +
      "Listening stops when user presses Enter.")
    info("  demo   - run demo directly.")
    info("")
    info("demo options:")
    info("  full       - run demo using actual Android device and robot.")
    info("  stubDevice - run demo as 'full', but with fake programmatic replacement instead of an actual Android device.")
    info("  stubRobot  - run demo as 'full', but with fake programmatic replacement instead of an actual robot.")
    info("  stubBoth   - run demo with fake robot and Android device.")
  }
}

