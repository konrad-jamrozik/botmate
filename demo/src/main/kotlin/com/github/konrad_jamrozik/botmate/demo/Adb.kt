// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

import org.zeroturnaround.exec.ProcessExecutor

/**
 * Reference:
 * * KeyEvent API: http://developer.android.com/reference/android/view/KeyEvent.html
 * * stack overflow question: http://stackoverflow.com/questions/7789826/adb-shell-input-events
 */
class Adb : IAdb {
  override fun press(androidButton: AndroidButton) {
    return when (androidButton) {
      is AndroidButton.Home -> pressHome()
      else -> tap(androidButton.coordinates.first, androidButton.coordinates.second)
    }
  }

  override fun pressHome() {
    ProcessExecutor().command("adb", "shell", "input", "keyevent", "3").execute()
  }

  override fun tap(x: Int, y: Int) {
    ProcessExecutor().command("adb", "shell", "input", "tap", x.toString(), y.toString()).execute()
  }
}