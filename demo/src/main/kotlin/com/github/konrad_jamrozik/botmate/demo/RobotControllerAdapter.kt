// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class RobotControllerAdapter : IRobotControllerAdapter
{
//  val robotController: IRobotController = buildRobotController()
//
//  private fun buildRobotController() : IRobotController {
//
//      val robotConfig = RobotConfiguration()
//    val userInputReader = InputStreamReader(System.`in`, Charsets.UTF_8)
//    val robotController = RobotController(
//      robotConfig,
//      userInputReader,
      // KJA kotlin bug?
//      SerialDriver(robotConfig),
//      CoordinateMapperNexus10(robotConfig),
//      RobotPathPlotterArc(robotConfig)
//    )
//    return robotController
//  }

  override fun calibrate() {
    throw UnsupportedOperationException()
  }

}