package com.integerdivision;

public class Division {

  public String doLongDivision(int dividend, int divisor) {
    LongDivision longDivision = new LongDivision();
    return longDivision.doDivision(dividend, divisor);
  }

}
