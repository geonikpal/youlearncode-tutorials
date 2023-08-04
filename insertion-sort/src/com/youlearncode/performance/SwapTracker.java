package com.youlearncode.performance;

public class SwapTracker {
  private static long swapTimes;
  
  public static long getSwapTimes() {
    long temp = swapTimes;
    swapTimes = 0L;
    return temp;
  }
  
  public static void increment() {
    swapTimes++;
  }
  
  public static void doubleIncrement() {
    swapTimes += 2;
  }
}
