package com.codelearnhub.application;

public class Person {
  private final String name;
  
  public Person(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void wave(Person person) {
    System.out.println(name + " waved at " + person.getName());
    synchronized (this) {
      person.waveBack(this);
    }
  }
  
  private synchronized void waveBack(Person person) {
    System.out.println(name + " waved back at " + person.getName());
  }
}
