package com.youlearncode.characters.streams;

import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class StringStreamReader {
  public static void readUsingStringReader() {
    try (Reader reader = new StringReader(Helper.getText())) {
      TerminalPrinter.print(reader);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
