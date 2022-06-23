package com.codelearnhub.application;

import java.util.concurrent.locks.ReentrantLock;

public class PrintService extends Thread {
  
  private static ReentrantLock lock = new ReentrantLock();
  private static final Object locker = new Object();
  
  private final String file;
  private final Color color;
  
  public PrintService(String file, Color color) {
    this.file = file;
    this.color = color;
  }
  
  private int i;
  
  @Override
  public void run() {
    //lock.lock();
    //synchronized (locker) {
      System.out.println(color.getColor() + "Print Service started!");
      for (i = 1; i <= 5; i++) {
        System.out.println(color.getColor() + i + file);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          System.out.println("Printing " + file + " got interrupted.");
          return;
        }
      }
      System.out.println(color.getColor() + "Print Service finished!");
    //}
    //lock.unlock();
  }
}