// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

fun main(args: Array<String>) {
  println("Hello, demo!")

  // KJA current work

  val nexus10 = Nexus10()
  // check nexus10 is available

  val robot = Robot()
  // check port is available, i.e. robot can be contacted

  val nexus10WithRobot = Nexus10WithRobot(nexus10, robot)

  main(nexus10WithRobot)
}

fun main(androidDeviceWithRobot: IAndroidDeviceWithRobot) {
  androidDeviceWithRobot.calibrate()
  androidDeviceWithRobot.pressAppsButton()
  androidDeviceWithRobot.pressKeepAppIcon()
  // press take a note
  // press keys: h e l l o
  // press outside to close
  // press on "Hello" note
  // press options in upper right corner
  // press delete
  androidDeviceWithRobot.pressHomeButton()
  androidDeviceWithRobot.moveToLowerRightCorner()
}

