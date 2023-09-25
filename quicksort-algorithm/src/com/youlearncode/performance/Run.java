package com.youlearncode.performance;

import com.youlearncode.algorithms.BaseSort;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Run {
  
  public static void printElapsedTimeInMilliSeconds(String name, Runnable r) {
    long start = System.nanoTime();
    r.run();
    System.out.println(name + " - " + (System.nanoTime() - start) / 1000 + " microseconds.");
  }
  
  public static <T> void applySortingAlgorithm(Class<T> cls, int[] arr) {
    Run.printElapsedTimeInMilliSeconds(cls.getSimpleName(), () -> {
      try {
        cls.getMethod("sort", int[].class).invoke(null, arr);
      } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        e.printStackTrace();
      }
    });
    System.out.println("After sorting:\n" + Arrays.toString(arr));
    System.out.println("Swap times: " + BaseSort.getSwapTimes());
  }
  
  public static <T, E extends Comparable<E>> void applySortingAlgorithm(Class<T> cls, E[] arr) {
    Run.printElapsedTimeInMilliSeconds(cls.getSimpleName(), () -> {
      try {
        cls.getMethod("sort", Comparable[].class).invoke(null, (Object) arr);
      } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        e.printStackTrace();
      }
    });
    System.out.println("After sorting:\n" + Arrays.toString(arr));
    System.out.println("Swap times: " + BaseSort.getSwapTimes());
  }
  
//  public static <T> void applySortingAlgorithm(Class<T> cls, String[] arr) {
//    Run.printElapsedTimeInMilliSeconds(cls.getSimpleName(), () -> {
//      try {
//        cls.getMethod("sort", String[].class).invoke(null, (Object) arr);
//      } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//        e.printStackTrace();
//      }
//    });
//    System.out.println("After sorting:\n" + Arrays.toString(arr));
//    System.out.println("Swap times: " + BaseSort.getSwapTimes());
//  }
}
