package com.codelearnhub.application;

import java.util.Random;

public class Consumer implements Runnable {
  
  private Array array;
  public Consumer(Array array) {
    this.array = array;
  }
  
  @Override
  public void run() {
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      System.out.println("Gotten: " + array.get(i));
      try { Thread.sleep(random.nextInt(5000));
      } catch (InterruptedException ignored) { }
    }
  }
}