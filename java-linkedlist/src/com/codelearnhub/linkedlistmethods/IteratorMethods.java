package com.codelearnhub.linkedlistmethods;

import com.codelearnhub.Helper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IteratorMethods {
  
  public static void spliterator() {
    // A range large enough so it will be split.
    LinkedList<Integer> numbers =
      IntStream.range(0, 1050).boxed().collect(Collectors.toCollection(LinkedList::new));
    
    Helper.print(true, numbers);
    
    Spliterator<Integer> spliterator = numbers.spliterator();
    System.out.println("Is Concurrent: " + spliterator.hasCharacteristics(Spliterator.CONCURRENT));
    System.out.println("Is Distinct: " + spliterator.hasCharacteristics(Spliterator.DISTINCT));
    System.out.println("Is Immutable: " + spliterator.hasCharacteristics(Spliterator.IMMUTABLE));
    System.out.println("Is Nonnull: " + spliterator.hasCharacteristics(Spliterator.NONNULL));
    System.out.println("Is Ordered: " + spliterator.hasCharacteristics(Spliterator.ORDERED));
    System.out.println("Is Sized: " + spliterator.hasCharacteristics(Spliterator.SIZED));
    System.out.println("Is Sorted: " + spliterator.hasCharacteristics(Spliterator.SORTED));
    System.out.println("Is Sub-sized: " + spliterator.hasCharacteristics(Spliterator.SUBSIZED));
    Spliterator<Integer> trySplit = spliterator.trySplit(); // MAY RETURN NULL
    System.out.println("Spliterator Get exact size if known: " + spliterator.getExactSizeIfKnown());
    System.out.println("Spliterator Estimate size: " + spliterator.estimateSize());
    // IT'LL EXECUTE THE ACTION IF THE ELEMENT EXISTS THEN RETURN TRUE, OTHERWISE FALSE.
    // IF THE ACTION RETURNS NULL, A NULL POINTER EXCEPTION IS THROWN
    System.out.print("Spliterator With Try Advance: ");
    while (spliterator.tryAdvance(x -> System.out.printf("%d ", x)));
    System.out.println();
    // UNCHECKED! WE DIDN'T CHECK FOR NULL
    System.out.println("Try Split Get exact size if known: " + trySplit.getExactSizeIfKnown());
    System.out.println("Try Split Estimate size: " + trySplit.estimateSize());
    System.out.print("Try Split with for Each Remaining: ");
    // Performs the given action for each remaining element, sequentially in the current thread,
    // until all elements have been processed or the action throws an exception
    // forEachRemaining performs do { } while (tryAdvance(action)); internally.
    trySplit.forEachRemaining(x -> System.out.printf("%d ", x));
    System.out.println();
    Helper.print(false, numbers);
  }
  
  public static void descendingIterator() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    
    Iterator<String> descendingIterator = words.descendingIterator();
    while (descendingIterator.hasNext()) {
      System.out.println(descendingIterator.next());
      descendingIterator.remove();
    }
    /* THE ABOVE CODE IS EQUIVALENT TO THE ONE BELOW */
    /* ListIterator<String> listIterator = words.listIterator(words.size());
    while (listIterator.hasPrevious()) {
      System.out.println(listIterator.previous());
      listIterator.remove();
    } */
    Helper.print(false, words); // EMPTY LINKED LIST BY NOW
  }
  
  public static void listIteratorSet() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    
    ListIterator<String> listIterator = words.listIterator(0);
    while (listIterator.hasNext()) {
      String word = listIterator.next();
      // listIterator.remove(); //UNCOMMENT FOR IllegalStateException
      System.out.println(word);
      listIterator.set(word.toUpperCase());
    }
    Helper.print(false, words);
  }
  
  public static void listIteratorAdd() {
    LinkedList<String> words = new LinkedList<>();
    Helper.print(true, words); // EMPTY LINKED LIST
    System.out.println();
    
    ListIterator<String> listIterator = words.listIterator(0); // STILL EMPTY
    listIterator.add("You");
    //listIterator.next(); // UNCOMMENTING WILL THROW NoSuchElementException
    listIterator.add("Learn");
    listIterator.add("Java");
    if (listIterator.hasNext()) { // THIS BLOCK WILL BE IGNORED
      /* REMEMBER, IT ADDS BEFORE THE CURSOR */
      System.out.println("It won't get here!");
    }
    while (listIterator.hasPrevious()) {
      System.out.println(listIterator.previous());
      if (listIterator.previousIndex() == 0) { // IF PREVIOUS INDEX == FIRST ELEMENT
        // IF PREVIOUS INDEX IS -1, THERE IS NO ELEMENT LEFT
        // AND CALLING PREVIOUS WILL THROW AN EXCEPTION.
        System.out.println(listIterator.previous());
        listIterator.add("Helps");
      }
    }
    Helper.print(false, words);
  }
  
  public static void listIteratorRemove() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    
    ListIterator<String> listIterator = words.listIterator(0);
    while (listIterator.hasNext()) {
      /* Calling remove() will result in Exception. */
      //listIterator.remove(); // UNCOMMENT FOR A RUNTIME EXCEPTION
      System.out.println(listIterator.next());
      /* CALLING ADD RIGHT BEFORE REMOVE WILL THROW AN EXCEPTION  */
      //listIterator.add("FAIL"); // UNCOMMENTING THIS WILL CAUSE AN EXCEPTION
      listIterator.remove(); // THIS WORKS FINE IF ADD IS COMMENTED OUT!
      //listIterator.remove(); // CALL TWICE IN A ROW AND YOUR CODE BLOWS
    }
    Helper.print(false, words); // EMPTY LINKED LIST BY NOW
  }
  
  public static void failFast() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    
    ListIterator<String> listIterator = words.listIterator(0);
    /* THIS WILL RESULT IN EXCEPTION
       UNCOMMENT TO GIVE IT A TRY */
    // words.add("Hey,");
    /* THIS WILL ALSO RESULT IN EXCEPTION
       UNCOMMENT TO GIVE IT A TRY */
    // words.remove();
    /* THIS IS PERFECTLY FINE */
    words.set(words.size() - 1, "any Language");
    
    printIterator(listIterator, true);
    Helper.print(false, words);
  }
  
  public static void listIterator() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    
    ListIterator<String> listIterator = words.listIterator(0);
    printIterator(listIterator, true);
    printIterator(listIterator, false);
    
    listIterator = words.listIterator(4);
    printIterator(listIterator, true);
  }
  
  private static void printIterator(ListIterator<String> listIterator, boolean ascending) {
    if (ascending) {
      System.out.println("Ascending Iterator:");
      while (listIterator.hasNext()) {
        System.out.println(listIterator.next());
      }
    }
    else {
      System.out.println("Descending Iterator:");
      while (listIterator.hasPrevious()) {
        System.out.println(listIterator.previous());
      }
    }
    System.out.println();
  }
}