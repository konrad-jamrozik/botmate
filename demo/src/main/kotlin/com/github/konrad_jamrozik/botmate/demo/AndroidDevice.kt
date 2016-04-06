// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class AndroidDevice(val adb: IAdb, val pressDelayMillis: Long) : IAndroidDevice {

  val log = loggerFor(AndroidDevice::class.java)

  override fun setup() {
    log.debug("setup()")
  }

  override fun press(button: Button) {
    log.debug("press(button)")
    adb.press(button)
    Thread.sleep(pressDelayMillis)
  }
}