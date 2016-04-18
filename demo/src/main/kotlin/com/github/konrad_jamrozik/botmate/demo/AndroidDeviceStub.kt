// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class AndroidDeviceStub : IAndroidDevice {

  val log = loggerFor(AndroidDeviceStub::class.java)

  override fun setup() {
    log.debug("setup()")
  }

  override fun press(androidButton: AndroidButton) {
    log.debug("press(button)")
  }

  override fun reset() {
    log.debug("reset()")
  }

}