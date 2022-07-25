package com.codelearnhub.linkedlistmethods;

import com.codelearnhub.Helper;

import java.util.LinkedList;

public class UsefulMethods {
  
  public static void clear() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.clear();
    Helper.print(false, words);
  }
  
  public static void size() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("LinkedList size is: " + words.size());
    words.remove(4);
    Helper.print(false, words);
    System.out.println("LinkedList size is: " + words.size());
  }
  
  public static void lastIndexOf() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    int index = words.indexOf("Learn");
    int lastIndex = words.lastIndexOf("Learn");
    System.out.println("The FIRST index of \"" + words.get(index) + "\" is: " + index);
    System.out.println("The LAST index of \"" + words.get(lastIndex) + "\" is: " + lastIndex);
  }
  
  public static void indexOf() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    int index = words.indexOf("You");
    System.out.println("The index of \"" + words.get(index) + "\" is: " + index);
  }
  
  public static void contains() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Contains element: " + words.contains("Learn"));
    System.out.println("Contains element: " + words.contains(null));
  }
}
