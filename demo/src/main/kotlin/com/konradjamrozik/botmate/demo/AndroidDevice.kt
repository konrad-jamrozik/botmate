// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.konradjamrozik.botmate.demo

class AndroidDevice(val adb: IAdb, val pressDelayMillis: Long) : IAndroidDevice {

  val log = loggerFor(AndroidDevice::class.java)

  override fun setup() {
    log.debug("setup()")
    
    val devicesStrings = adb.devices()
    
    check(devicesStrings.size == 1, { "'adb devices' shows ${devicesStrings.size} available device(s). Required exactly 1. " +
      "The devices:\n" + devicesStrings.joinToString(separator = "\n", prefix = "> ") })
  }

  override fun press(androidButton: AndroidButton) {
    log.debug("press(button)")
    adb.press(androidButton)
    Thread.sleep(pressDelayMillis)
  }

  override fun reset() {
    log.debug("reset()")
  }
}