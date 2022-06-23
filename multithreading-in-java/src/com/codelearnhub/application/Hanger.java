package com.codelearnhub.application;

public class Hanger extends Thread {
  
  @Override
  public void run() {
    infiniteLoop();
  }
  
  private static synchronized void infiniteLoop() {
    while (true) {
    
    }
  }
}
