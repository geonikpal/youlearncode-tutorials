package com.codelearnhub.application;

import java.util.concurrent.Semaphore;

public class LongTask implements Runnable {
  
  private Semaphore semaphore;
  
  public LongTask(Semaphore semaphore) {
    this.semaphore = semaphore;
  }
  
  @Override
  public void run() {
    try {
      semaphore.acquireUninterruptibly();
      Main.getInstant(Thread.currentThread().getName());
      System.out.println("Very high time-consuming task processing...");
      Thread.sleep(5000);
    } catch (InterruptedException ignored) { }
    finally {
      semaphore.release();
    }
  }
}
