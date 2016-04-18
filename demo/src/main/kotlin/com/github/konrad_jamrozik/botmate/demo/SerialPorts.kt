// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

import com.github.konrad_jamrozik.botmate.controller.RobotConfiguration
import com.github.konrad_jamrozik.botmate.controller.SerialDriver

class SerialPorts {
  val log = loggerFor(SerialPorts::class.java)
  fun log() {
    SerialDriver(RobotConfiguration()).serialPortNames.forEach { log.info(it) }
  }
}