package com.codelearnhub.abstractclassmethods;

import com.codelearnhub.Helper;

import java.util.Iterator;
import java.util.LinkedList;

public class AbstractSequentialListMethods {
  
  public static void iterator() {
    LinkedList<String> words = Helper.getWords();
    Helper.print(true, words);
    Iterator<String> iterator = words.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      iterator.remove();
    }
    Helper.print(false, words);
  }
}
