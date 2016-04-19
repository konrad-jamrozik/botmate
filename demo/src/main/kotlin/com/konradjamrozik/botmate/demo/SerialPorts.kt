// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.konradjamrozik.botmate.demo

class SerialPorts {
  val log = loggerFor(SerialPorts::class.java)
  fun log() {
    com.konradjamrozik.botmate.controller.SerialDriver(com.konradjamrozik.botmate.controller.RobotConfiguration()).serialPortNames.forEach { log.info(it) }
  }
}