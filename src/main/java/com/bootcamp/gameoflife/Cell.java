package com.bootcamp.gameoflife;

import java.util.Objects;

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
    Cell cell = (Cell) object;
    return alive == cell.alive;
  }

  @Override
  public int hashCode() {
    return Objects.hash(alive);
  }
}
