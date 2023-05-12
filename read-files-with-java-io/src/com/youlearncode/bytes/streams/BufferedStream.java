package com.youlearncode.bytes.streams;

import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedStream {
  public static void readUsingBufferedInputStream() {
    // Note that it requires an InputStream object which requires a File object.
    try (InputStream in = new BufferedInputStream(new FileInputStream(Helper.getTextFilePath()))) {
      TerminalPrinter.print(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
