package com.youlearncode.algorithms;

import com.youlearncode.performance.SwapTracker;

public class InsertionSort {
  
  // Note that we opted for static so there is no need to create an object.
  public static void sort(int[] array) {
    // Checks for null references. We chose to throw an Exception. Feel free to handle it the way you see fit.
    if (array == null) throw new IllegalArgumentException("Input Array cannot be null!");
    sort(array, 1, array.length);
  }
  
  private static void sort(int[] array, int start, int length) {
    if (length <= 1) return; // Note that if the array length is 1 or 0, then it is sorted.
    // For Insertion Sorting, the first element is already considered sorted.
    // That is, there is no way to compare it to anything going backwards.
    // So, it makes sense to start our loop at 1 instead of 0.
    for (int i = start; i < length; i++) {
      int currentValue = array[i];
      // Note that if we had started our previous for loop at 0, then, the next line would've thrown an exception.
      int ptr = i - 1;
      if (currentValue < array[ptr]) {
        for (; ptr >= 0 && array[ptr] > currentValue; ptr--) {
          array[ptr + 1] = array[ptr];
          SwapTracker.increment();
        }
        // After breaking out of the for-loop, assign currentValue to array[ptr + 1], so it's rightly placed in the sorted portion.
        array[ptr + 1] = currentValue;
        SwapTracker.increment();
      }
    }
  }
  
  public static <T extends Comparable<? super T>> void sort(T[] array) {
    if (array == null) throw new IllegalArgumentException("Input Array cannot be null!");
    sort(array, 1, array.length);
  }
  
  // Note that E extends the interface Comparable<E> and that our array is of E type.
  public static <T extends Comparable<? super T>> void sort(T[] array, int start, int length) {
    if (length <= 1) return;
  
    for (int i = start; i < length; i++) {
      T currentValue = array[i];
      int ptr = i - 1;
      // Note that this time we cannot use comparison operators on E. E could be just about anything.
      // We must call the compareTo method, which will provide the implementation for comparison.
      if (currentValue.compareTo(array[ptr]) < 0) {
        for (; ptr >= 0 && array[ptr].compareTo(currentValue) > 0; ptr--) {
          array[ptr + 1] = array[ptr];
          SwapTracker.increment();
        }
        array[ptr + 1] = currentValue;
        SwapTracker.increment();
      }
    }
  }
}