package com.youlearncode.enums;

public enum DayOfWeek implements Enumerable {
  SUNDAY(1, "Sunday"),       // ordinal 0 -> code 1
  MONDAY(2, "Monday"),       // ordinal 1 -> code 2
  TUESDAY(3, "Tuesday"),     // ordinal 2 -> code 3
  WEDNESDAY(4, "Wednesday"), // ordinal 3 -> code 4
  THURSDAY(5, "Thursday"),   // ordinal 4 -> code 5
  FRIDAY(6, "Friday"),       // ordinal 5 -> code 6
  SATURDAY(7, "Saturday");   // ordinal 6 -> code 7
  
  private final String description;
  private final int code;
  
  DayOfWeek(int code, String description) {
    this.code = code;
    this.description = description;
  }
  
  @Override
  public int getCode() { return code; }
  
  @Override
  public String getDescription() { return description; }
  
  @Override
  public String toString() { return format(); }
}
