package com.youlearncode.characters.streams;

import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class PipedStreamReader {
  public static void readUsingPipedReader() {
    PipedWriter out = new PipedWriter();
    Runnable runnableOut = getPipedWriterRunnable(out);
    new Thread(runnableOut).start();
    
    Runnable runnableIn = getPipedReaderRunnable(out);
    new Thread(runnableIn).start();
  }
  
  private static Runnable getPipedWriterRunnable(PipedWriter writer) {
    return () -> {
      try (writer; Scanner scan = new Scanner(Helper.getGlobalTextFilePath())) {
        for (String line = scan.nextLine(); ; line = scan.nextLine()) {
          writer.write(line);
          if (scan.hasNextLine()) writer.write("\n");
          else break;
          try { Thread.sleep(5000); }
          catch (InterruptedException e) { e.printStackTrace(); }
        }
      }
      catch (IOException e) { e.printStackTrace(); }
    };
  }
  
  private static Runnable getPipedReaderRunnable(PipedWriter out) {
    return () -> {
      try (PipedReader reader = new PipedReader(out)) {
        TerminalPrinter.print(reader);
      }
      catch (IOException e) { e.printStackTrace(); }
    };
  }
}
