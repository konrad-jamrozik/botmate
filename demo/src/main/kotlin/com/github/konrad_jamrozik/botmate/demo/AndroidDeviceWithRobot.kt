// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class AndroidDeviceWithRobot(val androidDevice: IAndroidDevice, val robot: IRobot) : IAndroidDevice {

  val log = loggerFor(AndroidDeviceWithRobot::class.java)

  override fun setup() {
    log.debug("setup(): not yet implemented")
  }

  override fun pressAppsButton() {
    log.debug("pressAppsButton(): not yet implemented")
  }

  override fun pressKeepAppIcon() {
    log.debug("pressKeepAppIcon(): not yet implemented")
  }

  override fun pressHomeButton() {
    log.debug("pressHomeButton(): not yet implemented")
  }

  override fun moveToLowerRightCorner() {
    log.debug("moveToLowerRightCorner(): not yet implemented")
  }
}
