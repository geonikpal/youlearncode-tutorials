package com.youlearncode.characters.streams;

import com.youlearncode.tools.Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedStreamReader {
  public static void readUsingBufferedReader() {
    try (BufferedReader reader = new BufferedReader(new FileReader(Helper.getGlobalTextFilePath(), StandardCharsets.UTF_8))) {
      for (String line = reader.readLine(); line != null; line = reader.readLine())
        System.out.println(line);
    }
    catch (IOException e) { e.printStackTrace(); }
  }
}
