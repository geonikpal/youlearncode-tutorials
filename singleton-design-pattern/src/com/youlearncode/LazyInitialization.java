package com.youlearncode;

public final class LazyInitialization extends Singleton {
  
  private static LazyInitialization instance;
  
  private LazyInitialization() { }
  
  public static LazyInitialization getInstance() {
    if (instance == null) instance = new LazyInitialization();
    return instance;
  }
}