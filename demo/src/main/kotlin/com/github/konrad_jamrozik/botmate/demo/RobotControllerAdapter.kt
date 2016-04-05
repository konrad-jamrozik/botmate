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

class RobotControllerAdapter : IRobotControllerAdapter
{
  val robotController: IRobotController = buildRobotController()

  private fun buildRobotController() : IRobotController {

    val robotConfig = RobotConfiguration()
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

  override fun calibrate() {
    check(robotController.connect()) {"robotController.connect()"}
    robotController.calibrate()
  }

}