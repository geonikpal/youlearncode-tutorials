package com.youlearncode.characters.streams;

import com.youlearncode.tools.Helper;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;

public class LineNumberStreamReader {
  public static void readUsingLineNumberReader() {
    try (LineNumberReader reader = new LineNumberReader(new FileReader(Helper.getGlobalTextFilePath(), StandardCharsets.UTF_8))) {
      for (String line = reader.readLine(); line != null; line = reader.readLine())
        System.out.println(reader.getLineNumber() + " - " + line);
    }
    catch (IOException e) { e.printStackTrace(); }
  }
}
