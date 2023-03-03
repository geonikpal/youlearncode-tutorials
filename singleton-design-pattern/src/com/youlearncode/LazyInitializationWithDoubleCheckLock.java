package com.youlearncode;

public final class LazyInitializationWithDoubleCheckLock extends Singleton {
  
  // The volatile keyword ensures that multiple threads handle
  // the instance variable correctly when it is being initialized.
  private static volatile LazyInitializationWithDoubleCheckLock instance;
  
  private LazyInitializationWithDoubleCheckLock() { }
  
  public static LazyInitializationWithDoubleCheckLock getInstance() {
    if (instance == null)
      synchronized (LazyInitializationWithDoubleCheckLock.class) {
        if (instance == null) // Double-checking for null
          instance = new LazyInitializationWithDoubleCheckLock();
      }
    return instance;
  }
}