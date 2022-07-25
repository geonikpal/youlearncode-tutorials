package com.codelearnhub.abstractclassmethods;

import com.codelearnhub.Helper;
import com.codelearnhub.ProgrammingLanguage;

import java.util.LinkedList;

public class AbstractListMethods {
  
  public static void subList() {
    LinkedList<ProgrammingLanguage> pLanguages = Helper.getLanguages();
    LinkedList<ProgrammingLanguage> subProgLanguages
      = new LinkedList<>(pLanguages.subList(0, 2));
    // IF fromIndex AND toIndex ARE THE SAME, IT WILL RETURN AN EMPTY LIST.
    LinkedList<ProgrammingLanguage> emptyList = new LinkedList<>(pLanguages.subList(2, 2));
    // UNCOMMENT TO GET AN IndexOutOfBoundsException: fromIndex < 0 AND OR toIndex > THE LIST SIZE.
    // LinkedList<ProgrammingLanguage> exception = new LinkedList<>(pLanguages.subList(-1, 5));
    // UNCOMMENT TO GET AN IllegalArgumentException: fromIndex > toIndex.
    // LinkedList<ProgrammingLanguage> exception = new LinkedList<>(pLanguages.subList(4, 3));
    
    // A SUBLIST OF ZERO AND THE LIST SIZE WILL RETURN THE EXACT SAME NUMBER OF ELEMENTS
    LinkedList<ProgrammingLanguage> pLanguages2 =
      new LinkedList<>(pLanguages.subList(0, pLanguages.size()));
    
    Helper.print(true, pLanguages);
    Helper.print(true, subProgLanguages);
    
    if (emptyList.isEmpty())
      System.out.println("THIS LIST IS EMPTY!");
    
    Helper.print(true, pLanguages2);
    
    pLanguages2.get(3).setLanguage("PHP"); // CHANGES WILL REFLECT ON BOTH LISTS
    // TRUE IF BOTH LISTS POINT TO SAME ADDRESS IN MEMORY
    System.out.println("Are we ==: " + (pLanguages == pLanguages2));
    // UNCOMMENTING THE NEXT LINE WILL CAUSE EQUALS TO RETURN FALSE
    // pLanguages2.set(0, new ProgrammingLanguage("PYTHON"));
    // TRUE IF EACH ELEMENT POINTS TO THE SAME ADDRESS IN MEMORY
    System.out.println("Are we equals: " + pLanguages.equals(pLanguages2));
    
    Helper.print(false, pLanguages);
    Helper.print(false, pLanguages2);
  }
}
