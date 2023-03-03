package com.youlearncode;

public abstract class Singleton {
  
  static protected long start;
  
  protected Singleton() {}
  
  static protected void setStartingTime() {
    setStart(System.currentTimeMillis());
  }
  
  static private String getExecutionTime() {
    return System.currentTimeMillis() - getStart() + " milli seconds.";
  }
  
  static private String getTotalMemoryUsed() {
    return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "Kb";
  }
  
  static protected void printResults() {
    System.out.println(getExecutionTime());
    System.out.println(getTotalMemoryUsed());
  }
  
  public static long getStart() {
    return start;
  }
  
  public static void setStart(long start) {
    Singleton.start = start;
  }
}