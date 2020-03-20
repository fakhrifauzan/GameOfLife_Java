package com.bootcamp.gameoflife;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {

  @Test
  public void givenSameCellObjectEqualsShouldReturnTrue() {
    Cell cell = new Cell(true);
    Assert.assertEquals(cell, cell);
  }

  @Test
  public void givenCellObjectAndNullEqualsShouldReturnFalse() {
    Cell cell = new Cell(true);
    Assert.assertNotEquals(cell, null);
  }
}
