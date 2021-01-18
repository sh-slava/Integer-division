package com.integerdivision;

import java.util.List;

public class Formatter {
  private final String LINE_SEPARATOR = System.lineSeparator();

  public String format(DivisionResult dto) {
    List<DivisionIntermediateResult> intermediateResults = dto.getIntermediateResults();
    int dividend = dto.getDividend();
    int divisor = dto.getDivisor();
    StringBuilder quotient = dto.getQuotient();
    StringBuilder result = new StringBuilder();

    int localDividend;
    int squareLocalResult;
    int digitIndex = 0;

    for (int i = 0; i < intermediateResults.size(); i++) {
      DivisionIntermediateResult intermediateResult = intermediateResults.get(i);
      localDividend = intermediateResult.getLocalDividend();
      squareLocalResult = intermediateResult.getSquareLocalResult();
      digitIndex = intermediateResult.getDigitIndex();

      String localDividendString = String.format("%" + (digitIndex + 2) + "s", "_" + localDividend);
      result.append(localDividendString).append(LINE_SEPARATOR);

      String squareLocalResultString = String.format("%" + (digitIndex + 2) + "d", squareLocalResult);
      result.append(squareLocalResultString).append(LINE_SEPARATOR);

      int numberOfSpaces;
      if (intermediateResults.size() == 1) {
        numberOfSpaces = 1;
      } 
      else {
        numberOfSpaces = localDividendString.length() - DivisionUtils.countDigits(squareLocalResult);
      }
      int numberOfDashes = DivisionUtils.countDigits(localDividend);
      result.append(DivisionUtils.buildDelimiter(numberOfSpaces, numberOfDashes)).append(LINE_SEPARATOR);
    }
    
    int lastDigit = intermediateResults.get(intermediateResults.size() - 1).getMod(); 
    result.append(String.format("%" + (digitIndex + 2) + "d", lastDigit)).append(LINE_SEPARATOR);

    finalFormatting(dividend, divisor, result, quotient);
    return result.toString();
  }

  private void finalFormatting(int dividend, int divisor, StringBuilder result, StringBuilder quotient) {
    int[] newLineIndex = findNewLineIndexes(result);

    int numberOfSpaces = DivisionUtils.countDigits(dividend) + 1 - newLineIndex[0];
    result.insert(newLineIndex[2], DivisionUtils.buildString(numberOfSpaces, ' ') + "|" + quotient.toString());
    result.insert(newLineIndex[1],
        DivisionUtils.buildString(numberOfSpaces, ' ') + "|" + DivisionUtils.buildString(quotient.length(), '-'));
    result.insert(newLineIndex[0], "|" + divisor);
    result.replace(1, newLineIndex[0], Integer.toString(dividend));
  }

  private int[] findNewLineIndexes(StringBuilder result) {
    char separator;

    if (LINE_SEPARATOR.equals("\r\n") || LINE_SEPARATOR.equals("\r")) {
      separator = '\r';
    } 
    else {
      separator = '\n';
    }

    return findNewLineIndexes(separator, result);
  }

  private int[] findNewLineIndexes(char separator, StringBuilder result) {
    int[] newLineIndexes = new int[3];

    for (int i = 0, j = 0; i < result.length(); i++) {
      if (result.charAt(i) == separator) {
        newLineIndexes[j] = i;
        j++;
      }
      if (j == 3) {
        break;
      }
    }
    return newLineIndexes;
  }
}
