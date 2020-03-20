package com.bootcamp.gameoflife;

import java.util.Objects;

public class Cell {

  private static final String ALIVE_CELL_PATTERN = "X";
  private static final String DEAD_CELL_PATTERN = "_";
  private boolean alive;
  private int neighbors;

  public Cell(boolean alive) {
    this.alive = alive;
  }

  public void setNeighbors(int neighbors) {
    this.neighbors = neighbors;
  }

  public Cell isAliveInNextGeneration() {
    if (!alive && neighbors == 3) {
      return new Cell(true);
    }
    return new Cell(false);
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
