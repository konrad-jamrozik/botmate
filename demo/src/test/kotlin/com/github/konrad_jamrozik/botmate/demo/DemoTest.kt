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

class DemoTest {

  private val pressDelayMillis = 400L

  @Test
  fun runs_demo_with_stubs() =
    Demo(
      AndroidDeviceWithRobot(
        AndroidDeviceStub(),
        RobotStub()
      ),
      DemoNexus10Buttons()
    ).run()

  @Test
  fun runs_demo_with_nexus10_and_robot_stub() =
    Demo(
      AndroidDeviceWithRobot(
        AndroidDevice(Adb(), pressDelayMillis),
        RobotStub()
      ),
      DemoNexus10Buttons()
    ).run()

  @Test
  fun runs_demo_with_android_device_stub_and_robot() =
    Demo(
      AndroidDeviceWithRobot(
        AndroidDeviceStub(),
        RobotControllerAdapter()
      ),
      DemoNexus10Buttons()
    ).run()

  @Test
  fun runs_demo() = Demo(
    AndroidDeviceWithRobot(
      AndroidDevice(Adb(), pressDelayMillis),
      RobotControllerAdapter()
    ),
    DemoNexus10Buttons()
  ).run()
}