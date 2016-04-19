// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.konradjamrozik.botmate.demo

class AndroidDeviceWithRobot(val device: IAndroidDevice, val robot: IRobot) : IAndroidDevice {

  val log = loggerFor(AndroidDeviceWithRobot::class.java)

  override fun setup() {
    log.debug("setup()")
    robot.connectAndCalibrate()
    device.setup()
  }

  override fun press(androidButton: AndroidButton) {
    log.debug("press(button)")
    robot.moveTo(androidButton.coordinates)
    robot.moveDown()
    device.press(androidButton)
    robot.moveUp()
  }

  override fun reset() {
    log.debug("reset()")
    robot.moveToLowerRightCorner()
    robot.disconnect()
  }
}