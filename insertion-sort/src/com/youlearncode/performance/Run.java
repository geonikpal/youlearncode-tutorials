package com.youlearncode.performance;

import java.util.Arrays;

public class Run {
  
  public static void applySortingAlgorithm(String name, Runnable r, int[] array) {
    printBefore(array);
    long start = System.nanoTime();
    r.run();
    System.out.println(name + " - " + (System.nanoTime() - start) / 1000 + " microseconds.");
    System.out.println("Swap times: " + SwapTracker.getSwapTimes());
    printAfter(array);
  }
  
  public static <T extends Comparable<T>> void applySortingAlgorithm(String name, Runnable r, T[] array) {
    printBefore(array);
    long start = System.nanoTime();
    r.run();
    System.out.println(name + " - " + (System.nanoTime() - start) / 1000 + " microseconds.");
    System.out.println("Swap times: " + SwapTracker.getSwapTimes());
    printAfter(array);
  }
  
  private static void printBefore(int[] array) {
    System.out.println("Before sorting: " + Arrays.toString(array));
  }
  
  private static <T> void printBefore(T[] array) {
    System.out.println("Before sorting: " + Arrays.toString(array));
  }
  
  private static void printAfter(int[] array) {
    System.out.println("After sorting: " + Arrays.toString(array) + "\n");
  }
  
  private static <T> void printAfter(T[] array) {
    System.out.println("After sorting: " + Arrays.toString(array) + "\n");
  }
}
