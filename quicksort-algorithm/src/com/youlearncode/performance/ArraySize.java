package com.youlearncode.performance;

public enum ArraySize {
  TEN(10),
  FIFTY(50),
  HUNDRED(100),
  THOUSAND(1000),
  TEN_THOUSAND(10_000),
  HUNDRED_THOUSAND(100_000),
  MILLION(1_000_000),
  TEN_MILLION(10_000_000),
  HUNDRED_MILLION(100_000_000),
  TWO_HUNDRED_MILLION(200_000_000),
  BILLION(1_000_000_000);
  
  private final int size;
  ArraySize(int size) { this.size = size; }
  public int getSize() { return size; }
}
