package com.codelearnhub;

public class ProgrammingLanguage {
  private String language;
  
  public ProgrammingLanguage(String language) {
    this.language = language;
  }
  
  public String getLanguage() {
    return language;
  }
  
  public void setLanguage(String language) {
    this.language = language;
  }
  
  @Override
  public String toString() {
    return getLanguage();
  }
}