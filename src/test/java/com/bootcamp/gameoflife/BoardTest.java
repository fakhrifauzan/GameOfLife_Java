package com.bootcamp.gameoflife;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

  private Board createBoardWithPattern(List<String> pattern) {
    int height = pattern.size();
    int width = pattern.get(0).length();
    return new Board(height, width, pattern);
  }

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

  @Test
  public void givenOneAliveNeighborInRightCountAliveNeighborCellShouldReturnOne() {
    Board board = new Board(4, 4);
    board.setCellState(2, 1, true);
    board.setCellState(1, 1, true);
    Assert.assertEquals(1, board.countAliveNeighborCell(1, 1));
  }

  @Test
  public void givenOneAliveNeighborOnTopCountAliveNeighborCellShouldReturnOne() {
    Board board = new Board(4, 4);
    board.setCellState(1, 0, true);
    board.setCellState(1, 1, true);
    Assert.assertEquals(1, board.countAliveNeighborCell(1, 1));
  }

  @Test
  public void givenOneAliveNeighborOnBottomCountAliveNeighborCellShouldReturnOne() {
    Board board = new Board(4, 4);
    board.setCellState(1, 1, true);
    board.setCellState(1, 2, true);
    Assert.assertEquals(1, board.countAliveNeighborCell(1, 1));
  }

  @Test
  public void givenOneAliveNeighborOnDiagonalTopLeftCountAliveNeighborCellShouldReturnOne() {
    Board board = new Board(4, 4);
    board.setCellState(1, 1, true);
    board.setCellState(0, 0, true);
    Assert.assertEquals(1, board.countAliveNeighborCell(1, 1));
  }

  @Test
  public void givenOneAliveNeighborOnDiagonalTopRightCountAliveNeighborCellShouldReturnOne() {
    Board board = new Board(4, 4);
    board.setCellState(1, 1, true);
    board.setCellState(2, 0, true);
    Assert.assertEquals(1, board.countAliveNeighborCell(1, 1));
  }

  @Test
  public void givenOneAliveNeighborOnDiagonalBottomLeftCountAliveNeighborCellShouldReturnOne() {
    Board board = new Board(4, 4);
    board.setCellState(1, 1, true);
    board.setCellState(0, 2, true);
    Assert.assertEquals(1, board.countAliveNeighborCell(1, 1));
  }

  @Test
  public void givenOneAliveNeighborOnDiagonalBottomRightCountAliveNeighborCellShouldReturnOne() {
    Board board = new Board(4, 4);
    board.setCellState(1, 1, true);
    board.setCellState(2, 2, true);
    Assert.assertEquals(1, board.countAliveNeighborCell(1, 1));
  }

  @Test
  public void givenRaiseIndexOfBoundExceptionWhenGetCellAtShouldReturnDeadCell() {
    Board board = new Board(1, 1);
    Cell deadCell = new Cell(false);
    Assert.assertEquals(deadCell, board.getCellAt(1, 1));
  }

  @Test
  public void givenTwoBoardWithBlockPatternTheBoardEqualsShouldReturnTrue() {
    Board board1 = new Board(4, 4);
    board1.setCellState(1, 1, true);
    board1.setCellState(1, 2, true);
    board1.setCellState(2, 1, true);
    board1.setCellState(2, 2, true);
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "_XX_", "_XX_", "____"));
    Board board2 = createBoardWithPattern(pattern);
    Assert.assertEquals(board1, board2);
  }

  @Test
  public void testDisplayBoardWithBlockPattern() {
    ByteArrayOutputStream stdout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdout));
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "_XX_", "_XX_", "____"));
    Board board = createBoardWithPattern(pattern);
    board.displayBoard();
    String expectedPattern = "____\n" + "_XX_\n" + "_XX_\n" + "____\n";
    Assert.assertEquals(expectedPattern, stdout.toString());
    System.setOut(System.out);
  }

  @Test
  public void givenDeadCellBoardUpdateCellNextGenerationWithAliveCellShouldReturnAliveCell() {
    Board board = new Board(2, 2);
    Cell aliveCell = new Cell(true);
    board.updateCellNextGeneration(1, 1, aliveCell);
    Assert.assertEquals(aliveCell, board.getCellAt(1, 1));
  }

  @Test
  public void givenToadPatternBoardInSecondNextGenerationBoardEqualsShouldReturnTrue() {
    List<String> pattern = new ArrayList<>(
        Arrays.asList("______", "______", "__XXX_", "_XXX__", "______", "______"));
    int height = pattern.size();
    int width = pattern.get(0).length();
    Board board = new Board(height, width, pattern);
    board.generateNextGeneration();
    board.generateNextGeneration();
    Board expectedBoard = new Board(height, width);
    Assert.assertEquals(expectedBoard, board);
  }

  @Test
  public void givenAllDeadCellInBorderLeftNeedExpandLeftShouldReturnFalse() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "_X__", "____"));
    Board board = createBoardWithPattern(pattern);
    Assert.assertFalse(board.needExpandLeft());
  }

  @Test
  public void givenSomeAliveCellInBorderLeftNeedExpandLeftShouldReturnTrue() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "X___", "____"));
    Board board = createBoardWithPattern(pattern);
    Assert.assertTrue(board.needExpandLeft());
  }

  @Test
  public void givenDeadCellInBorderRightNeedExpandRightShouldReturnFalse() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "_X__", "____"));
    Board board = createBoardWithPattern(pattern);
    Assert.assertFalse(board.needExpandRight());
  }

  @Test
  public void givenAliveCellInBorderRightNeedExpandRightShouldReturnTrue() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "___X", "____"));
    Board board = createBoardWithPattern(pattern);
    Assert.assertTrue(board.needExpandRight());
  }

  @Test
  public void givenAllDeadCellInBorderTopNeedExpandTopShouldReturnFalse() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "_X__", "____"));
    Board board = createBoardWithPattern(pattern);
    Assert.assertFalse(board.needExpandTop());
  }

  @Test
  public void givenSomeAliveCellInBorderTopNeedExpandTopShouldReturnTrue() {
    List<String> pattern = new ArrayList<>(Arrays.asList("_XX_", "____", "____"));
    Board board = createBoardWithPattern(pattern);
    Assert.assertTrue(board.needExpandTop());
  }

  @Test
  public void givenAllDeadCellInBorderBottomNeedExpandBottomShouldReturnFalse() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "_X__", "____"));
    Board board = createBoardWithPattern(pattern);
    Assert.assertFalse(board.needExpandBottom());
  }

  @Test
  public void givenSomeAliveCellInBorderBottomNeedExpandBottomShouldReturnTrue() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "____", "_XX_"));
    Board board = createBoardWithPattern(pattern);
    Assert.assertTrue(board.needExpandBottom());
  }

  @Test
  public void givenSomeAliveCellInBorderLeftExpandLeftShouldIncreasingWidthByOne() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "X___", "____"));
    Board board = createBoardWithPattern(pattern);
    board.expandLeft();
    int height = pattern.size();
    Board expectedBoard = new Board(height, 5);
    Assert.assertEquals(expectedBoard, board);
  }

  @Test
  public void givenSomeAliveCellInBorderRightExpandRightShouldIncreaseWidthByOne() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "___X", "____"));
    Board board = createBoardWithPattern(pattern);
    board.expandRight();
    int height = pattern.size();
    Board expectedBoard = new Board(height, 5);
    Assert.assertEquals(expectedBoard, board);
  }

  @Test
  public void givenSomeAliveCellInBorderTopExpandTopShouldIncreaseHeightByOne() {
    List<String> pattern = new ArrayList<>(Arrays.asList("__X_", "____", "____"));
    Board board = createBoardWithPattern(pattern);
    board.expandTop();
    int width = pattern.get(0).length();
    Board expectedBoard = new Board(4, width);
    Assert.assertEquals(expectedBoard, board);
  }

  @Test
  public void givenSomeAliveCellInBorderBottomExpandBottomShouldIncreaseHeightByOne() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "____", "_X__"));
    Board board = createBoardWithPattern(pattern);
    board.expandBottom();
    int width = pattern.get(0).length();
    Board expectedBoard = new Board(4, width);
    Assert.assertEquals(expectedBoard, board);
  }

  @Test
  public void givenSomeAliveCellInBorderLeftExpandBoardShouldExpandLeftAndIncreaseWidthByOne() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "X___", "____"));
    Board board = createBoardWithPattern(pattern);
    board.expandBoard();
    int height = pattern.size();
    Board expectedBoard = new Board(height, 5);
    Assert.assertEquals(expectedBoard, board);
  }

  @Test
  public void givenAllDeadCellInBorderLeftExpandBoardShouldNotExpandLeft() {
    List<String> pattern = new ArrayList<>(Arrays.asList("____", "_XX_", "____"));
    Board board = createBoardWithPattern(pattern);
    board.expandBoard();
    int height = pattern.size();
    Board expectedBoard = new Board(height, 4);
    Assert.assertEquals(expectedBoard, board);
  }

  @Test
  public void givenSomeAliveCellInBorderTopExpandBoardShouldExpandTopAndIncreaseHeightByOne() {
    List<String> pattern = new ArrayList<>(Arrays.asList("_XX_", "____", "____"));
    Board board = createBoardWithPattern(pattern);
    board.expandBoard();
    int width = pattern.get(0).length();
    Board expectedBoard = new Board(4, width);
    Assert.assertEquals(expectedBoard, board);
  }
}
