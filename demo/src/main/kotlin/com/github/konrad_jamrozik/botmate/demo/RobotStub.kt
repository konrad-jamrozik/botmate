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
    log.trace("moveUp()")
  }

  override fun moveDown() {
    log.trace("moveDown()")
  }

  override fun moveTo(coordinates: Pair<Int, Int>) {
    log.trace("moveTo(coordinates)")
  }

  override fun connectAndCalibrate() {
    log.trace("calibrate()")
  }

  override fun moveToLowerRightCorner() {
    log.trace("moveToLowerRightCorner()")
  }
  
  override fun disconnect() {
    log.trace("disconnect()")
  }

}