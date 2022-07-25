package com.codelearnhub.abstractclassmethods;

import com.codelearnhub.Helper;

import java.util.LinkedList;

public class AbstractCollectionMethods {
  
  // Using toString() would conflict with Object toString() method.
  public static void toStringy() {
    LinkedList<String> words = Helper.getWords();
    // IT IS UNNECESSARY TO CALL THE toString() METHOD EXPLICITLY
    // WE ARE DOING SO FOR PEDAGOGICAL PURPOSES
    System.out.println(words.toString());
  }
  
  public static void retainAll() {
    LinkedList<String> words = Helper.getWords();
    LinkedList<String> subWords = new LinkedList<>(words.subList(0, 3));
    
    Helper.print(true, words);
    Helper.print(true, subWords);
    
    if (words.retainAll(subWords))
      System.out.println("ALL EQUAL ELEMENTS WERE RETAINED!");
    Helper.print(false, words);
  }
  
  public static void removeALl() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    
    if (!words.isEmpty())
      if (words.removeAll(words)) // true IF AT LEAST ONE ELEMENT IS REMOVED.
        Helper.print(false, words);
  }
  
  public static void isEmpty() {
    removeALl();
  }
  
  public static void containsAll() {
    LinkedList<String> words = Helper.getWords();
    LinkedList<String> subWords = new LinkedList<>(words.subList(0, 3));
    Helper.print(true, words);
    Helper.print(true, subWords);
    
    // UNCOMMENT THIS SO containsALL WILL RETURN FALSE.
    // subWords.set(0, "CODE"); // Code is not equal to CODE.
    
    // IF words CONTAIN ALL ELEMENTS IN subWords, THEN true.
    if (words.containsAll(subWords)) {
      System.out.println("ALL ELEMENTS WERE CONTAINED!");
      subWords.forEach(System.out::println);
    }
  }
}
