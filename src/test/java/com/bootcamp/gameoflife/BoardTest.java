package com.bootcamp.gameoflife;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

  @Test
  public void givenSameBoardObjectEqualsShouldReturnTrue() {
    Board board = new Board(2, 2);
    Assert.assertEquals(board, board);
  }

  @Test
  public void givenBoardObjectAndNullShouldReturnFalse() {
    Board board = new Board(2, 2);
    Assert.assertNotEquals(board, null);
  }

  @Test
  public void givenBoardObjectAndNonBoardObjectShouldReturnFalse() {
    Board board = new Board(2, 2);
    Assert.assertNotEquals(board, 1);
  }

  @Test
  public void givenTwoBoardObjectWithDifferentHeightShouldReturnFalse() {
    Board board1 = new Board(2, 2);
    Board board2 = new Board(4, 2);
    Assert.assertNotEquals(board1, board2);
  }

  @Test
  public void givenTwoBoardObjectWithDifferentWidthShouldReturnFalse() {
    Board board1 = new Board(2, 2);
    Board board2 = new Board(2, 4);
    Assert.assertNotEquals(board1, board2);
  }

  @Test
  public void givenTwoBoardObjectWithSameParamsShouldHaveSameHashCode() {
    Board board1 = new Board(2, 2);
    Board board2 = new Board(2, 2);
    Assert.assertEquals(board1.hashCode(), board2.hashCode());
  }

  @Test
  public void givenBoard2Comma2WithAllDeadCellGetCellAt1Comma1ShouldReturnDeadCell() {
    Board board = new Board(2, 2);
    Cell deadCell = new Cell(false);
    Assert.assertEquals(deadCell, board.getCellAt(1, 1));
  }

  @Test
  public void givenBoard2X2WithSetCellAt1Comma1WithAliveCellShouldReturnAliveCellOn1Comma1() {
    Board board = new Board(2, 2);
    Cell aliveCell = new Cell(true);
    board.setCellState(1, 1, true);
    Assert.assertEquals(aliveCell, board.getCellAt(1, 1));
  }

  @Test
  public void givenBoard2X2WithAllDeadCellGetCellStateShouldReturnZero() {
    Board board = new Board(2, 2);
    Assert.assertEquals(0, board.getCellState(1, 1));
  }

  @Test
  public void givenBoard2X2WithGetCellState1Comma1WithAliveCellShouldReturnOneOn1Comma1() {
    Board board = new Board(2, 2);
    board.setCellState(1, 1, true);
    Assert.assertEquals(1, board.getCellState(1, 1));
  }

  @Test
  public void givenOneAliveNeighborInLeftCountAliveNeighborCellShouldReturnOne() {
    Board board = new Board(4, 4);
    board.setCellState(0, 1, true);
    board.setCellState(1, 1, true);
    Assert.assertEquals(1, board.countAliveNeighborCell(1, 1));
  }
}
