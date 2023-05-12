package com.youlearncode.tools;

public class Performance {
  
  public static void getExecutionTime(Runnable method) {
    long startTime = System.nanoTime();
    method.run();
    long elapsedTime = System.nanoTime() - startTime;
    System.out.printf("Elapsed Time: %d milliseconds.%n", elapsedTime / 1_000_000);
  }
}