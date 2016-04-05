// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

import org.junit.Test

class MainKtTest {

  // KJA add to gradlew test + "all tests passed" status info
  @Test
  fun mainTest() {
    println("test!")
    main(Nexus10WithRobotSimulator())
  }
}

class Nexus10WithRobotSimulator : IAndroidDeviceWithRobot {

  val log = loggerFor(Nexus10WithRobotSimulator::class.java)

  override fun calibrate() {
    log.debug("calibrate()")
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
