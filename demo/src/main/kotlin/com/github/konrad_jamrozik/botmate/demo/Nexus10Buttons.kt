// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

class Nexus10Buttons : IDeviceButtons {
  override val apps: Button.Apps
    get() = Button.Apps(Pair(1280, 1420))

  override val home: Button.Home
    get() = Button.Home(Pair(1280, 1550))

  override val keepApp_LaunchIcon: Button.KeepApp_LaunchIcon
    get() = Button.KeepApp_LaunchIcon(Pair(660, 770))

  override val keepApp_TakeANote: Button.KeepApp_TakeANote
    get() = Button.KeepApp_TakeANote(Pair(1954, 1380))

}
