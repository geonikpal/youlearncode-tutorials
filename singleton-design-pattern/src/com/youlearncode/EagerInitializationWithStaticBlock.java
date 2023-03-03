package com.youlearncode;

import com.youlearncode.exceptions.SingletonException;

public final class EagerInitializationWithStaticBlock extends Singleton {
  private static final EagerInitializationWithStaticBlock instance;
  static {
    try {
      instance = new EagerInitializationWithStaticBlock();
    } catch (Exception e) {
      // log error
      throw new SingletonException(e.getMessage());
    }
  }
  
  private EagerInitializationWithStaticBlock() { }
  
  public static EagerInitializationWithStaticBlock getInstance() { return instance; }
}