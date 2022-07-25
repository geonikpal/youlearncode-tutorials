package com.codelearnhub.interfacemethods;

import com.codelearnhub.Helper;
import com.codelearnhub.ProgrammingLanguage;

import java.util.Comparator;
import java.util.LinkedList;

public class ListInterfaceMethods {
  public static void replaceAll() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    
    // REPLACE ALL String LITERALS FOR LOWER-CASE ONES
    words.replaceAll(String::toLowerCase);
    Helper.print(false, words);
    // REPLACE ALL String LITERALS FOR UPPER-CASE ONES
    words.replaceAll(String::toUpperCase);
    Helper.print(false, words);
    // REPLACE ALL String LITERALS FOR THEIR FIRST LETTER
    words.replaceAll(s -> s.substring(0, 1));
    Helper.print(false, words);
  }
  
  public static void sort() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    // String class implements Comparable, so I don't need to use a Comparator.
    words.sort(null);
    Helper.print(false, words);
    
    LinkedList<ProgrammingLanguage> languages = Helper.getLanguages();
    Helper.print(true, languages);
    // We haven't implemented the Comparable interface, we could have, but we didn't.
    // Either Lambda Expressions or Method Reference will work.
    languages.sort(Comparator.comparing(ProgrammingLanguage::getLanguage));
    // UNCOMMENTING THE NEXT LINE WILL THROW A ClassCastException
    //languages.sort(null);
    Helper.print(false, languages);
  }
}