package com.youlearncode.bytes.streams;

import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayStream {
  
  public static void readUsingByteArrayInputStream() {
    // Note that we are passing our method getByteArray rather than an InputStream.
    try (InputStream in = new ByteArrayInputStream(Helper.getByteArray(Helper.getTextFilePath()))) {
      TerminalPrinter.print(in);
    } catch (IOException e) { e.printStackTrace(); }
  }
}
