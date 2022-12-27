package com.youlearncode.enums;

public enum OrderStatus implements Enumerable {
  PROCESSED(1, "Processed"),
  PENDING(2, "Pending"),
  OVERDUE(3, "Overdue"),
  AUTHORIZED(4, "Authorized"),
  SHIPPED(5, "Shipped"),
  CANCELED(6, "Canceled") {
    @Override
    public String getStatus() {
      return "We can no longer take care of your Order. It has been canceled. :(";
    }
  };

  private final String description;
  private final int code;
  
  OrderStatus(int code, String description) {
    this.code = code;
    this.description = description;
    // Uncommenting will print enums being constructed.
    //System.out.println(this + " was constructed!"); // Print the enum being constructed
  }
  
  @Override
  public String getDescription() { return description; }
  @Override
  public int getCode() { return code; }
  
  public String getStatus() {
    return "Don't worry, your Order is being taken care of. :)";
  }
  
  // No longer needed now that we have one in the interface
  //public static OrderStatus toEnum(int code) {
  //  for (var e : OrderStatus.values()) {
  //    if (e.code == code)
  //      return e;
  //  }
  //  throw new IllegalArgumentException("No CONSTANT found for code: " + code);
  //}
  
  public static OrderStatus toEnumFaster(int code) {
    if (code > 0 && code <= OrderStatus.values().length)
      return OrderStatus.values()[code-1];
    throw new IllegalArgumentException("No CONSTANT found for code: " + code);
  }
  
  // Got replaced by a better version below
  //@Override
  //public String toString() {
  //  return "Enum description: " + description + ", code: " + code + ".";
  //}
  
  @Override
  public String toString() { return format(); }
}