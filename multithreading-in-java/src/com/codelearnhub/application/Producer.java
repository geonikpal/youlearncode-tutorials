package com.codelearnhub.application;

import java.util.Random;

public class Producer implements Runnable {
  
  private Array array;
  public Producer(Array array) {
    this.array = array;
  }
  
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Added: " + array.add(i, i+1));
      Random random = new Random();
      try { Thread.sleep(random.nextInt(5000));
      } catch (InterruptedException ignored) { }
    }
  }
}