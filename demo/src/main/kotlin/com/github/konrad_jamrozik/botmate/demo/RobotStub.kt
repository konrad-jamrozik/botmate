// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class RobotStub : IRobot {

  val log = loggerFor(RobotStub::class.java)

  override fun moveUp() {
    log.debug("moveUp()")
  }

  override fun moveDown() {
    log.debug("moveDown()")
  }

  override fun moveTo(coordinates: Pair<Int, Int>) {
    log.debug("moveTo(coordinates)")
  }

  override fun calibrate() {
    log.debug("calibrate()")
  }

  override fun moveToLowerRightCorner() {
    log.debug("moveToLowerRightCorner()")
  }

}