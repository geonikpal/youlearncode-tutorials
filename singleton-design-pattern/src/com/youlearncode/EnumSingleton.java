package com.youlearncode;

public enum EnumSingleton {
  INSTANCE("Singleton");
  
  private final String singleton;
  private static long start;
  
  EnumSingleton(String singleton) {
    this.singleton = singleton;
  }
  
  public String getSingleton() {
    return singleton;
  }
  
  @Override
  public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
  }
  
  public static void setStartingTime() {
    setStart(System.currentTimeMillis());
  }
  
  private static String getExecutionTime() {
    return System.currentTimeMillis() - getStart() + " milli seconds.";
  }
  
  private static String getTotalMemoryUsed() {
    return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "Kb";
  }
  
  public static void printResults() {
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