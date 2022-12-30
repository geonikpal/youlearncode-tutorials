package com.youlearncode;

public class Main {

  public static void main(String[] args) {
    System.out.println(intToRomanHardWay(1994));
    System.out.println(intToRoman(58));
    System.out.println(intToRoman(3));
  }
  
  static final String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
  static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  public static String intToRoman(int num) {
    
    StringBuilder intToRoman = new StringBuilder();
    int index = 0;
    while (num > 0) {
      if (num / values[index] > 0) {
        intToRoman.append(romans[index]);
        num -= values[index];
        continue; // So it won't change the index unless if fails
      }
      index++;
    }
    return intToRoman.toString();
  }
  
  public static String intToRomanHardWay(int num) {
    StringBuilder toRoman = new StringBuilder();
    
    if (num <= 0) return toRoman.toString();
    while (num >= 1000) {
      toRoman.append("M");
      num -= 1000;
    }
    
    if (num >= 900) {
      toRoman.append("CM");
      num -= 900;
    } else {
      if (num >= 500) {
        toRoman.append("D");
        num -= 500;
      } else if (num >= 400) {
        toRoman.append("CD");
        num -= 400;
      }
      while (num >= 100) {
        toRoman.append("C");
        num -= 100;
      }
    }
    if (num >= 90) {
      toRoman.append("XC");
      num -= 90;
    } else {
      if (num >= 50) {
        toRoman.append("L");
        num -= 50;
      } else if (num >= 40) {
        toRoman.append("XL");
        num -= 40;
      }
      while (num >= 10) {
        toRoman.append("X");
        num -= 10;
      }
    }
    if (num == 9) {
      toRoman.append("IX");
    } else {
      if (num >= 5) {
        toRoman.append("V");
        num -= 5;
      } else if (num >= 4) {
        toRoman.append("IV");
        num -= 4;
      }
      while (num-- > 0) toRoman.append("I");
    }
    return toRoman.toString();
  }
}