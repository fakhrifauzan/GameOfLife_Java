package com.bootcamp.gameoflife;

import java.util.ArrayList;
import java.util.Objects;

public class Board {

  private static final Cell DEAD_CELL = new Cell(false);
  private static final Cell ALIVE_CELL = new Cell(true);
  private static final int X_STEP = 0;
  private static final int Y_STEP = 1;
  private int height;
  private int width;
  private ArrayList<ArrayList<Cell>> board = new ArrayList<>();

  public Board(int height, int width) {
    this.height = height;
    this.width = width;
    initialBoardWithDeadCells();
  }

  private void initialBoardWithDeadCells() {
    for (int y = 0; y < height; y++) {
      ArrayList<Cell> rowOfDeadCells = new ArrayList<>();
      for (int x = 0; x < width; x++) {
        rowOfDeadCells.add(DEAD_CELL);
      }
      board.add(rowOfDeadCells);
    }
  }

  public Cell getCellAt(int x, int y) {
    try {
      return board.get(y).get(x);
    } catch (IndexOutOfBoundsException exception) {
      return DEAD_CELL;
    }
  }

  public int getCellState(int x, int y) {
    Cell cell = getCellAt(x, y);
    return cell.equals(ALIVE_CELL) ? 1 : 0;
  }

  public void setCellState(int x, int y, boolean state) {
    Cell cell = new Cell(state);
    board.get(y).set(x, cell);
  }

  public int countAliveNeighborCell(int x, int y) {
    int countAlive = 0;
    int[][] steps = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
    for (int[] step : steps) {
      countAlive += getCellState(x + step[X_STEP], y + step[Y_STEP]);
    }
    return countAlive;
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
