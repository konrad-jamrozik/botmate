// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.konradjamrozik.botmate.demo

import org.junit.Test

class ButtonTest {

  @Test
  fun starts_listening_to_button() = Button.with(Demo.withDeviceStubAndRobotStub).listen()
}