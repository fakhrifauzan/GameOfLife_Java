package com.bootcamp.gameoflife;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

  @Test
  public void givenSameBoardObjectEqualsShouldReturnTrue() {
    Board board = new Board(2, 2);
    Assert.assertEquals(board, board);
  }
}
