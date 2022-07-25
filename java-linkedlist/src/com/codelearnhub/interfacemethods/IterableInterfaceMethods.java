package com.codelearnhub.interfacemethods;

import com.codelearnhub.Helper;

import java.util.LinkedList;

public class IterableInterfaceMethods {
  
  public static void forEach() {
    LinkedList<String> words = Helper.getWords();
    words.forEach(k -> System.out.println(k.toUpperCase())); // LAMBDA
    System.out.println();
    words.forEach(System.out::println); // METHOD REFERENCE
  }
}
