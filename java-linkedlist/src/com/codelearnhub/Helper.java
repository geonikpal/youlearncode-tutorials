package com.codelearnhub;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Helper {
  public static void print(boolean before, List<?> list) {
    System.out.print(before ? "Before: " : "After: ");
    for (int i = 0; i < list.size(); i++) {
      if (i == list.size() - 1) {
        System.out.println(list.get(i) + "!");
        return;
      }
      System.out.print(list.get(i) + " ");
    }
  }
  
  public static void print(boolean before, Object[] array) {
    print(before, Arrays.stream(array).toList());
  }
  
  public static LinkedList<String> getWords() {
    return new LinkedList<>(){{
      add("Code");
      add("Learn");
      add("Hub");
      add("Helps");
      add("You");
      add("Learn");
      add("Java");
    }};
  }
  public static LinkedList<ProgrammingLanguage> getLanguages() {
    return new LinkedList<>() {{
      add(new ProgrammingLanguage("Java"));
      add(new ProgrammingLanguage("C#"));
      add(new ProgrammingLanguage("Swift"));
      add(new ProgrammingLanguage("C++"));
    }};
  }
}
