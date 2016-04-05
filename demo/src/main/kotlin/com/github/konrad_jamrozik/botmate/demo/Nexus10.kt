// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class Nexus10(val adb: IAdb) : IAndroidDevice {

  val log = loggerFor(Nexus10::class.java)

  override fun setup() {
    log.debug("Nexus10.setup()")
  }

  override fun pressAppsButton() {
    log.debug("Nexus10.pressAppsButton()")
    adb.tap(x = 1280, y = 1420)
  }

  override fun pressKeepAppIcon() {
    log.debug("Nexus10.pressKeepAppIcon()")
  }

  override fun pressHomeButton() {
    log.debug("Nexus10.pressHomeButton()")
    adb.pressHome()
  }

  override fun moveToLowerRightCorner() {
    log.debug("Nexus10.moveToLowerRightCorner()")
  }
}