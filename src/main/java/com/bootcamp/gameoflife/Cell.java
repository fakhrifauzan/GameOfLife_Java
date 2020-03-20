package com.bootcamp.gameoflife;

public class Cell {

  public Cell(boolean alive) {
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    return true;
  }
}
