package com.bootcamp.gameoflife;

public class Board {

  private int height;

  public Board(int height, int width) {
    this.height = height;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Board board = (Board) object;
    return height == board.height;
  }
}
