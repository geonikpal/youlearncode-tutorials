package com.youlearncode.enums;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Enumerable {
  
  int getCode();
  String getDescription();
  
  // Require Java 1.8 or above.
  default String format() {
    return "Enum Name: " + this.getDescription() + ", enum code: " + this.getCode() + ".";
  }
  
  default String getInitials() {
    return this.getDescription().substring(0, 3);
  }
  
  static <T extends Enumerable> T toEnum(final T[] values, int code) {
    if (values == null) throw new NullPointerException();
    if (code > 0 && code <= values.length)
      for (var e : values)
        if (e.getCode() == code)
          return e;
    throw new IllegalArgumentException("No CONSTANT found for code: " + code);
  }
  
  static <T extends Enum<T>> T toEnum(Class<T> enumClass, int code) {
    
    Method valuesMethod = getValuesMethod(enumClass);
    @SuppressWarnings("unchecked") final T[] values = (T[]) getValues(valuesMethod);
    if (values == null) throw new NullPointerException();
    if (code > 0 && code <= values.length)
      return values[code - 1];
    throw new IllegalArgumentException("No CONSTANT found for code: " + code);
  }
  
  private static Object[] getValues(Method valuesMethod) {
    if (valuesMethod == null) return null;
    try {
      return (Object[]) valuesMethod.invoke(null, (Object[]) null);
    } catch (IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  private static <T extends Enum<T>> Method getValuesMethod(Class<T> enumClass) {
    if (enumClass == null) return null;
    try {
      return enumClass.getDeclaredMethod("values");
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    return null;
  }
}