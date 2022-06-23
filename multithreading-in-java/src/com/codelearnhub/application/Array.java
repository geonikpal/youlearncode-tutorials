package com.codelearnhub.application;

public class Array {
  
  private int[] values = new int[10];
  private boolean adding = true;
  
  public synchronized int add(int index, int value) {
    while (!adding) {
      try {
        this.wait();
      } catch (InterruptedException ignored) { }
    }
    values[index] = value;
    adding = false;
    notifyAll();
    return value;
  }
  
  public synchronized int get(int index) {
    while (adding) {
      try {
        this.wait();
      } catch (InterruptedException ignored) { }
    }
    adding = true;
    notifyAll();
    return values[index];
  }
}