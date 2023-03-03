package com.youlearncode;

public final class SynchronizedLazyInitialization extends Singleton {
  
  private static SynchronizedLazyInitialization instance;
  
  private SynchronizedLazyInitialization() { }
  
  public static synchronized SynchronizedLazyInitialization getInstance() {
    if (instance == null) instance = new SynchronizedLazyInitialization();
    return instance;
  }
}