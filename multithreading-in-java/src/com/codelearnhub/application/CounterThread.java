package com.codelearnhub.application;

public class CounterThread extends Thread {
  private Counter counter;
  
  public CounterThread(Counter counter) {
    this.counter = counter;
  }
  
  @Override
  public void run() {
    counter.increment();
  }
}