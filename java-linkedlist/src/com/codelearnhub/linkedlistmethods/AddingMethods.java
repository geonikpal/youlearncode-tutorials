package com.codelearnhub.linkedlistmethods;

import com.codelearnhub.Helper;

import java.util.LinkedList;

public class AddingMethods {
  
  public static void offerLast() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.offerLast("... Awesome");
    Helper.print(false, words);
  }
  
  public static void offerFirst() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.offerFirst("Hey,");
    Helper.print(false, words);
  }
  
  public static void offer() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    words.offer("... Awesome");
    Helper.print(false, words);
  }
  
  public static void addAll() {
    addAllStartingAtIndex();
  }
  
  public static void addAllStartingAtIndex() {
    LinkedList<String> words = new LinkedList<>();
    words.add("Hey,");
    Helper.print(true, words);
    words.addAll(words.size(), Helper.getWords());
    Helper.print(false, words);
  }
  
  public static void addAtIndex() {
    LinkedList<String> words = new LinkedList<>();
    words.add(0, "Hub");
    words.add(0, "Learn");
    words.add(0, "Code");
    System.out.println(words);
  }
  
  public static void push() {
    LinkedList<String> words = new LinkedList<>();
    words.push("Hub");
    words.push("Learn");
    words.push("Code");
    System.out.println(words);
  }
  
  public static void addFirst() {
    LinkedList<String> words = new LinkedList<>();
    words.addFirst("Hub");
    words.addFirst("Learn");
    words.addFirst("Code");
    System.out.println(words);
  }
  
  public static void addLast() {
    LinkedList<String> words = new LinkedList<>();
    words.addLast("Code");
    words.addLast("Learn");
    words.addLast("Hub");
    System.out.println(words);
  }
  
  public static void add() {
    LinkedList<String> words = new LinkedList<>();
    words.add("Code");
    words.add("Learn");
    words.add("Hub");
    System.out.println(words);
  }
}
