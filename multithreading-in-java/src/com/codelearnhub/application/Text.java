package com.codelearnhub.application;

public class Text {
  
  private String line;
  private boolean writing = true;
  
  public synchronized void write(String line) {
    while (!writing) {
      try {
        wait();
      } catch (InterruptedException ignored) { }
    }
    writing = false;
    this.line = line;
    notifyAll();
  }
  
  public synchronized String read() {
    while (writing) {
      try {
        wait();
      } catch (InterruptedException ignored) { }
    }
    writing = true;
    notifyAll();
    return line;
  }
}