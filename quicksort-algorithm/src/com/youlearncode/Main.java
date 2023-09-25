package com.youlearncode;

import com.youlearncode.algorithms.BaseArray;
import com.youlearncode.algorithms.DualPivotQuickSort;
import com.youlearncode.algorithms.HoaresQuickSort;
import com.youlearncode.algorithms.LomutosQuickSort;
import com.youlearncode.performance.ArraySize;
import com.youlearncode.performance.Run;

import java.util.Arrays;

import static java.lang.System.out;
public class Main {
  
  static int[] intArray = {-7, 2, -5, 4, -3, -1, 8, 6, -9, 0};
  
  public static void main(String[] args) {
    print("Before Sorting:\n" + Arrays.toString(BaseArray.getIntArray()));
    print("Array Size: " + BaseArray.getIntArray().length);
    //Run.applySortingAlgorithm(LomutosQuickSort.class, BaseArray.getIntArrayCopy());
    //Run.applySortingAlgorithm(HoaresQuickSort.class, BaseArray.getIntArrayCopy());
    //Run.applySortingAlgorithm(HoaresQuickSort.class, BaseArray.getStringArray());
  }
  
  private static void print(String str) {
    out.println(str);
  }
}
