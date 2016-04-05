// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

// KJA to implement all Nexus10Buttons
// apps button: adb.tap(x = 1280, y = 1420)
// home button: adb.pressHome()
class Button : IButton {
  override val coordinates: Pair<Int, Int>
    get() = Pair(100, 100)

}