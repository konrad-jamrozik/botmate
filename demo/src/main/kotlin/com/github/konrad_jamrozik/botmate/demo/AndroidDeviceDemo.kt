// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

// WISH document everything
class AndroidDeviceDemo(val device: IAndroidDevice, val buttons: IDeviceButtons) : IAndroidDeviceDemo {

  val log = loggerFor(AndroidDeviceDemo::class.java)

  override fun setup() {
    log.debug("setup()")
    device.setup()
  }

  override fun pressAppsButton() {
    log.debug("pressAppsButton()")
    device.press(buttons.apps)
  }

  override fun pressKeepAppLaunchIcon() {
    log.debug("pressKeepAppLaunchIcon()")
    device.press(buttons.keepApp_LaunchIcon)
  }

  override fun pressKeepAppTakeANote() {
    log.debug("pressKeepAppTakeANote()")
    device.press(buttons.keepApp_TakeANote)
  }

  override fun pressHomeButton() {
    log.debug("pressHomeButton()")
    device.press(buttons.home)
  }

  override fun moveToLowerRightCorner() {
    log.debug("moveToLowerRightCorner()")
  }
}

