package com.youlearncode;

import com.youlearncode.algorithms.InsertionSort;
import com.youlearncode.algorithms.ShellSort;
import com.youlearncode.performance.BaseArray;
import com.youlearncode.performance.Run;

public class Main {
  private static int[] intArr = {-7, 2, -5, 4, -3, -1, 8, 6, -9, 0};
  private static String[] strArr = {"M", "J", "F", "B", "X", "A", "G"};
  
  public static void main(String[] args) {
    insertionSortCall(intArr.clone());
    shellSortCall(intArr.clone());
    insertionSortCall(BaseArray.getIntArrayCopy());
    shellSortCall(BaseArray.getIntArrayCopy());
    insertionSortCall(strArr.clone());
    shellSortCall(strArr.clone());
    insertionSortCall(BaseArray.getStringArrayCopy());
    shellSortCall(BaseArray.getStringArrayCopy());
  }
  
  private static <T extends Comparable<T>> void shellSortCall(T[] array) {
    Run.applySortingAlgorithm(
      ShellSort.class.getSimpleName(), () -> ShellSort.sort(array), array);
  }
  
  private static <T extends Comparable<T>> void insertionSortCall(T[] array) {
    Run.applySortingAlgorithm(
      InsertionSort.class.getSimpleName(), () -> InsertionSort.sort(array), array);
  }
  
  private static void shellSortCall(int[] array) {
    Run.applySortingAlgorithm(
      ShellSort.class.getSimpleName(), () -> ShellSort.sort(array), array);
  }
  
  private static void insertionSortCall(int[] array) {
    Run.applySortingAlgorithm(
      InsertionSort.class.getSimpleName(), () -> InsertionSort.sort(array), array);
  }
}