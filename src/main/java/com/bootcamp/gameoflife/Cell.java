package com.bootcamp.gameoflife;

import java.util.Objects;

public class Cell {

  private static final String ALIVE_CELL_PATTERN = "X";
  private static final String DEAD_CELL_PATTERN = "_";
  private static final int LOWER_BOUND_ALIVE_NEIGHBOR = 2;
  private static final int UPPER_BOUND_ALIVE_NEIGHBOR = 3;
  private boolean alive;
  private int neighbors;

  public Cell(boolean alive) {
    this.alive = alive;
  }

  public void setNeighbors(int neighbors) {
    this.neighbors = neighbors;
  }

  public Cell isAliveInNextGeneration() {
    boolean isAlive;
    if (alive) {
      isAlive = neighbors == LOWER_BOUND_ALIVE_NEIGHBOR || neighbors == UPPER_BOUND_ALIVE_NEIGHBOR;
    } else {
      isAlive = neighbors == UPPER_BOUND_ALIVE_NEIGHBOR;
    }
    return new Cell(isAlive);
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
