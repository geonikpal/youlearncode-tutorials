package com.youlearncode.algorithms;

public class HoaresQuickSort extends BaseSort {
  
  // Allows us to call sort passing just the arr instead of passing the array plus its boundaries.
  public static void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
    //sort2(arr, 0, arr.length - 1);
  }
  
  // Note that T extends Comparable<T> and our array is of type T[].
  public static <T extends Comparable<T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }
  
  // Note that T extends Comparable<T> and our array is of type T[].
  private static <T extends Comparable<T>> void sort(T[] arr, int start, int end) {
    
    if (start >= end) return;
    int pivotIndex = partition(arr, start, end);
    sort(arr, start, pivotIndex - 1);
    sort(arr, pivotIndex + 1, end);
  }
  
  private static void sort(int[] arr, int start, int end) {
    // Base case to stop recursion.
    if (start >= end) return;
    
    // Rearrange the array based on the pivot and return the pivot index.
    int pivotIndex = partition(arr, start, end);
    // Sort the elements to the left of the pivot.
    sort(arr, start, pivotIndex - 1);
    // Sort the elements to the right of the pivot.
    sort(arr, pivotIndex + 1, end);
  }
  
  private static void sort2(int[] arr, int start, int end) {
    if (start >= end) return;
  
    int index = partition2(arr, start, end);
    sort(arr, start, index);
    sort(arr, index + 1, end);
  }
  
  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    
    int lp = start; // Left pointer
    int rp = end - 1;  // Right pointer
    
    while (true) {
      while (arr[lp] <= pivot && lp < end) lp++;
      while (arr[rp] >= pivot && rp > start) rp--;
      if (lp < rp) swap(arr, lp, rp);
      if (lp >= rp) {
        swap(arr, lp, end);
        return lp;
      }
    }
  }
  
  // Note that T extends Comparable<T> and our array is of type T[].
  private static <T extends Comparable<T>> int partition(T[] arr, int start, int end) {
    // Note that the pivot variable is of type T as well.
    T pivot = arr[end];
    int lp = start;
    int rp = end - 1;
  
    // Last but not least, we have to modify both while loops comparison expressions.
    while (true) {
      // Note that here we invoke the compareTo method and check whether
      // it returns a result greater than 0, less than 0, or equals 0.
      while (arr[lp].compareTo(pivot) <= 0 && lp < end) lp++;
      while (arr[rp].compareTo(pivot) >= 0 && rp > start) rp--;
      if (lp < rp) swap(arr, lp, rp);
      if (lp >= rp) {
        // Note that the swap method also requires modification.
        swap(arr, lp, end);
        return lp;
      }
    }
  }
  
  private static int partitionOptimized(int[] arr, int start, int end) {
    int pivot = arr[end];
    
    int lp = start;
    int rp = end;
    
    while (true) {
      while (arr[lp] < pivot && lp < end) lp++;
      while (arr[rp] > pivot && rp > start) rp--;
      //if (lp < rp) swap(arr, lp, rp);
      if (lp >= rp) return lp;
      swap(arr, lp, rp);
    }
  }
  
  private static int partition2(int[] arr, int start, int end) {
    int pivot = arr[start];
    int i = start - 1;
    int j = end + 1;
  
    for (;;)
    {
      while (arr[++i] < pivot);
      while (arr[--j] > pivot);
      if (i >= j) return j;
      swap(arr, i, j);
    }
  }
}
