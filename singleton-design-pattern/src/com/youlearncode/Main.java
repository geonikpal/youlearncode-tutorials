package com.youlearncode;

public class Main {
  
  public static void main(String[] args) {
    //lazyInitialization();
    //synchronizedLazyInitialization();
    //lazyInitializationWithDoubleCheckLock();
    //lazyInitializationWithInnerClass();
    //eagerInitialization();
    //eagerInitializationWithStaticBlock();
    //enumSingleton();
  }
  
  private static void enumSingleton() {
    EnumSingleton.setStartingTime();
    Runnable runnable = () -> {
      EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
      System.out.println(enumSingleton);
    };
    
    for (int i = 0; i < 10; i++) {
      new Thread(runnable).start();
    }
    EnumSingleton.printResults();
  }
  
  private static void eagerInitializationWithStaticBlock() {
    EagerInitializationWithStaticBlock.setStartingTime();
    Runnable runnable = () -> {
      EagerInitializationWithStaticBlock eagerInitializationWithStaticBlock = EagerInitializationWithStaticBlock.getInstance();
      System.out.println(eagerInitializationWithStaticBlock);
    };
  
    for (int i = 0; i < 10; i++) {
      new Thread(runnable).start();
    }
    EagerInitializationWithStaticBlock.printResults();
  }
  
  private static void eagerInitialization() {
    EagerInitialization.setStartingTime();
    Runnable runnable = () -> {
      EagerInitialization eagerSingleton = EagerInitialization.getInstance();
      System.out.println(eagerSingleton);
    };
  
    for (int i = 0; i < 10; i++) {
      new Thread(runnable).start();
    }
    EagerInitialization.printResults();
  }
  
  private static void lazyInitializationWithInnerClass() {
    LazyInitializationWithInnerClass.setStartingTime();
    Runnable runnable = () -> {
      LazyInitializationWithInnerClass lazyInitializationWithInnerClass = LazyInitializationWithInnerClass.getInstance();
      System.out.println(lazyInitializationWithInnerClass);
    };
    
    for (int i = 0; i < 10; i++) {
      new Thread(runnable).start();
    }
    LazyInitializationWithInnerClass.printResults();
  }
  
  private static void lazyInitializationWithDoubleCheckLock() {
    LazyInitializationWithDoubleCheckLock.setStartingTime();
    Runnable runnable = () -> {
      LazyInitializationWithDoubleCheckLock lazyInitializationWithDoubleCheckLock = LazyInitializationWithDoubleCheckLock.getInstance();
      System.out.println(lazyInitializationWithDoubleCheckLock);
    };
  
    for (int i = 0; i < 10; i++) {
      new Thread(runnable).start();
    }
    LazyInitializationWithDoubleCheckLock.printResults();
  }
  
  private static void synchronizedLazyInitialization() {
    SynchronizedLazyInitialization.setStartingTime();
    Runnable runnable = () -> {
      SynchronizedLazyInitialization synchronizedLazyInitialization = SynchronizedLazyInitialization.getInstance();
      System.out.println(synchronizedLazyInitialization);
    };
    
    for (int i = 0; i < 10; i++) {
      new Thread(runnable).start();
    }
    SynchronizedLazyInitialization.printResults();
  }
  
  private static void lazyInitialization() {
    LazyInitialization.setStartingTime();
    Runnable runnable = () -> {
      LazyInitialization lazySingleton = LazyInitialization.getInstance();
      System.out.println(lazySingleton);
    };
    
    for (int i = 0; i < 5; i++) {
      new Thread(runnable).start();
    }
    LazyInitialization.printResults();
  }
}