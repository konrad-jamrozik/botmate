// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

import com.github.konrad_jamrozik.botmate.controller.ISerialDriver
import com.github.konrad_jamrozik.botmate.controller.RobotConfiguration
import com.github.konrad_jamrozik.botmate.controller.SerialDriver
import org.junit.Test

class DemoTest {

  // KJA current work

  @Test
  fun runs_demo_with_stubs() {
    demo(
      AndroidDeviceDemo(
        AndroidDeviceWithRobot(
          AndroidDeviceStub(),
          RobotStub()
        ),
        Nexus10Buttons()
      )
    )
  }

  @Test
  fun runs_demo_with_nexus10_and_robot_stub() {
    demo(
      AndroidDeviceDemo(
        AndroidDeviceWithRobot(
          AndroidDevice(Adb()),
          RobotStub()
        ),
        Nexus10Buttons()
      )
    )
  }

  @Test
  fun runs_demo_with_android_device_stub_and_robot() {
    demo(
      AndroidDeviceDemo(
        AndroidDeviceWithRobot(
          AndroidDeviceStub(),
          Robot(RobotControllerAdapter())
        ),
        Nexus10Buttons()
      )
    )
  }

  @Test
  fun runs_demo() {
    demo(
      AndroidDeviceDemo(
        AndroidDeviceWithRobot(
          AndroidDevice(Adb()),
          Robot(RobotControllerAdapter())
        ),
        Nexus10Buttons()
      )
    )
  }

  @Test
  fun confusingKotlinMessage() {
    // If the SerialDriver constructor doesn't have "public" modifier, getting here red squiggle on SerialDriver with message:
    // Cannot access '<init>': it is 'public/*package*/' in 'SerialDriver'
    val x : ISerialDriver = SerialDriver(RobotConfiguration())
  }
}