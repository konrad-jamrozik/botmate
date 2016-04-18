// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class ButtonListener(val demo: IDemo) {

  val log = loggerFor(ButtonListener::class.java)
  
  var buttonIsPressedDown = false

  fun handleButtonEvent() {

    buttonIsPressedDown = buttonIsPressedDown xor true

    if (buttonIsPressedDown) {
      log.trace("Button is pressed down")
    } else {
      log.trace("Button is pressed up")
      onButtonIsPressedUp()
    }
  }

  private fun onButtonIsPressedUp() {
    log.info("Button clicked: starting demo.")
    demo.run()
  }
}