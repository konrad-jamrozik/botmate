// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package org.droidmate.robot;

import java.util.ArrayList;
import java.util.List;

public class RobotPathPlotterStraightLine implements IRobotPathPlotter
{

  @Override
  public List<Pair<Float, Float>> plot(float mappedStartX, float mappedStartY, float mappedEndX, float mappedEndY)
  {
    ArrayList<Pair<Float, Float>> points = new ArrayList<Pair<Float, Float>>();
    points.add(new Pair<Float, Float>(mappedEndX, mappedEndY));
    return points;
  }

}
