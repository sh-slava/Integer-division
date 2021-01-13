package com.integerdivision;

public class DivisionUtils {

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
    int count = 0;

    while (number != 0) {
      number /= 10;
      count++;
    }
    return count;
  }
}
