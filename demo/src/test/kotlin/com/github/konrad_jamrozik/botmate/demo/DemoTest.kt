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

  @Test
  fun runs_demo_with_stubs() {
    demo(AndroidDeviceWithRobot(AndroidDeviceStub(), RobotStub()))
  }

  @Test
  fun runs_demo_with_nexus10_and_robot_stub() {
    demo(AndroidDeviceWithRobot(Nexus10(), RobotStub()))
  }

  @Test
  fun runs_demo_with_android_device_stub_and_robot() {
    demo(AndroidDeviceWithRobot(AndroidDeviceStub(), Robot()))
  }
}

