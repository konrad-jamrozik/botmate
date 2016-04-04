// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package org.droidmate.robot;

public class RobotException extends Exception
{
  private static final long serialVersionUID = 1L;

  public RobotException() {
    super();
  }

  public RobotException(String message, Throwable cause) {
    super(message, cause);
  }

  public RobotException(String message) {
    super(message);
  }

  public RobotException(Throwable cause) {
    super(cause);
  }
}
