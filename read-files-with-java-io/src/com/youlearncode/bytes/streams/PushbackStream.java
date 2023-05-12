package com.youlearncode.bytes.streams;

import java.io.*;

public class PushbackStream {
  public static void readUsingPushbackInputStream() {
    byte[] bytes = "// Is product on sale?.\nif (isOnSale) System.out.println(price / 1.25);\n".getBytes();
    try (PushbackInputStream in = new PushbackInputStream(new ByteArrayInputStream(bytes), 4)) {
      int datum, nextDatum;
      boolean isComment = false;
      while ((datum = in.read()) != -1) {
        if (isComment && datum == '\n') {
          in.unread(" */\n".getBytes());
          isComment = false;
          continue;
        }
        if (datum == '/')
          if ((nextDatum = in.read()) == '/') {
            in.unread('*');
            isComment = true;
          } else {
            in.unread(nextDatum);
          }
        System.out.print((char) datum);
      }
    }
    catch (IOException e) { e.printStackTrace(); }
  }
}
