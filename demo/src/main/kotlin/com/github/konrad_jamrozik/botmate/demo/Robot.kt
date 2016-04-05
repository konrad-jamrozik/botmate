// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class Robot(val controller: IRobotControllerAdapter) : IRobot {

  val log = loggerFor(Robot::class.java)

  override fun calibrate() {
    log.debug("Robot.calibrate()")
    controller.calibrate()
  }

  override fun moveTo(coordinates: Pair<Int, Int>) {
    log.debug("Robot.moveTo()")
    controller.moveTo(coordinates)
    // KJA next: depend on 'controller' project, create RobotControllerAdapter() here and use it to communicate with the robot.
    // For reference, see org.droidmate.robot.AndroidDeviceWithRobot#performActionOnDevice
  }

}

