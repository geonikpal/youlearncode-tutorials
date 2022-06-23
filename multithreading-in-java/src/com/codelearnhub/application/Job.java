package com.codelearnhub.application;

import java.util.concurrent.atomic.AtomicInteger;

public class Job implements Runnable {
  
  private final String name;
  private final int cap;
  
  public Job(String name, int cap) {
    this.name = name;
    this.cap = cap;
  }
  
  @Override
  public void run() {
    Main.getInstant(name);
    AtomicInteger atomicSum = new AtomicInteger(0);
    for (int i = 1; i <= cap; i++) {
      atomicSum.accumulateAndGet(i, this::sum);
    }
    System.out.println(name + ": " + atomicSum.get());
    try {
      Thread.sleep(3000);
    } catch (InterruptedException ignored) { }
  }
  
  private int sum(int value, int sum) {
    return sum += value;
  }
}
