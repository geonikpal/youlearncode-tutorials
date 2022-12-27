package com.youlearncode.enums;

// Source: https://docs.oracle.com/javase/specs/jls/se17/html/jls-8.html#jls-8.9.3
public enum Operation {
  PLUS {
    public double eval(double x, double y) { return x + y; }
  },
  MINUS {
    public double eval(double x, double y) { return x - y; }
  },
  TIMES {
    public double eval(double x, double y) { return x * y; }
  },
  DIVIDED_BY {
    public double eval(double x, double y) { return x / y; }
  };
  
  // Each constant supports an arithmetic operation
  public abstract double eval(double x, double y);
}
