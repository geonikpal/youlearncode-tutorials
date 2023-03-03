package com.youlearncode;

public final class EagerInitialization extends Singleton {
  
  private static final EagerInitialization instance = new EagerInitialization();
  
  private EagerInitialization() { }
  
  public static EagerInitialization getInstance() { return instance; }
}