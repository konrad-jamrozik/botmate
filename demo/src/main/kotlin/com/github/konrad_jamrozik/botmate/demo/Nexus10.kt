// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class Nexus10 : IAndroidDevice {

  val log = loggerFor(Nexus10::class.java)

  override fun setup() {
    log.debug("Nexus10.setup()")
  }

  override fun pressAppsButton() {
    log.debug("pressAppsButton()")
  }

  override fun pressKeepAppIcon() {
    log.debug("pressKeepAppIcon()")
  }

  override fun pressHomeButton() {
    log.debug("pressHomeButton()")
  }

  override fun moveToLowerRightCorner() {
    log.debug("moveToLowerRightCorner()")
  }
}