package com.youlearncode.characters.streams;

import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

public class CharArrayStreamReader {
  public static void readUsingCharArrayReader() {
    try (Reader reader = new CharArrayReader(Helper.getText().toCharArray())) {
      TerminalPrinter.print(reader);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
