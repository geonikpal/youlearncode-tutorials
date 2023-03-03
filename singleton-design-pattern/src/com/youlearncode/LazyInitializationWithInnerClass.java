package com.youlearncode;

public final class LazyInitializationWithInnerClass extends Singleton {
  
  private LazyInitializationWithInnerClass() { }
  
  private static final class InstanceHolder {
    private static final LazyInitializationWithInnerClass instance = new LazyInitializationWithInnerClass();
  }
  
  public static LazyInitializationWithInnerClass getInstance() {
    return InstanceHolder.instance;
  }
}