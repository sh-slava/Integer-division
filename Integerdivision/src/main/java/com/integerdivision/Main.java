package com.integerdivision;

public class Main {

  public static void main(String[] args) {
    
    LongDivision longDivision = new LongDivision();
    int dividend = 78945;
    int divisor = 4;
    
    System.out.println(longDivision.doDivision(dividend, divisor));
  }
}
