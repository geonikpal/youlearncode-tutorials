package com.youlearncode.algorithms;

import com.youlearncode.performance.SwapTracker;

public class ShellSort {
  public static void sort(int[] array) {
    if (array == null) throw new IllegalArgumentException("Input Array cannot be null!");
    sort(array, 0, array.length);
  }
  
  public static <T extends Comparable<T>> void sort(T[] array) {
    if (array == null) throw new IllegalArgumentException("Input Array cannot be null!");
    sort(array, 0, array.length);
  }
  
  private static void sort(int[] array, int start, int length) {
    if (length <= 1) return;
    // If the array length is 10, gap will be 5, then 2 and finally 1.
    for (int gap = (length / 2); gap > start; gap /= 2)
      for (int i = start; i < length - gap; i++)
        if (array[i] > array[i + gap])
          swap(array, i, i + gap);
        
    InsertionSort.sort(array);  // Note that here we invoke sort(int[] array) method in InsertionSort class.
  }
  
  private static <T extends Comparable<T>> void sort(T[] array, int start, int length) {
    if (length <= 1) return;
  
    for (int gap = (length / 2); gap > start; gap /= 2)
      for (int i = start; i < length - gap; i++)
        if (array[i].compareTo(array[i + gap]) > 0)
          swap(array, i, i + gap);
  
    InsertionSort.sort(array);
  }
  
  public static void swap(int[] arr, int firstIndex, int secondIndex) {
    if (firstIndex != secondIndex) {
      int temp = arr[firstIndex];
      arr[firstIndex] = arr[secondIndex];
      arr[secondIndex] = temp;
      SwapTracker.doubleIncrement();
    }
  }
  
  public static <T> void swap(T[] arr, int firstIndex, int secondIndex) {
    if (firstIndex != secondIndex) {
      T temp = arr[firstIndex];
      arr[firstIndex] = arr[secondIndex];
      arr[secondIndex] = temp;
      SwapTracker.doubleIncrement();
    }
  }
}
