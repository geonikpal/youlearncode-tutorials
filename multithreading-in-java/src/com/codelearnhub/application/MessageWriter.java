package com.codelearnhub.application;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MessageWriter implements Runnable {
  
  private final List<String> messages;
  private final ReentrantLock msgLock;
  
  public MessageWriter(List<String> messages, ReentrantLock msgLock) {
    this.messages = messages;
    this.msgLock = msgLock;
  }
  
  String[] incomingMsg = {
    "Something important is happening here.",
    "The Reentrant Lock works like a charm.",
    "But one has to be careful when dealing with those locks.",
    "One slip and we may find ourselves in a deadlock limbo.",
    "Try finally is your friend and it won't disappoint you.",
    ""
  };
  
  @Override
  public void run() {
    for (var msg : incomingMsg) {
      msgLock.lock();
      System.out.println("Sending message...");
      try {
        messages.add(msg);
      } finally {
        msgLock.unlock();
      }
    }
  }
}
