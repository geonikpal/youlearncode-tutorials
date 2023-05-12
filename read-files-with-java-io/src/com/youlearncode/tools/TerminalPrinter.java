package com.youlearncode.tools;

import java.io.*;

public class TerminalPrinter {
  
  public static void print(InputStream in) throws IOException {
    int datum;
    while ((datum = in.read()) != -1) System.out.print((char)datum);
    System.out.println();
  }
  
  public static void print(Reader in) throws IOException {
    int datum;
    while ((datum = in.read()) != -1) System.out.print((char)datum);
    System.out.println();
  }
}