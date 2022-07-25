package com.codelearnhub.linkedlistmethods;

import com.codelearnhub.Helper;
import com.codelearnhub.ProgrammingLanguage;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class CopyingMethods {
  
  public static void toTypedArray() {
    LinkedList<ProgrammingLanguage> languages = Helper.getLanguages();
    System.out.println("Original:");
    Helper.print(true, languages);
    
    ProgrammingLanguage[] tenLanguages = {
      new ProgrammingLanguage("Python"),
      new ProgrammingLanguage("Java"),
      new ProgrammingLanguage("JavaScript"),
      new ProgrammingLanguage("C#"),
      new ProgrammingLanguage("PHP"),
      new ProgrammingLanguage("C/C++"),
      new ProgrammingLanguage("R"),
      new ProgrammingLanguage("TypeScript"),
      new ProgrammingLanguage("Swift"),
      new ProgrammingLanguage("Objective-C")
    };
    
    ProgrammingLanguage[] cloned = languages.toArray(tenLanguages);
    System.out.println("Cloned:");
    Helper.print(true, cloned);
    
    cloned[1].setLanguage("Ruby");
    languages.get(2).setLanguage("Kotlin");
    languages.add(new ProgrammingLanguage("Python"));
    languages.add(new ProgrammingLanguage("Objective-C"));
    
    System.out.println("Original:");
    Helper.print(false, languages);
    
    System.out.println("Cloned:");
    Helper.print(false, cloned);
  }
  
  public static void toArray() {
    LinkedList<ProgrammingLanguage> languages = Helper.getLanguages();
    System.out.println("Original:");
    Helper.print(true, languages);
    
    Object[] cloned = languages.toArray();
    System.out.println("Cloned:");
    Helper.print(true, cloned);
    
    //((ProgrammingLanguage)cloned[0]).setLanguage("Go");
    languages.addFirst(new ProgrammingLanguage("JavaScript"));
    languages.get(4).setLanguage("PHP");
    languages.remove(3);
    
    System.out.println("Original:");
    Helper.print(false, languages);
    
    System.out.println("Cloned:");
    Helper.print(false, cloned);
    
    //Compile time error
    //String[] noWay = languages.toArray();
    //Runtime error
    //String[] tryMe = (String[]) languages.toArray();
    //You should use the overloaded method instead.
  }
  
  public static void deepClone() {
    LinkedList<String> words = Helper.getWords();
    System.out.println("Original:");
    Helper.print(true, words);
    
    // Unchecked cast
    LinkedList<String> cloned = (LinkedList<String>)words.clone();
    System.out.println("Cloned:");
    Helper.print(true, cloned);
    
    words.addFirst("Indeed,");
    words.set(7, "Programming");
    words.remove(5);
    System.out.println("Original:");
    Helper.print(false, words);
    System.out.println("Cloned:");
    Helper.print(false, cloned);
  }
  
  public static void shallowClone() {
    LinkedList<AtomicInteger> numbers = new LinkedList<>();
    numbers.add(new AtomicInteger(0));
    numbers.add(new AtomicInteger(10));
    // Unchecked cast
    LinkedList<AtomicInteger> cloned = (LinkedList<AtomicInteger>)numbers.clone();
    numbers.add(new AtomicInteger(100));
    numbers.removeFirst();
    System.out.println("Element changed in numbers: " + numbers.peek().incrementAndGet());
    System.out.println("Element changed in numbers: " + numbers.peekLast().incrementAndGet());
    System.out.println("Numbers " + numbers);
    System.out.println("Cloned " + cloned);
  }
}
