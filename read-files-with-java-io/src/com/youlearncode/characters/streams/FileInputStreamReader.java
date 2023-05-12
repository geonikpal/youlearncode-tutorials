package com.youlearncode.characters.streams;

import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.*;

public class FileInputStreamReader {
  public static void readUsingInputStreamReader() {
    try (InputStream in = new FileInputStream(Helper.getGlobalDataFilePath());
         Reader reader = new InputStreamReader(in)) {
      TerminalPrinter.print(reader);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
