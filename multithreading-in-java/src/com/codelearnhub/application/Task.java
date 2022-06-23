package com.codelearnhub.application;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Task implements Runnable {
  
  Future<List<Integer>> future;
  
  public Task(Future<List<Integer>> future) {
    this.future = future;
  }
  
  @Override
  public void run() {
    try {
      future.get().forEach(System.out::println);
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("Something went wrong!");
    }
  }
}
