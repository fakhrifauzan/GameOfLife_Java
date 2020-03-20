package com.bootcamp.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {

  private static final Cell DEAD_CELL = new Cell(false);
  private static final Cell ALIVE_CELL = new Cell(true);
  private static final int X_STEP = 0;
  private static final int Y_STEP = 1;
  private static final char ALIVE_CELL_PATTERN = 'X';
  private int height;
  private int width;
  private ArrayList<ArrayList<Cell>> board = new ArrayList<>();

  public Board(int height, int width) {
    this.height = height;
    this.width = width;
    initialBoardWithDeadCells();
  }

  public Board(int height, int width, List<String> pattern) {
    this.height = height;
    this.width = width;
    initialBoardWithDeadCells();
    assignPatternToBoard(pattern);
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

  private void assignPatternToBoard(List<String> pattern) {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (pattern.get(y).charAt(x) == ALIVE_CELL_PATTERN) {
          setCellState(x, y, true);
        }
      }
    }
  }

  public void displayBoard() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        System.out.print(getCellAt(x, y));
      }
      System.out.println();
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

  public void updateCellNextGeneration(int x, int y, Cell cell) {
    board.get(y).set(x, cell);
  }

  private void countCellNeighbors() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int neighbors = countAliveNeighborCell(x, y);
        Cell cell = getCellAt(x, y);
        cell.setNeighbors(neighbors);
      }
    }
  }

  private void updateBoardNextGeneration() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Cell cell = getCellAt(x, y);
        updateCellNextGeneration(x, y, cell.isAliveInNextGeneration());
      }
    }
  }

  public void generateNextGeneration() {
    countCellNeighbors();
    updateBoardNextGeneration();
  }

  public boolean needExpandLeft() {
    for (int y = 0; y < height; y++) {
      if (board.get(y).get(0).equals(ALIVE_CELL)) {
        return true;
      }
    }
    return false;
  }

  public boolean needExpandRight() {
    for (int y = 0; y < height; y++) {
      if (board.get(y).get(width - 1).equals(ALIVE_CELL)) {
        return true;
      }
    }
    return false;
  }

  public boolean needExpandTop() {
    for (int x = 0; x < width; x++) {
      if (board.get(0).get(x).equals(ALIVE_CELL)) {
        return true;
      }
    }
    return false;
  }

  public boolean needExpandBottom() {
    for (int x = 0; x < width; x++) {
      if (board.get(height - 1).get(x).equals(ALIVE_CELL)) {
        return true;
      }
    }
    return false;
  }

  public void expandLeft() {
    for (int y = 0; y < height; y++) {
      board.get(y).add(0, DEAD_CELL);
    }
    width += 1;
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
