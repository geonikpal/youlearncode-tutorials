package com.youlearncode.characters.streams;

import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileStreamReader {
  
  public static void readUsingFileReader() {
    try (Reader reader =
      new FileReader(Helper.getGlobalTextFilePath(), StandardCharsets.UTF_8)) {
      TerminalPrinter.print(reader);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
