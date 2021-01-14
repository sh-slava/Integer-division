package com.integerdivision;

public class DivisionUtils {

  private DivisionUtils() {
    throw new IllegalStateException("This is Utility class");
  }

  public static String makeDelimiter(int numberOfSpaces, int numberOfDashes) {
    return buildString(numberOfSpaces, ' ') + buildString(numberOfDashes, '-');
  }

  public static String buildString(int numberOfSymbols, char symbol) {
    StringBuilder resultString = new StringBuilder();
    
    for (int i = 0; i < numberOfSymbols; i++) {
      resultString.append(symbol);
    }  
    return resultString.toString();
  }

  public static int countDigits(int number) {
    if (number != 0) {
      return (int) Math.abs(Math.log10(number)) + 1;
    }
    return 1;
  }
}
