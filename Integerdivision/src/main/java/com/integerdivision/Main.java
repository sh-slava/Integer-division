package com.integerdivision;

public class Main {

  public static void main(String[] args) {
    
    Division division = new Division();
    int dividend = 78945;
    int divisor = 4;
    System.out.println(division.doLongDivision(dividend, divisor));
  }
}
