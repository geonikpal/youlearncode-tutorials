package com.youlearncode.bytes.streams;

import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.*;
import java.util.*;

public class SequenceStream {
  public static void readUsingSequenceInputStream() {
    try (InputStream in1 = new FileInputStream(Helper.getTextFilePart1Path());
         InputStream in2 = new FileInputStream(Helper.getTextFilePart2Path());
         InputStream in3 = new FileInputStream(Helper.getTextFilePart3Path())) {
      SequenceInputStream seq = new SequenceInputStream(in1, in2);
      // Note that here we pass SequenceInputStream + FileInputStream
      SequenceInputStream sequence = new SequenceInputStream(seq, in3);
      TerminalPrinter.print(sequence);
    } catch (IOException e) { e.printStackTrace(); }
  }
  
  public static void readUsingSequenceInputStreamVector() {
    Vector<InputStream> vector = new Vector<>(3);
    // Also, it works with different InputStream implementations.
    try (InputStream in1 = new FileInputStream(Helper.getTextFilePart1Path());
         InputStream in2 = new FileInputStream(Helper.getTextFilePart2Path());
         InputStream in3 = new BufferedInputStream(new FileInputStream(Helper.getTextFilePart3Path()))) {
      vector.addAll(Arrays.asList(in1, in2, in3));
      SequenceInputStream sequence = new SequenceInputStream(vector.elements());
      TerminalPrinter.print(sequence);
    } catch (IOException e) { e.printStackTrace(); }
  }
}
