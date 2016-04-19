// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package com.konradjamrozik.botmate.controller;

import java.util.List;

public interface IRobotPathPlotter
{
  List<Pair<Float, Float>> plot(float mappedStartX, float mappedStartY, float mappedEndX, float mappedEndY);
}
