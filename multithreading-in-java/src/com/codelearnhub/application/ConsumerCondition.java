package com.codelearnhub.application;

import java.util.Random;

public class ConsumerCondition implements Runnable {
  
  private ArrayCondition arrayCondition;
  public ConsumerCondition(ArrayCondition arrayCondition) {
    this.arrayCondition = arrayCondition;
  }
  
  @Override
  public void run() {
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      System.out.println("Gotten: " + arrayCondition.get(i));
      try { Thread.sleep(random.nextInt(5000));
      } catch (InterruptedException ignored) { }
    }
  }
}