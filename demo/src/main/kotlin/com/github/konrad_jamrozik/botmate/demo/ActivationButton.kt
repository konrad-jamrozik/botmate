// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

import com.github.konrad_jamrozik.botmate.controller.ISerialDriver

class ActivationButton(val serialDriver: ISerialDriver, val demo: IDemo) {
  fun listen() {
    // KJA pass here SerialPortEventListener that will activate only when the demo is not currently running.
    serialDriver.connect("COM8")
    serialDriver.observeCTS()
    // KJA make sure it works. Works from Gradle? From IntelliJ doesn't.
    readLine()
  }
}