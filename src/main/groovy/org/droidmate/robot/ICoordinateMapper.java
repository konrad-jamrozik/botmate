// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package org.droidmate.robot;

public interface ICoordinateMapper
{
  float mapToX(int x, int y, boolean isLandscapeOrientation);

  float mapToY(int x, int y, boolean isLandscapeOrientation);


}
