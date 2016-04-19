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
 * Represents a widget on Android device touchscreen GUI.
 */
sealed class AndroidButton(val coordinates: Pair<Int, Int>) {
  class Home(coordinates: Pair<Int, Int>) : AndroidButton(coordinates)
  class Standard(coordinates: Pair<Int, Int>) : AndroidButton(coordinates)
}