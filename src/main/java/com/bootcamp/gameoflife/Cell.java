package com.bootcamp.gameoflife;

import java.util.Objects;

public class Cell {

  private static final String ALIVE_CELL_PATTERN = "X";
  private static final String DEAD_CELL_PATTERN = "_";
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

  @Override
  public String toString() {
    return alive ? ALIVE_CELL_PATTERN : DEAD_CELL_PATTERN;
  }
}
