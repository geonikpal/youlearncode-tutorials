package com.codelearnhub.linkedlistmethods;

import com.codelearnhub.Helper;

import java.util.LinkedList;

public class ModifyingMethods {
  
  public static void set() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.set(6, "any Language");
    Helper.print(false, words);
  }
}