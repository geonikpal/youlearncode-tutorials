package com.codelearnhub.linkedlistmethods;

import com.codelearnhub.Helper;

import java.util.LinkedList;

public class RetrievingMethods {
  
  public static void pollLast() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Element retrieved: " + words.pollLast());
    Helper.print(false, words);
  }
  
  public static void pollFirst() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Element retrieved: " + words.pollFirst());
    Helper.print(false, words);
  }
  
  public static void poll() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Element retrieved: " + words.poll());
    Helper.print(false, words);
  }
  
  public static void peekLast() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Element retrieved: " + words.peekLast());
    Helper.print(false, words);
  }
  
  public static void peekFirst() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Element retrieved: " + words.peekFirst());
    Helper.print(false, words);
  }
  
  public static void peek() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Element retrieved: " + words.peek());
    Helper.print(false, words);
  }
  
  public static void element() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Element retrieved: " + words.element());
    Helper.print(false, words);
  }
  
  public static void getLast() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Element retrieved: " + words.getLast());
    Helper.print(false, words);
  }
  
  public static void getFirst() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Element retrieved: " + words.getFirst());
    Helper.print(false, words);
  }
  
  public static void getAtIndex() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    System.out.println("Element retrieved: " + words.get(6));
    Helper.print(false, words);
  }
}