package com.youlearncode.program;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusClass {
  
  public static final OrderStatusClass PROCESSED = new OrderStatusClass(0, "PROCESSED");
  public static final OrderStatusClass PENDING = new OrderStatusClass(1, "PENDING");
  public static final OrderStatusClass AUTHORIZED = new OrderStatusClass(2, "AUTHORIZED");
  public static final OrderStatusClass SHIPPED = new OrderStatusClass(3, "SHIPPED");
  
  private static final OrderStatusClass[] values = getValues();
  
  private final int ordinal;
  private final String name;
  
  public OrderStatusClass(int ordinal, String name) {
    this.ordinal = ordinal;
    this.name = name;
  }
  
  public int ordinal() {
    return ordinal;
  }
  
  public String name() {
    return name;
  }
  
  public static OrderStatusClass[] values() {
    return values;
  }
  
  @Override
  public String toString() {
    return "Enum Name: " + name + ", enum ordinal: " + ordinal;
  }
  
  private static OrderStatusClass[] getValues() {
    int count = 0;
    Field[] declaredFields = OrderStatusClass.class.getDeclaredFields();
    List<OrderStatusClass> statuses = new ArrayList<>();
    for (Field field : declaredFields) {
      if (Modifier.isStatic(field.getModifiers())) {
        try {
          OrderStatusClass o = (OrderStatusClass) field.get(OrderStatusClass.class);
          if (o == null) continue;
          statuses.add(o);
          count++;
        } catch (IllegalAccessException e) { e.printStackTrace(); }
      }
    }
    return statuses.toArray(new OrderStatusClass[count]);
  }
}