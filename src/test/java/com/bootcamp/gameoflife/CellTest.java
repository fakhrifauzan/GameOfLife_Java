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

  @Test
  public void givenCellObjectAndNonCellObjectEqualsShouldReturnFalse() {
    Cell cell = new Cell(true);
    Assert.assertNotEquals(cell, 1);
  }

  @Test
  public void givenCellObjectWithSameParametersEqualsShouldReturnTrue() {
    Cell cell1 = new Cell(true);
    Cell cell2 = new Cell(true);
    Assert.assertEquals(cell1, cell2);
  }

  @Test
  public void givenCellObjectWithDifferentParametersEqualsShouldReturnFalse() {
    Cell cell1 = new Cell(true);
    Cell cell2 = new Cell(false);
    Assert.assertNotEquals(cell1, cell2);
  }

  @Test
  public void givenCellObjectWithSameParametersShouldHaveSameHashCode() {
    Cell cell1 = new Cell(true);
    Cell cell2 = new Cell(true);
    Assert.assertEquals(cell1.hashCode(), cell2.hashCode());
  }

  @Test
  public void givenAliveCellToStringShouldReturnX() {
    Cell cell = new Cell(true);
    Assert.assertEquals("X", cell.toString());
  }

  @Test
  public void givenDeadCellToStringShouldReturnUnderscore() {
    Cell cell = new Cell(false);
    Assert.assertEquals("_", cell.toString());
  }

  @Test
  public void givenCellThatNotHaveAliveNeighborShouldReturnDeadCellInNextGeneration() {
    Cell cell = new Cell(false);
    cell.setNeighbors(0);
    Assert.assertEquals(new Cell(false), cell.isAliveInNextGeneration());
  }

  @Test
  public void givenDeadCellWith3AliveNeighborShouldReturnAliveCellInNextGeneration() {
    Cell cell = new Cell(false);
    cell.setNeighbors(3);
    Assert.assertEquals(new Cell(true), cell.isAliveInNextGeneration());
  }

  @Test
  public void givenAliveCellWith1AliveNeighborShouldReturnDeadCellInNextGeneration() {
    Cell cell = new Cell(true);
    cell.setNeighbors(1);
    Assert.assertEquals(new Cell(false), cell.isAliveInNextGeneration());
  }

  @Test
  public void givenAliveCellWith2AliveNeighborShouldReturnAliveCellInNextGeneration() {
    Cell cell = new Cell(true);
    cell.setNeighbors(2);
    Assert.assertEquals(new Cell(true), cell.isAliveInNextGeneration());
  }

  @Test
  public void givenAliveCellWith3AliveNeighborShouldReturnAliveCellInNextGeneration() {
    Cell cell = new Cell(true);
    cell.setNeighbors(3);
    Assert.assertEquals(new Cell(true), cell.isAliveInNextGeneration());
  }
}
