package com.youlearncode.bytes.streams;

import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

public class PipedStream {
  public static void readUsingPipedInputStream() {
    PipedOutputStream out = new PipedOutputStream();
    Runnable runnableOut = getPipedOutputStreamRunnable(out);
    new Thread(runnableOut).start();
    
    Runnable runnableIn = getPipedInputStreamRunnable(out);
    new Thread(runnableIn).start();
  }
  
  private static Runnable getPipedOutputStreamRunnable(PipedOutputStream out) {
    return () -> {
      // Note that we used try-with-resources introduced in JDK7.
      try (out; Scanner scan = new Scanner(Helper.getTextFilePath())) {
        while (scan.hasNextLine()) {
          out.write(scan.nextLine().getBytes());
          if (scan.hasNextLine()) out.write("\n".getBytes());
          try { Thread.sleep(1000); }
          catch (InterruptedException e) { e.printStackTrace(); }
        }
        out.flush();
      }
      catch (IOException e) { e.printStackTrace(); }
    };
  }
  
  private static Runnable getPipedInputStreamRunnable(PipedOutputStream out) {
    return () -> {
      try (PipedInputStream in = new PipedInputStream(out)) {
        TerminalPrinter.print(in);
      }
      catch (IOException e) { e.printStackTrace(); }
    };
  }
}
