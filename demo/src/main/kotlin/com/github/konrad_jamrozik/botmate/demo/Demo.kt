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
  println("Hello, demo!")

  // KJA current work

  val nexus10 = Nexus10(Adb())
  // check nexus10 is available

  val robot = Robot()
  // check port is available, i.e. robot can be contacted

  val nexus10WithRobot = AndroidDeviceWithRobot(nexus10, robot)

  demo(nexus10WithRobot)
}

fun demo(androidDevice: IAndroidDevice) {
  androidDevice.setup()
  androidDevice.pressAppsButton()
  androidDevice.pressKeepAppIcon()
  // press take a note
  // press keys: h e l l o
  // press outside to close
  // press on "Hello" note
  // press options in upper right corner
  // press delete
  androidDevice.pressHomeButton()
  androidDevice.moveToLowerRightCorner()
}

