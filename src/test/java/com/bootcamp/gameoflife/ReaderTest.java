package com.bootcamp.gameoflife;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ReaderTest {

  @Test
  public void testReadPatternFromFileWithBuffered() throws IOException {
    Reader reader = new Reader("./pattern/block.txt");
    List<String> expectedPattern = new ArrayList<>(
        Arrays.asList("____", "_XX_", "_XX_", "____"));
    Assert.assertEquals(expectedPattern, reader.readPattern());
  }
}
