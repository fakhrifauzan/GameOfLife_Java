package com.bootcamp.gameoflife;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

  FileReader fileReader;

  public Reader(String patternFile) throws FileNotFoundException {
    fileReader = new FileReader(patternFile);
  }

  public List<String> readPattern() throws IOException {
    String line;
    List<String> pattern = new ArrayList<>();
    BufferedReader reader = new BufferedReader(fileReader);
    while ((line = reader.readLine()) != null) {
      pattern.add(line);
    }
    reader.close();
    return pattern;
  }
}
