// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

fun demo(androidDeviceDemo: IAndroidDeviceDemo) {
  androidDeviceDemo.setup()
  androidDeviceDemo.pressAppsButton()
  androidDeviceDemo.pressKeepAppIcon()
  // press take a note
  // press keys: h e l l o
  // press outside to close
  // press on "Hello" note
  // press options in upper right corner
  // press delete
  androidDeviceDemo.pressHomeButton()
  androidDeviceDemo.moveToLowerRightCorner()
}

