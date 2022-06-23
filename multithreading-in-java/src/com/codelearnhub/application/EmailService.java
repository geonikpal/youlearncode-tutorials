package com.codelearnhub.application;

public class EmailService implements Runnable {
  
  private final String service;
  
  public EmailService(String service) {
    this.service = service;
  }
  
  @Override
  public void run() {
    System.out.println("Email service started!");
    for (int i = 0; i < 5; i++) {
      System.out.println(service);
      try {
        Thread.sleep(500);
      } catch (InterruptedException ignored) { }
    }
    System.out.println("Email service finished!");
  }
}