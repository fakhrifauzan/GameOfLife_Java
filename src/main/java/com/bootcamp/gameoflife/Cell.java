package com.bootcamp.gameoflife;

public class Cell {

  private boolean alive;

  public Cell(boolean alive) {
    this.alive = alive;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    return alive;
  }
}
