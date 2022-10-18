package com.youlearncode;

enum Weekdays {
  SUNDAY,
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
}

enum Operation {
  ADDITION,
  SUBTRACTION,
  MULTIPLICATION,
  DIVISION
}

public class Main {

  public static void main(String[] args) {
    //traditionalSwitchHub();
    //traditionalSwitchWithEnumsHub();
    //multipleCasesWithoutBreakHub();
    //traditionalSwitchWithNestedSwitchHub();
    //traditionalSwitchWithStringsHub();
    //traditionalSwitchWithConstantListHub();
    //switchExpressionWithYieldHub();
    //switchExpressionWithArrowCaseHub();
    //switchExpressionWithPatternMatchingHub();
    //switchExpressionNullPatternHub();
    //switchExpressionWithGuardedPatternHub();
  }
  
  private static void switchExpressionWithGuardedPatternHub() {
    switchExpressionWithGuardedPattern("youlearncode@code.com");
    switchExpressionWithGuardedPattern("you_code.com");
    switchExpressionWithGuardedPattern(null);
  }
  
  private static void switchExpressionNullPatternHub() {
    switchExpressionNullPattern(Weekdays.SUNDAY);
    switchExpressionNullPattern(null);
  }
  
  private static void switchExpressionWithPatternMatchingHub() {
    switchExpressionWithPatternMatching("String");
    switchExpressionWithPatternMatching(0);
    switchExpressionWithPatternMatching(0.0);
    switchExpressionWithPatternMatching(true);
    switchExpressionWithPatternMatching(Weekdays.FRIDAY);
    switchExpressionWithPatternMatching(null);
    switchExpressionWithPatternMatching(new int[3]);
  }
  
  private static void switchExpressionWithArrowCaseHub() {
    switchExpressionWithArrowCase(Weekdays.SUNDAY);
    switchExpressionWithArrowCase(Weekdays.TUESDAY);
    switchExpressionWithArrowCase(Weekdays.SATURDAY);
  }
  
  private static void switchExpressionWithYieldHub() {
    System.out.println("Addition: " + switchExpressionWithYield(Operation.ADDITION, 10, 5));
    System.out.println("Subtraction: " + switchExpressionWithYield(Operation.SUBTRACTION, 10, 5));
    System.out.println("Multiplication: " + switchExpressionWithYield(Operation.MULTIPLICATION, 10, 5));
    System.out.println("Division: " + switchExpressionWithYield(Operation.DIVISION, 10, 5));
  }
  
  private static void traditionalSwitchWithConstantListHub() {
    traditionalSwitchWithConstantList(Weekdays.MONDAY);
    traditionalSwitchWithConstantList(Weekdays.WEDNESDAY);
    traditionalSwitchWithConstantList(Weekdays.SATURDAY);
  }
  
  private static void traditionalSwitchWithStringsHub() {
    traditionalSwitchWithStrings("Sun");
    traditionalSwitchWithStrings("Thu");
    traditionalSwitchWithStrings("Weekend");
  }
  
  private static void traditionalSwitchWithNestedSwitchHub() {
    traditionalSwitchWithNestedSwitch(1, 1);
    traditionalSwitchWithNestedSwitch(1, 2);
    traditionalSwitchWithNestedSwitch(2, 0);
  }
  
  private static void multipleCasesWithoutBreakHub() {
    multipleCasesWithoutBreak(Weekdays.MONDAY);
    multipleCasesWithoutBreak(Weekdays.SATURDAY);
  }
  
  private static void traditionalSwitchWithEnumsHub() {
    traditionalSwitchWithEnums(Weekdays.SUNDAY);
    traditionalSwitchWithEnums(Weekdays.TUESDAY);
    traditionalSwitchWithEnums(Weekdays.SATURDAY);
  }
  
  private static void traditionalSwitchHub() {
    traditionalSwitch(1);
    traditionalSwitch(5);
    traditionalSwitch(0);
  }
  
  // Switch Expression with Guarded Pattern
  private static void switchExpressionWithGuardedPattern(Object email) {
    switch (email) {
      case String s && s.contains("@") && s.length() > 8 -> login();
      case null -> throw new IllegalArgumentException();
      default -> System.out.println("Please enter a valid e-mail.");
    }
  }
  
  private static void login() {
    System.out.println("Registration successful!");
  }
  
  private static void switchExpressionNullPattern(Weekdays weekday) {
    switch (weekday) {
      case SUNDAY -> System.out.println(Weekdays.SUNDAY);
      case MONDAY -> System.out.println(Weekdays.MONDAY);
      case TUESDAY -> System.out.println(Weekdays.TUESDAY);
      case WEDNESDAY -> System.out.println(Weekdays.WEDNESDAY);
      case THURSDAY -> System.out.println(Weekdays.THURSDAY);
      case FRIDAY -> System.out.println(Weekdays.FRIDAY);
      case SATURDAY -> System.out.println(Weekdays.SATURDAY);
      case null -> System.out.println("Not a day");
    }
  }
  
  // Switch Expression with Pattern Matching
  private static void switchExpressionWithPatternMatching(Object obj) {
    switch (obj) {
      // Uncommenting will cause the switch to fail since everything falls into Object.
      //case Object o -> System.out.println(o);
      case String str -> System.out.println(str);
      case Integer i -> System.out.println(i);
      case Double d -> System.out.println(d);
      case Boolean b -> System.out.println(b);
      case Weekdays weekday -> System.out.println(weekday);
      case null -> System.out.println("It's " + null); // Literal to avoid ambiguity.
      default -> System.out.println("Not an expected type!");
    };
  }
  
  // Switch Expression with Constant List
  private static void switchExpressionWithConstantList(Weekdays weekday) {
    switch (weekday) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("Workday");
      case SATURDAY, SUNDAY -> System.out.println("Weekend");
    }
  }
  
  // Switch Expression with Arrow Case
  private static void switchExpressionWithArrowCase(Weekdays weekday) {
    switch (weekday) {
      case SUNDAY -> System.out.println(Weekdays.SUNDAY);
      case MONDAY -> System.out.println(Weekdays.MONDAY);
      case TUESDAY -> System.out.println(Weekdays.TUESDAY);
      case WEDNESDAY -> System.out.println(Weekdays.WEDNESDAY);
      case THURSDAY -> System.out.println(Weekdays.THURSDAY);
      case FRIDAY -> System.out.println(Weekdays.FRIDAY);
      case SATURDAY -> System.out.println(Weekdays.SATURDAY);
    }
  }
  
  // Switch Expression with Yield
  private static int switchExpressionWithYield(Operation operation, int num1, int num2) {
    return switch (operation) {
      case ADDITION:
        yield num1 + num2;
      case SUBTRACTION:
        yield num1 - num2;
      case MULTIPLICATION:
        yield num1 * num2;
      case DIVISION:
        yield num1 / num2;
    };
  }
  
  // Traditional Switch with Constant List
  private static void traditionalSwitchWithConstantList(Weekdays weekday) {
    switch (weekday) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
        System.out.println("Workday");
        break;
      case SATURDAY, SUNDAY:
        System.out.println("Weekend");
        break;
    }
  }
  
  // Traditional Switch with Strings
  private static void traditionalSwitchWithStrings(String weekday) {
    switch (weekday) {
      case "Sun":
        System.out.println("Sunday");
        break;
      case "Mon":
        System.out.println("Monday");
        break;
      case "Tue":
        System.out.println("Tuesday");
        break;
      case "Wed":
        System.out.println("Wednesday");
        break;
      case "Thu":
        System.out.println("Thursday");
        break;
      case "Fri":
        System.out.println("Friday");
        break;
      case "Sat":
        System.out.println("Saturday");
        break;
      default:
        System.out.println("Not a day!");
    }
  }
  
  // Traditional Switch with Nested Switch
  private static void traditionalSwitchWithNestedSwitch(int firstExp, int secondExp) {
    switch (firstExp) {
      case 1:
        switch (secondExp) {
          case 1:
          case 3:
            System.out.println("Do this nested thing!");
            break; // Break nested case 1 & 3
          case 2:
          case 4:
            System.out.println("Do this other nested thing!");
            break; // Break nested case 2 & 3
        }
        break; // Without this break, case 2 will be executed every time. Comment it out and give it a run.
      case 2:
        System.out.println("You did not get into the nested switch!");
        break;
    }
  }
  
  // Multiple Cases without Break
  private static void multipleCasesWithoutBreak(Weekdays weekday) {
    switch (weekday) {
      case MONDAY:
      case TUESDAY:
      case WEDNESDAY:
      case THURSDAY:
      case FRIDAY:
        System.out.println("Workday");
        break;
      case SATURDAY:
      case SUNDAY:
        System.out.println("Weekend");
        break;
    }
  }
  
  // Traditional Switch Using Enum
  private static void traditionalSwitchWithEnums(Weekdays weekday) {
    switch (weekday) {
      case SUNDAY:
        System.out.println(Weekdays.SUNDAY);
        break;
      case MONDAY:
        System.out.println(Weekdays.MONDAY);
        break;
      case TUESDAY:
        System.out.println(Weekdays.TUESDAY);
        break;
      case WEDNESDAY:
        System.out.println(Weekdays.WEDNESDAY);
        break;
      case THURSDAY:
        System.out.println(Weekdays.THURSDAY);
        break;
      case FRIDAY:
        System.out.println(Weekdays.FRIDAY);
        break;
      case SATURDAY:
        System.out.println(Weekdays.SATURDAY);
        break;
    }
  }
  
  // Traditional Switch Statement
  private static void traditionalSwitch(int day) {
    
    switch (day) {
      case 1:
        System.out.println("Sunday");
        break;
      case 2:
        System.out.println("Monday");
        break;
      case 3:
        System.out.println("Tuesday");
        break;
      case 4:
        System.out.println("Wednesday");
        break;
      case 5:
        System.out.println("Thursday");
        break;
      case 6:
        System.out.println("Friday");
        break;
      case 7:
        System.out.println("Saturday");
        break;
      default:
        System.out.println("Not a day");
    }
  }
}