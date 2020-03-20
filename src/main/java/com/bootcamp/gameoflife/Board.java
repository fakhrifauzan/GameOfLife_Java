package com.bootcamp.gameoflife;

public class Board {

  public Board(int height, int width) {
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    return true;
  }
}
