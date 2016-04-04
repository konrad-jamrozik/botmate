// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

import org.junit.Test

class MainKtTest {

  // KJA add to gradlew test + "all tests passed" status info
  @Test
  fun mainTest() {
    println("test!")
    main(Nexus10WithRobotSimulator())
  }
}

// KJA replace printlns with slf4j
class Nexus10WithRobotSimulator : IAndroidDeviceWithRobot {
  override fun calibrate() {
    println("calibrate()")
  }

  override fun pressAppsButton() {
    println("pressAppsButton()")
  }

  override fun pressKeepAppIcon() {
    println("pressKeepAppIcon()")
  }

  override fun pressHomeButton() {
    println("pressHomeButton()")
  }

  override fun moveToLowerRightCorner() {
    println("moveToLowerRightCorner()")
  }

}
