// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.konradjamrozik.botmate.demo

import org.zeroturnaround.exec.ProcessExecutor
import java.util.concurrent.TimeUnit

/**
 * Reference:
 * * KeyEvent API: http://developer.android.com/reference/android/view/KeyEvent.html
 * * Stack Overflow question: http://stackoverflow.com/questions/7789826/adb-shell-input-events
 */
class Adb : IAdb {

  val log = com.konradjamrozik.botmate.demo.loggerFor(Adb::class.java)
  
  override fun press(androidButton: AndroidButton) {
    return when (androidButton) {
      is AndroidButton.Home -> pressHome()
      else -> tap(androidButton.coordinates.first, androidButton.coordinates.second)
    }
  }

  private val processExecutor = ProcessExecutor()
    .exitValueNormal()
    .readOutput(true)
    .timeout(5, TimeUnit.SECONDS)
    .destroyOnExit()

  override fun pressHome() {
    log.debug("pressHome(): adb shell input keyevent 3")
    processExecutor.command("adb", "shell", "input", "keyevent", "3").execute()
  }

  override fun tap(x: Int, y: Int) {
    log.debug("tap(x,y): adb shell input tap $x $y")
    processExecutor.command("adb", "shell", "input", "tap", x.toString(), y.toString()).execute()
  }

  override fun devices(): Int {
    log.debug("devices(): adb devices")

    val result = processExecutor.command("adb", "devices").execute()

    val adbDevicesLines = result.outputUTF8().lines()

    adbDevicesLines.forEach { log.debug("> $it") }

    val availableDevices = adbDevicesLines.filter {
      it.isNotEmpty()
        && it != "List of devices attached"
        && !it.contains("offline")
    }
    
    return availableDevices.size
  }

}