// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class AndroidDeviceWithRobot(val device: IAndroidDevice, val robot: IRobot) : IAndroidDevice {

  val log = loggerFor(AndroidDeviceWithRobot::class.java)

  override fun setup() {
    device.setup()
    robot.calibrate()
  }

  override fun pressAppsButton() {
    log.debug("AndroidDeviceWithRobot.pressAppsButton()")
  }

  override fun pressKeepAppIcon() {
    log.debug("AndroidDeviceWithRobot.pressKeepAppIcon()")
  }

  override fun pressHomeButton() {
    log.debug("AndroidDeviceWithRobot.pressHomeButton()")
  }

  override fun moveToLowerRightCorner() {
    log.debug("AndroidDeviceWithRobot.moveToLowerRightCorner()")
  }
}
