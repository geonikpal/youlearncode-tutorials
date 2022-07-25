package com.codelearnhub;

import com.codelearnhub.abstractclassmethods.AbstractCollectionMethods;
import com.codelearnhub.abstractclassmethods.AbstractListMethods;
import com.codelearnhub.abstractclassmethods.AbstractSequentialListMethods;
import com.codelearnhub.interfacemethods.CollectionInterfaceMethods;
import com.codelearnhub.interfacemethods.IterableInterfaceMethods;
import com.codelearnhub.interfacemethods.ListInterfaceMethods;
import com.codelearnhub.linkedlistmethods.*;

import java.util.*;

public class Main {
  
  public static void main(String[] args) {
    
    //INITIALIZING
    //newingALinkedList();
    //newingALinkedListPassingACollection();
    //newingALinkedListForConcurrentEnvironment();
    
    //ADDING METHODS
    //AddingMethods.add();
    //AddingMethods.addLast();
    //AddingMethods.addFirst();
    //AddingMethods.push();
    //AddingMethods.addAtIndex();
    //AddingMethods.addAllStartingAtIndex();
    //AddingMethods.addAll();
    //AddingMethods.offer();
    //AddingMethods.offerFirst();
    //AddingMethods.offerLast();
    
    //REMOVING METHODS
    //RemovingMethods.remove();
    //RemovingMethods.removeFirst();
    //RemovingMethods.removeLast();
    //RemovingMethods.removeElement();
    //RemovingMethods.removeAtIndex();
    //RemovingMethods.removeFirstOccurrence();
    //RemovingMethods.removeLastOccurrence();
    //RemovingMethods.pop();
    
    //RETRIEVING METHODS
    //RetrievingMethods.getAtIndex();
    //RetrievingMethods.getFirst();
    //RetrievingMethods.getLast();
    //RetrievingMethods.element();
    //RetrievingMethods.peek();
    //RetrievingMethods.peekFirst();
    //RetrievingMethods.peekLast();
    //RetrievingMethods.poll();
    //RetrievingMethods.pollFirst();
    //RetrievingMethods.pollLast();
    
    //USEFUL METHODS
    //UsefulMethods.contains();
    //UsefulMethods.indexOf();
    //UsefulMethods.lastIndexOf();
    //UsefulMethods.size();
    //UsefulMethods.clear();
    
    //COPYING METHODS
    //CopyingMethods.shallowClone();
    //CopyingMethods.deepClone();
    //CopyingMethods.toArray();
    //CopyingMethods.toTypedArray();
    
    //MODIFYING METHODS
    //ModifyingMethods.set();
    
    //ITERATOR METHODS
    //IteratorMethods.listIterator();
    //IteratorMethods.failFast();
    //IteratorMethods.listIteratorRemove();
    //IteratorMethods.listIteratorAdd();
    //IteratorMethods.listIteratorSet();
    //IteratorMethods.descendingIterator();
    //IteratorMethods.spliterator();
    
    // INHERITED METHODS FROM AbstractCollection
    //AbstractCollectionMethods.containsAll();
    //AbstractCollectionMethods.isEmpty();
    //AbstractCollectionMethods.removeALl();
    //AbstractCollectionMethods.retainAll();
    //AbstractCollectionMethods.toStringy();
  
    // INHERITED METHODS FROM AbstractList
    //AbstractListMethods.subList();
  
    // INHERITED METHODS AbstractSequentialList
    //AbstractSequentialListMethods.iterator();
    
    // INHERITED METHODS Iterable Interface
    //IterableInterfaceMethods.forEach();
  
    // INHERITED METHODS Collection Interface
    //CollectionInterfaceMethods.removeIf();
    //CollectionInterfaceMethods.toArrayWithIntFunction();
    //CollectionInterfaceMethods.stream();
    //CollectionInterfaceMethods.parallelStream();
  
    // INHERITED METHODS List Interface
    //ListInterfaceMethods.sort();
    //ListInterfaceMethods.replaceAll();
  }
  
  private static void newingALinkedListForConcurrentEnvironment() {
    List<Integer> list = Collections.synchronizedList(new LinkedList<>(Arrays.asList(1,2,3,4,5)));
    System.out.println(list);
  }
  
  private static void newingALinkedListPassingACollection() {
    LinkedList<Integer> linkedList = new LinkedList<>(getSetCollection());
    System.out.println(linkedList);
  }
  
  private static Set<Integer> getSetCollection() {
    return new HashSet<>() {{
      add(1);
      add(5);
      add(3);
      add(2);
      add(4);
    }};
  }
  
  private static void newingALinkedList() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);
    System.out.println(linkedList);
  }
}