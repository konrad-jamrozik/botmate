// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.konradjamrozik.botmate.demo

/**
 * Represents a physical button that when clicked, activates BotMate demo.
 */
class Button(val serialDriver: com.konradjamrozik.botmate.controller.ISerialDriver, val demo: IDemo) {

  val log = loggerFor(Button::class.java)

  val listener = ButtonListener(demo)
  
  fun listen() {
    
    serialDriver.connect(serialPortName)
    
    serialDriver.observeCTS { listener.handleButtonEvent() }
    
    log.info("To disconnect the button, press Enter.")
    readLine()
    log.info("Disconnecting the button.")
    
    serialDriver.close()
  }
  
  companion object {
    
    val serialPortEnvVar = "BOTMATE_BUTTON_SERIAL_PORT"

    val serialPortName = System.getenv(serialPortEnvVar) ?: 
      "undefined. Please set environment variable $serialPortEnvVar"

    fun with(demo: IDemo) : Button {
      return Button(com.konradjamrozik.botmate.controller.SerialDriver(com.konradjamrozik.botmate.controller.RobotConfiguration()), demo)
    }
  }
}

