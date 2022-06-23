package com.codelearnhub.application;

import java.util.concurrent.locks.ReentrantLock;

public class FairCounter implements Runnable {
  
  //private static final Object lock = new Object();
  private static final ReentrantLock lock = new ReentrantLock(true);
  final private String name;
  final private Color color;
  public FairCounter(String name, Color color) {
    this.name = name;
    this.color = color;
  }
  
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      lock.lock();
      //synchronized (lock) {
      try {
        System.out.println(color.getColor() + name + ": " + i);
      } finally {
        lock.unlock();
      }
    //}
    }
  }
}
