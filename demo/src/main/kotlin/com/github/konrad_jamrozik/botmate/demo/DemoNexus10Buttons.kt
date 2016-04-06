// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

/**
 * A set of button definitions for Nexus 10 running Android 5 in landscape mode.
 */
class DemoNexus10Buttons : IDemoDeviceButtons {

  override val apps: Button.Standard = Button.Standard(Pair(1280, 1420))
  override val home: Button.Home = Button.Home(Pair(1280, 1550))
  override val keepApp_LaunchIcon: Button.Standard = Button.Standard(Pair(660, 770))
  override val keepApp_TakeANote: Button.Standard = Button.Standard(Pair(1954, 1380))
  // KJA current work
  override val keyboard_H: Button.Standard = Button.Standard(Pair(0, 0))
  override val keyboard_E: Button.Standard = Button.Standard(Pair(0, 0))
  override val keyboard_L: Button.Standard = Button.Standard(Pair(0, 0))
  override val keyboard_O: Button.Standard = Button.Standard(Pair(0, 0))
  override val keyboard_ExclamationMark: Button.Standard = Button.Standard(Pair(0, 0))
  override val keepApp_UpperRightBackground: Button.Standard = Button.Standard(Pair(0, 0))
  override val keepApp_UpperLeftNote: Button.Standard = Button.Standard(Pair(0, 0))
  override val keepApp_NoteUpperRightMenu: Button.Standard = Button.Standard(Pair(0, 0))
  override val keepApp_NoteMenuDelete: Button.Standard = Button.Standard(Pair(0, 0))

}
