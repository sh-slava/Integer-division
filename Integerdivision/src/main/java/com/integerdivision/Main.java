package com.integerdivision;

public class Main {

  public static void main(String[] args) {
    
    Formatter formatter = new Formatter();

    Division longDivision = new Division();
    int dividend = 78945;
    int divisor = 4;
    DivisionResultDTO divisionResultDTO = longDivision.doDivision(dividend, divisor);
    System.out.println(formatter.format(divisionResultDTO));
  }
}
