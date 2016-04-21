// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.konradjamrozik.botmate.demo

import com.konradjamrozik.botmate.controller.RobotConfiguration
import com.konradjamrozik.botmate.controller.SerialDriver

class SerialPorts {
  val log = loggerFor(SerialPorts::class.java)
  fun log() {
    SerialDriver(RobotConfiguration()).serialPortNames.forEach { log.info(it) }
  }
}