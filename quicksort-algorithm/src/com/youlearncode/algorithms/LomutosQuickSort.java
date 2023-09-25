package com.youlearncode.algorithms;

public class LomutosQuickSort extends BaseSort {
  
  public static void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }
  
  private static void sort(int[] arr, int start, int end) {
    
    if (end <= start) return;
    
    int pivotIndex = partition(arr, start, end);
    sort(arr, start, pivotIndex - 1);
    sort(arr, pivotIndex + 1, end);
  }
  
  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = start - 1;
  
    for (int j = start; j < end; j++) {
      if (arr[j] < pivot)
        swap(arr, ++i, j);
    }
    swap(arr, ++i, end);
    return i;
  }
}