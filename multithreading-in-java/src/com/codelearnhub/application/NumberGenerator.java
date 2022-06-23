package com.codelearnhub.application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class NumberGenerator implements Callable<List<Integer>> {
  
  private final List<Integer> counter;
  
  public NumberGenerator() {
    this.counter = new ArrayList<>();
  }
  
  @Override
  public List<Integer> call() throws Exception {
    System.out.println("Adding started...");
    for (int i = 1; i <= 20; i++) {
        counter.add(i);
        Thread.sleep(500);
    }
    System.out.println("Adding finished...");
    return counter;
  }
}
