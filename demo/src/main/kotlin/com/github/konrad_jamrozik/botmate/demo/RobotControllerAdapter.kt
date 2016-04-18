// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

import com.github.konrad_jamrozik.botmate.controller.*
import java.io.InputStreamReader
import kotlin.Pair

/**
 * Adapts the legacy robot-controlling code I wrote in Match 2013. 
 * 
 * Note the code has some Nexus 10 data hardcoded in
 * [CoordinateMapperNexus10] and possibly in [RobotConfiguration]. Thus if one ever wants to adapt the robot 
 * to work with different form factor, one will have to not only adapt [DemoNexus10Buttons] but the legacy code as well. 
 */
class RobotControllerAdapter : IRobot
{
  private val robotConfig: RobotConfiguration by lazy { RobotConfiguration() }

  private val robotController: IRobotController by lazy { buildRobotController() }

  private fun buildRobotController() : IRobotController {

    val userInputReader = InputStreamReader(System.`in`, Charsets.UTF_8)
    val robotController = RobotController(
      robotConfig,
      userInputReader,
      SerialDriver(robotConfig),
      CoordinateMapperNexus10(robotConfig),
      RobotPathPlotterArc(robotConfig)
    )
    return robotController
  }

  override fun connectAndCalibrate() {
    check(robotController.connect(serialPortName)) {"check failed: robotController.connect($serialPortName)"}
    robotController.calibrate()
  }

  override fun moveTo(coordinates: Pair<Int, Int>) {

    robotController.moveToCoordinates(
      coordinates.first,
      coordinates.second,
      robotConfig.robotSpeed,
      /* isLandscapeOrientation */ true)
  }

  override fun moveDown() {
    robotController.moveDown()
  }

  override fun moveUp() {
    robotController.moveUp()
  }

  override fun moveToLowerRightCorner() {
    robotController.moveToMaxXY(/* isLandscapeOrientation: */ true);
  }
  
  override fun disconnect() {
    robotController.disconnect()
  }

  companion object {
    val serialPortEnvVar = "BOTMATE_ROBOT_SERIAL_PORT"

    val serialPortName = System.getenv(serialPortEnvVar) ?:
      "undefined. Please set environmental variable $serialPortEnvVar"
  }
}
