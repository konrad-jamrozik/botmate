// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo


class Demo(val device: IAndroidDevice, val buttons: IDemoDeviceButtons, val delayMillis: Long = 1000) : IDemo {
  
  val log = loggerFor(Demo::class.java)

  override fun run() {
    log.info("Demo: starting.")
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
    log.info("Demo: finished")
  }

  private fun delay() {
    log.debug("delay()")
    Thread.sleep(delayMillis)
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

  companion object {
    private val pressDelayMillis = 0L
    val full = Demo(
      AndroidDeviceWithRobot(
        AndroidDevice(Adb(), pressDelayMillis),
        RobotControllerAdapter()
      ),
      DemoNexus10Buttons()
    )
    val withDeviceStub = Demo(
      AndroidDeviceWithRobot(
        AndroidDeviceStub(),
        RobotControllerAdapter()
      ),
      DemoNexus10Buttons()
    )

    val withRobotStub = Demo(
      AndroidDeviceWithRobot(
        AndroidDevice(Adb(), pressDelayMillis),
        RobotStub()
      ),
      DemoNexus10Buttons()
    )
    val withDeviceStubAndRobotStub = Demo(
      AndroidDeviceWithRobot(
        AndroidDeviceStub(),
        RobotStub()
      ),
      DemoNexus10Buttons(),
      delayMillis = 0
    )
  }
}

