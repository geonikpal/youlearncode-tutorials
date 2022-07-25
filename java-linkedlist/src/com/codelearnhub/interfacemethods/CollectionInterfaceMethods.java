package com.codelearnhub.interfacemethods;

import com.codelearnhub.Helper;
import com.codelearnhub.ProgrammingLanguage;

import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionInterfaceMethods {
  
  public static void parallelStream() {
    LinkedList<ProgrammingLanguage> pLanguages = new LinkedList<>();
    for (int i = 1; i <= 100; i++) {
      pLanguages.add(new ProgrammingLanguage("Language-"+i));
    }
    calculateTimeTaken(pLanguages, "Stream Average: ", false);
    calculateTimeTaken(pLanguages, "Parallel Stream Average: ", true);
  }
  
  public static void calculateTimeTaken(
    LinkedList<ProgrammingLanguage> pLanguages, String streamingType, boolean isParallel) {
    long startTime = 0;
    long endTime = 0;
    startTime = System.currentTimeMillis();
    Stream<ProgrammingLanguage> average = null;
    if (!isParallel) {
      average = pLanguages.stream(); // CREATES A SEQUENTIAL STREAM
      //average.parallel(); // TURN AN EXITING SEQUENTIAL STREAM INTO PARALLEL
    } else {
      average = pLanguages.parallelStream(); // CREATES A PARALLEL STREAM
    }
    // Do a bunch of nonsensical stuff that takes some time...
    var result =
      average.map(k -> k.getLanguage().substring(8))
        .flatMapToInt(n -> IntStream.of(Integer.parseInt(n)))
        .average();
    System.out.printf(streamingType + "%.2f\n", result.isPresent() ? result.getAsDouble()*-1 : -1);
    endTime = System.currentTimeMillis();
    System.out.println("Time Taken: " + (endTime - startTime));
  }
  
  public static void stream() {
    LinkedList<ProgrammingLanguage> languages = Helper.getLanguages();
    Helper.print(true, languages); // LINKED LIST OF PROGRAMMING LANGUAGES
    // CREATE STREAM -> CHANGE INTO STRING -> SORT -> CONVERT INTO AN ARRAY (FINAL OPERATION)
    String[] array = languages.stream() // Stream<ProgrammingLanguage>
      .map(String::valueOf) // Stream<String>
      .sorted() // Sorted Stream in natural order
      .toArray(String[]::new); // Final Operation convert to Array.
    Helper.print(false, array); // RESULT: AN ARRAY OF STRINGS
  }
  
  public static void toArrayWithIntFunction() {
    System.out.println("LINKED LIST");
    LinkedList<ProgrammingLanguage> languages = Helper.getLanguages();
    Helper.print(true, languages); // LINKED LIST
    
    ProgrammingLanguage[] languagesArray = languages.toArray(ProgrammingLanguage[]::new);
    System.out.println("ARRAY");
    Helper.print(true, languagesArray); // ARRAY
    // SETTING WILL REFLECT ON BOTH
    languagesArray[3].setLanguage("Python"); // CHANGING LANGUAGE ON THE ARRAY
    System.out.println("LINKED LIST");
    Helper.print(false, languages);
  }
  
  public static void removeIf() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.removeIf(s -> s.startsWith("Y")); // IF ANY OF THE WORDS STARTS WITH A CAPITAL Y
    Helper.print(false, words);
    words.removeIf(s -> s.contains("e")); // IF ANY OF THE WORDS CONTAIN A SMALL e
    Helper.print(false, words);
    words.removeIf(s -> s.length() == 3); // IF THE length OF THE WORD EQUALS 3
    Helper.print(false, words);
  }
}
