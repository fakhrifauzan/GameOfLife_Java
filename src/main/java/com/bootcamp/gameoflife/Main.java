package com.bootcamp.gameoflife;

import java.io.IOException;
import java.util.List;

public class Main {

  private static final int PATH_INDEX = 0;

  public static void main(String[] args) throws IOException, InterruptedException {
    Board board;
    String path = args[PATH_INDEX];
    Reader reader = new Reader(path);
    List<String> pattern = reader.readPattern();
    int height = pattern.size();
    int width = pattern.get(0).length();
    board = new Board(height, width, pattern);
    board.displayBoard();
    tick(board);
  }

  private static void tick(Board board) throws InterruptedException {
    int generation = 1;
    while (true) {
      System.out.println("=== GENERATION " + generation + " ===");
      board.displayBoard();
      generation += 1;
      clearScreen();
    }
  }

  private static void clearScreen() throws InterruptedException {
    Thread.sleep(500);
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
