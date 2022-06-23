package com.codelearnhub.application;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayCondition {
  
  private int[] values = new int[10];
  private boolean adding = true;
  private final Lock lock = new ReentrantLock();
  private final Condition get = lock.newCondition();
  private final Condition add = lock.newCondition();
  
  public int add(int index, int value) {
    try {
      lock.lock();
      while (!adding) {
        try {
          add.await();
        } catch (InterruptedException ignored) { }
      }
      values[index] = value;
      adding = false;
      get.signal();
      return value;
    } finally {
      lock.unlock();
    }
  }
  
  public int get(int index) {
    lock.lock();
    try {
      while (adding) {
        try {
          get.await();
        } catch (InterruptedException ignored) {
        }
      }
      adding = true;
      add.signal();
      return values[index];
    } finally {
      lock.unlock();
    }
  }
}