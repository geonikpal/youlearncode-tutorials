package com.codelearnhub.application;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
  //private int i = 1;
  AtomicInteger intValue = new AtomicInteger(1);
  
//  public void increment() {
//    for (; i <= 10; i++) {
//      System.out.println(Thread.currentThread().getName() + ": " + i);
//    }
//  }
  
  public void increment() {
    while (intValue.get() <= 10) {
      System.out.println(Thread.currentThread().getName() + ": " + intValue.getAndIncrement());
    }
  }
}