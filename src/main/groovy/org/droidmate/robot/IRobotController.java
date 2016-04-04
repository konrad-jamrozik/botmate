// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package org.droidmate.robot;

public interface IRobotController
{
  boolean connect() throws RobotException;

  void moveToMinXY(boolean isLandscapeOrientation) throws RobotException;

  void moveToCoordinates(int x, int y, int speed, boolean isLandscapeOrientation) throws RobotException;

  void moveToMappedCoordinates(float mappedX, float mappedY, int speed, boolean isLandscapeOrientation)
  throws RobotException;

  void moveDown() throws RobotException;

  void moveUp() throws RobotException;

  void disconnect();

  void moveToMaxXY(boolean isLandscapeOrientation) throws RobotException;

  void moveToBackButton(boolean isLandscapeOrientation) throws RobotException;

  void calibrate() throws RobotException;

  void runRaw(String command) throws RobotException;



}
