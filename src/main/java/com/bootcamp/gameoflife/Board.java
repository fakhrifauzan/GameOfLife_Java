package com.bootcamp.gameoflife;

import java.util.Objects;

public class Board {

  private int height;
  private int width;

  public Board(int height, int width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Board board = (Board) object;
    return height == board.height && width == board.width;
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, width);
  }
}
