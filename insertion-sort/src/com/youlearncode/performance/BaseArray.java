package com.youlearncode.performance;

import java.util.Random;

public class BaseArray {
  
  private final static int[] arr = getRandomInts(10000);
  private final static String[] strArr = new String[] {"Hi", "Ant", "Air", "Flow", "Shoo", "By", "Fly", "Sly", "Sky", "My", "Thy", "Shy", "No", "Nah", "Yep", "Gee", "Wee"};
  
  public static int[] getIntArrayCopy() { return arr.clone(); }
  public static String[] getStringArrayCopy() { return strArr.clone(); }
  
  private static int[] getRandomInts(int length) {
    int[] arr = new int[length];
    Random random = new Random();
    
    for (int i = 0; i < length; i++) arr[i] = random.nextInt(length);
    return arr;
  }
}