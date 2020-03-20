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
}