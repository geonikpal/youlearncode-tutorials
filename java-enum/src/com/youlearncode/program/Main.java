package com.youlearncode.program;

import com.youlearncode.enums.DayOfWeek;
import com.youlearncode.enums.Enumerable;
import com.youlearncode.enums.Operation;
import com.youlearncode.enums.OrderStatus;

import java.util.Arrays;


public class Main {
  
  public static void main(String[] args) {
    
    //declaringAnEnum();
    //usingEnumLikeClass();
    //usingValuesMethod();
    //usingValueOfMethod("PENDING");
    // Uncomment the next line to throw an IllegalArgumentException.
    //usingValueOfMethod("DELIVERED"); // There isn't a DELIVERED constant defined.
    //usingCompareToMethod(DayOfWeek.FRIDAY, DayOfWeek.MONDAY);
    //usingCompareToMethod(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY);
    //usingCompareToMethod(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY);
    //usingCompareToMethod(DayOfWeek.WEDNESDAY, DayOfWeek.WEDNESDAY);
    //usingEnumConstructors();
    //usingEnumMethods();
    //usingConstantSpecificBody();
    //usingConstantSpecificBodyWithAbstractMethod(10, 10);
    //usingCommonInterface();
    //usingReflection();
  }
  
  private static void usingReflection() {
    printEnum(Enumerable.toEnum(DayOfWeek.class, 7));
    printEnum(Enumerable.toEnum(DayOfWeek.class, 1));

    printEnum(Enumerable.toEnum(OrderStatus.class, 1));
    printEnum(Enumerable.toEnum(OrderStatus.class, 5));
  }
  
  private static void usingCommonInterface() {
    printEnum(Enumerable.toEnum(DayOfWeek.values(), 7));
    printEnum(Enumerable.toEnum(DayOfWeek.values(), 4));
    printEnum(Enumerable.toEnum(OrderStatus.values(), 1));
    printEnum(Enumerable.toEnum(OrderStatus.values(), 6));
    System.out.println();
    
    for (var e : DayOfWeek.values())
      System.out.println(e.getInitials() + " -> " + e.getDescription());
    
    // Will throw an IllegalArgumentException.
    printEnum(Enumerable.toEnum(DayOfWeek.values(), 0));
  }
  
  private static void usingConstantSpecificBodyWithAbstractMethod(double x, double y) {
    for (var op : Operation.values())
      System.out.println(x + " " + op + " " + y + " = " + op.eval(x, y));
  }
  
  private static void usingConstantSpecificBody() {
    for (var e : OrderStatus.values()) {
      System.out.println("Status for " + e.getDescription() + " is " + e.getStatus());
    }
  }
  
  private static void usingEnumMethods() {
    OrderStatus orderStatus = OrderStatus.toEnumFaster(4);
    //System.out.println(orderStatus); // Before refactoring
    printEnum(orderStatus); // After refactoring
    // Will throw an IllegalArgumentException.
    //orderStatus = OrderStatus.toEnum(0); // Uncomment to throw
  }
  
  private static void usingEnumConstructors() {
    OrderStatus[] statuses = OrderStatus.values();
    OrderStatus[] orders = OrderStatus.values();
  }
  
  private static void usingCompareToMethod(DayOfWeek day, DayOfWeek otherDay) {
    int result = day.compareTo(otherDay);
    if (result > 0) {
      System.out.println(day + " comes after " + otherDay + ".");
      return;
    }
    if (result < 0) {
      System.out.println(day + " comes before " + otherDay + ".");
      return;
    }
    System.out.println(day + " is equal to " + otherDay + ".");
  }
  
  private static void usingValueOfMethod(String enumStr) {
    OrderStatus status = OrderStatus.valueOf(enumStr);
    printEnum(status);
  }
  
  private static void usingValuesMethod() {
    for (OrderStatus status : OrderStatus.values()) {
      printEnum(status);
    }
  }
  
  private static void usingEnumLikeClass() {
    // Prints the Order Status AUTHORIZED.
    OrderStatusClass orderStatusClass = OrderStatusClass.AUTHORIZED;
    System.out.println(orderStatusClass);
    System.out.println();
    // Prints all constants in OrderStatusClass class.
    OrderStatusClass[] statusClasses = OrderStatusClass.values();
    Arrays.stream(statusClasses).forEach(System.out::println);
  }
  
  private static void declaringAnEnum() {
    // Assigned AUTHORIZED to orderStatus variable.
    OrderStatus orderStatus = OrderStatus.AUTHORIZED;
    OrderStatus[] statuses = OrderStatus.values();
    printEnum(orderStatus);
    System.out.println();
    printEnum(statuses);
  }
  
//  public static void printEnum(Enum<?> e) {
//    System.out.println("Enum Name: " + e.name() + ", enum ordinal: " + e.ordinal());
//  }
  
  public static void printEnum(Enumerable e) {
    System.out.println(e);
  }
  
//  public static void printEnum(Enum<?>[] enums) {
//    for (var e : enums) {
//      printEnum(e);
//    }
//  }
  
  public static void printEnum(Enumerable[] enums) {
    for (var e : enums) printEnum(e);
  }
}
