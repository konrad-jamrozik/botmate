// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.konradjamrozik.botmate.demo

import java.io.InputStreamReader

/**
 * Adapts the legacy robot-controlling code I wrote in Match 2013. 
 * 
 * Note the code has some Nexus 10 data hardcoded in
 * [CoordinateMapperNexus10] and possibly in [RobotConfiguration]. Thus if one ever wants to adapt the robot 
 * to work with different form factor, one will have to not only adapt [DemoNexus10Buttons] but the legacy code as well. 
 */
class RobotControllerAdapter : IRobot
{
  val log = loggerFor(RobotControllerAdapter::class.java)
  
  private val robotConfig: com.konradjamrozik.botmate.controller.RobotConfiguration by lazy { com.konradjamrozik.botmate.controller.RobotConfiguration() }

  private val robotController: com.konradjamrozik.botmate.controller.IRobotController by lazy { buildRobotController() }

  private fun buildRobotController() : com.konradjamrozik.botmate.controller.IRobotController {

    val userInputReader = InputStreamReader(System.`in`, Charsets.UTF_8)
    val robotController = com.konradjamrozik.botmate.controller.RobotController(
      robotConfig,
      userInputReader,
      com.konradjamrozik.botmate.controller.SerialDriver(robotConfig),
      com.konradjamrozik.botmate.controller.CoordinateMapperNexus10(robotConfig),
      com.konradjamrozik.botmate.controller.RobotPathPlotterArc(robotConfig)
    )
    return robotController
  }

  override fun connectAndCalibrate() {
    log.debug("connectAndCalibrate()")
    check(robotController.connect(serialPortName)) {"check failed: robotController.connect($serialPortName)"}
    robotController.calibrate()
  }

  override fun moveTo(coordinates: Pair<Int, Int>) {
    
    log.debug("moveTo(${coordinates.first},${coordinates.second})")

    robotController.moveToCoordinates(
      coordinates.first,
      coordinates.second,
      robotConfig.robotSpeed,
      /* isLandscapeOrientation */ true)
  }

  override fun moveDown() {
    log.debug("moveDown()")
    robotController.moveDown()
  }

  override fun moveUp() {
    log.debug("moveUp()")
    robotController.moveUp()
  }

  override fun moveToLowerRightCorner() {
    log.debug("moveToLowerRightCorner()")
    robotController.moveToMaxXY(/* isLandscapeOrientation: */ true);
  }
  
  override fun disconnect() {
    log.debug("disconnect()")
    robotController.disconnect()
  }

  companion object {
    val serialPortEnvVar = "BOTMATE_ROBOT_SERIAL_PORT"

    val serialPortName = System.getenv(serialPortEnvVar) ?:
      "<undefined_port>. Please set environment variable $serialPortEnvVar"
  }
}
