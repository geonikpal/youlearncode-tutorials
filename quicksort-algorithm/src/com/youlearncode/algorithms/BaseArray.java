package com.youlearncode.algorithms;

import com.youlearncode.performance.ArraySize;

import java.util.Random;

public class BaseArray {
  // {-7, 2, -5, 4, -3, -1, 8, 6, -9, 0} Used for testing com.youlearncode.algorithms.
  private static final int[] arr = getRandomInts(ArraySize.THOUSAND.getSize());
  private static final String[] strArr =
    new String[] {"Hi", "Ant", "Air", "Flow", "Shoo", "By", "Fly", "Sly", "Sky", "My", "Thy", "Shy", "No", "Nah", "Yep", "Gee", "Wee"};
  public static int[] getIntArrayCopy() { return arr.clone(); }
  public static int[] getIntArray() { return arr; }
  public static String[] getStringArray() { return strArr; }
  
  private static int[] getRandomInts(int length) {
    int[] arr = new int[length];
    Random random = new Random();
    
    for (int i = 0; i < length; i++) arr[i] = random.nextInt(length);
    return arr;
  }
  
  public static int getArraySize() { return getIntArrayCopy().length; }
}
