package com.codelearnhub.application;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MessageReader implements Runnable {
  
  private final List<String> messages;
  private final ReentrantLock msgLock;
  
  public MessageReader(List<String> messages, ReentrantLock msgLock) {
    this.messages = messages;
    this.msgLock = msgLock;
  }
  
  @Override
  public void run() {
    while(true) {
      if (msgLock.tryLock()) {
        try {
          if (messages.isEmpty())
            continue;
          if (messages.get(0).equals(""))
            break;
          System.out.println(Thread.currentThread().getName() + " is receiving a message:");
          System.out.println(messages.remove(0));
        } finally {
          msgLock.unlock();
        }
      }
    }
  }
}
