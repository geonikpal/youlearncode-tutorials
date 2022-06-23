package com.codelearnhub.application;

public enum Color {
  RED("\u001B[31m"),
  GREEN("\u001B[32m"),
  YELLOW("\u001b[33m"),
  BLUE("\u001B[34m"),
  PURPLE("\u001B[35m"),
  CYAN("\u001B[36m");
  
  private String color;
  Color(String color) {
    this.color = color;
  }
  public String getColor() {
    return color;
  }
}
