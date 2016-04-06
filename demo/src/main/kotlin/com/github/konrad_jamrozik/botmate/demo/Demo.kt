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
class Demo(val device: IAndroidDevice, val buttons: IDemoDeviceButtons) : IDemo {

  val log = loggerFor(Demo::class.java)

  override fun run() {
    setup()
    pressAppsButton()
    pressKeepAppLaunchIcon()
    pressKeepAppTakeANote()
    pressH()
    pressE()
    pressL()
    pressL()
    pressO()
    pressExclamationMark()
    // KJA current work
    // press outside to close
    // press on "Hello" note
    // press options in upper right corner
    // press delete
    pressHomeButton()
    moveToLowerRightCorner()
  }

  fun setup() {
    log.debug("setup()")
    device.setup()
  }

  fun pressAppsButton() {
    log.debug("pressAppsButton()")
    device.press(buttons.apps)
  }

  fun pressKeepAppLaunchIcon() {
    log.debug("pressKeepAppLaunchIcon()")
    device.press(buttons.keepApp_LaunchIcon)
  }

  fun pressKeepAppTakeANote() {
    log.debug("pressKeepAppTakeANote()")
    device.press(buttons.keepApp_TakeANote)
  }

  fun pressHomeButton() {
    log.debug("pressHomeButton()")
    device.press(buttons.home)
  }

  fun pressH() {
    log.debug("pressH()")
    device.press(buttons.keyboard_H)
  }

  fun pressE() {
    log.debug("pressE()")
    device.press(buttons.keyboard_E)
  }

  fun pressL() {
    log.debug("pressL()")
    device.press(buttons.keyboard_L)
  }

  fun pressO() {
    log.debug("pressO()")
    device.press(buttons.keyboard_O)
  }

  fun pressExclamationMark() {
    log.debug("pressExclamationMark()")
    device.press(buttons.keyboard_ExclamationMark)
  }

  fun moveToLowerRightCorner() {
    log.debug("moveToLowerRightCorner()")
  }
}

