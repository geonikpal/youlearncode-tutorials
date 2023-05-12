package com.youlearncode.bytes.streams;

import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileStream {
  public static void readUsingFileInputStream() {
    try (InputStream in = new FileInputStream(Helper.getTextFilePath())) {
      TerminalPrinter.print(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void readNonASCIIUsingFileInputStream() {
    try (InputStream in = new FileInputStream(Helper.getGlobalTextFilePath())) {
      TerminalPrinter.print(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
