// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class AndroidDeviceWithRobot(val device : IAndroidDevice, val robot: IRobot) : IAndroidDevice {

  val log = loggerFor(AndroidDeviceWithRobot::class.java)

  override fun setup() {
    log.debug("setup()")
    robot.calibrate()
    device.setup()
  }

  override fun press(button: Button) {
    robot.moveTo(button.coordinates)
    robot.moveDown()
    device.press(button)
    robot.moveUp()
  }
}