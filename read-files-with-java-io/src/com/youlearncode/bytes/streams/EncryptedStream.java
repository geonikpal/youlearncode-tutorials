package com.youlearncode.bytes.streams;

import com.youlearncode.inputstreams.DecryptInputStream;
import com.youlearncode.inputstreams.EncryptInputStream;
import com.youlearncode.tools.Helper;
import com.youlearncode.tools.TerminalPrinter;

import java.io.*;

public class EncryptedStream {
  
  public static void readUsingEncryptedInputStream() {
    if (!Helper.getEncryptedFilePath().exists()) // Note that here we are negating the check with '!'.
      try (InputStream in = new EncryptInputStream(new FileInputStream(Helper.getTextFilePath()), (byte)123)) {
        if (Helper.saveEncryptedInputStream(in.readAllBytes(), Helper.getEncryptedFilePath()))
          System.out.println("Encrypted File Saved Successfully!");
      } catch (IOException e) { e.printStackTrace(); }
    
    try (InputStream in = new DecryptInputStream(new FileInputStream(Helper.getEncryptedFilePath()), (byte)123)) {
      TerminalPrinter.print(in);
    } catch (IOException e) { e.printStackTrace(); }
  }
}