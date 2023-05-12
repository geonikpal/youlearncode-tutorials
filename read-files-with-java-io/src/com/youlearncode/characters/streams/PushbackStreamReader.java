package com.youlearncode.characters.streams;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PushbackStreamReader {
  public static void readUsingPushbackStreamReader() {
    String stream = "101 Cars111 Motorbikes 122 PickupTrucks131 Bus142 Scooters 190 Helicopter199Airplanes";
    Map<Integer, String> items = new HashMap<>();
    try (PushbackReader reader = new PushbackReader(new StringReader(stream))) {
      int datum, value = 0;
      while (reader.ready() && (datum = reader.read()) != -1) {
        if (Character.isWhitespace(datum)) continue;
        if (Character.isDigit(datum)) {
          // Note that the byte values for the digits '0' to '9' range from 48 to 57.
          value = datum - '0'; // Note that for every digit we multiply the value by 10. Then we add the current digit.
          while (Character.isDigit(datum = reader.read())) value = (value * 10) + (datum - '0');
        }
        if (Character.isUpperCase(datum)) {
          StringBuilder sb = new StringBuilder();
          sb.append((char) datum);
          while (Character.isLetter(datum = reader.read())) {
            // Note that this checks for compound nouns and separates them with a whitespace. See PickupTrucks -> Pickup Trucks!
            if (Character.isUpperCase(datum)) sb.append(' ');
            sb.append((char) datum);
          }
          // Note that at this point #datum is not a letter. Perhaps a digit, a whitespace or an EOF character.
          items.put(value, sb.toString());
          reader.unread(datum); // Therefore, we must un-read the character to be properly reevaluated.
        }
      }
      System.out.println(items);
    }
    catch (IOException e) { e.printStackTrace(); }
  }
}
