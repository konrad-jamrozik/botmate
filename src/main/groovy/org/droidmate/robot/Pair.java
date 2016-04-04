// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, konrad.jamrozik@cispa.saarland
//
// This file is part of the "BotMate" project.
//
// github.com/konrad-jamrozik/botmate

package org.droidmate.robot;

public class Pair<X, Y>
{
  private X x;
  private Y y;

  public Pair(X x, Y y)
  {
    this.x = x;
    this.y = y;
  }

  public X getX()
  {
    return x;
  }

  public Y getY()
  {
    return y;
  }

  public void setX(X x)
  {
    this.x = x;
  }

  public void setY(Y y)
  {
    this.y = y;
  }
}
