// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

// KJA clean up logging output
// KJA document everything

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
    pressUpperRightBackground()
    delay()
    pressUpperLeftNote()
    pressNoteUpperRightMenu()
    pressNoteMenuDelete()
    delay()
    pressHomeButton()
    reset()
  }

  private fun delay() {
    log.debug("delay()")
    Thread.sleep(1000)
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

  fun pressUpperRightBackground() {
    log.debug("pressUpperRightBackground()")
    device.press(buttons.keepApp_UpperRightBackground)
  }

  fun pressUpperLeftNote() {
    log.debug("pressUpperLeftNote()")
    device.press(buttons.keepApp_UpperLeftNote)
  }

  fun pressNoteUpperRightMenu() {
    log.debug("pressNoteUpperRightMenu()")
    device.press(buttons.keepApp_NoteUpperRightMenu)
  }

  fun pressNoteMenuDelete() {
    log.debug("pressNoteMenuDelete()")
    device.press(buttons.keepApp_NoteMenuDelete)
  }

  fun reset() {
    log.debug("reset()")
    device.reset()
  }
}

