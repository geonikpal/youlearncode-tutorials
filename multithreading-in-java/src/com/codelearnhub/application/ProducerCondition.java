package com.codelearnhub.application;

import java.util.Random;

public class ProducerCondition implements Runnable {
  
  private ArrayCondition arrayCondition;
  public ProducerCondition(ArrayCondition arrayCondition) {
    this.arrayCondition = arrayCondition;
  }
  
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Added: " + arrayCondition.add(i, i+1));
      Random random = new Random();
      try { Thread.sleep(random.nextInt(5000));
      } catch (InterruptedException ignored) { }
    }
  }
}