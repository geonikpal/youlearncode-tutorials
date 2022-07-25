package com.codelearnhub.linkedlistmethods;

import com.codelearnhub.Helper;

import java.util.LinkedList;

public class RemovingMethods {
  
  public static void pop() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.pop();
    Helper.print(false, words);
  }
  
  public static void removeLastOccurrence() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.removeLastOccurrence("Learn");
    Helper.print(false, words);
  }
  
  public static void removeFirstOccurrence() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.removeFirstOccurrence("Learn");
    Helper.print(false, words);
  }
  
  public static void removeAtIndex() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.remove(4);
    Helper.print(false, words);
  }
  
  public static void removeElement() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.remove("You");
    Helper.print(false, words);
  }
  
  public static void removeLast() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.removeLast();
    Helper.print(false, words);
  }
  
  public static void removeFirst() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.removeFirst();
    Helper.print(false, words);
  }
  
  public static void remove() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.remove();
    Helper.print(false, words);
  }
}
