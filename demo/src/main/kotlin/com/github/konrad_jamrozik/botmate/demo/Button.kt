// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.github.konrad_jamrozik.botmate.demo

sealed class Button(val coordinates: Pair<Int, Int>) {

  class Apps(coordinates: Pair<Int, Int>) : Button(coordinates)
  class Home(coordinates: Pair<Int, Int>) : Button(coordinates)

//  class Keyboard_H(coordinates: Pair<Int, Int>) : Button(coordinates)
//  class Keyboard_E(coordinates: Pair<Int, Int>) : Button(coordinates)
//  class Keyboard_L(coordinates: Pair<Int, Int>) : Button(coordinates)
//  class Keyboard_O(coordinates: Pair<Int, Int>) : Button(coordinates)
//  class Keyboard_ExclamationMark(coordinates: Pair<Int, Int>) : Button(coordinates)

  class KeepApp_LaunchIcon(coordinates: Pair<Int, Int>) : Button(coordinates)
  class KeepApp_TakeANote(coordinates: Pair<Int, Int>) : Button(coordinates)
//  class KeepApp_UpperRightBackground(coordinates: Pair<Int, Int>) : Button(coordinates)
//  class KeepApp_UpperLeftNote(coordinates: Pair<Int, Int>) : Button(coordinates)
//  class KeepApp_NoteUpperRightMenu(coordinates: Pair<Int, Int>) : Button(coordinates)
//  class KeepApp_NoteMenuDelete(coordinates: Pair<Int, Int>) : Button(coordinates)

}