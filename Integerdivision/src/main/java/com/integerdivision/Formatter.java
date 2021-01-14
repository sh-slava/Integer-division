package com.integerdivision;

import java.util.List;

public class Formatter {
  private int dividend;
  private int divisor;
  private StringBuilder result;
  private StringBuilder quotient;
  private final String LINE_SEPARATOR = System.lineSeparator();

  public String format(DivisionResultDTO dto) {
      List<IntermediateResult> intermediateResults = dto.getIntermediateResults();
      this.dividend = dto.getDividend();
      this.divisor = dto.getDivisor();
      this.quotient = dto.getQuotient();
      this.result = new StringBuilder();

      int localDividend;
      int squareLocalResult;
      int count;
      int endOfFormatting = intermediateResults.size() - 1;

      for (int i = 0; i < intermediateResults.size(); i++) {
          localDividend = intermediateResults.get(i).getLocalDividend();
          squareLocalResult = intermediateResults.get(i).getSquareLocalResult();
          count = intermediateResults.get(i).getCount();

          String localDividendString = String.format("%" + (count + 2) + "s", "_" + localDividend);
          result.append(localDividendString).append(LINE_SEPARATOR);

          String squareLocalResultString = String.format("%" + (count + 2) + "d", squareLocalResult);
          result.append(squareLocalResultString).append(LINE_SEPARATOR);

          int numberOfSpaces = localDividendString.length() - DivisionUtils.countDigits(squareLocalResult);
          if (intermediateResults.size() == 1) {
              numberOfSpaces = 1;
          }
          int numberOfDashes = DivisionUtils.countDigits(localDividend);
          result.append(DivisionUtils.makeDelimiter(numberOfSpaces, numberOfDashes)).append(LINE_SEPARATOR);

          if (i == endOfFormatting) {
              result.append(String.format("%" + (count + 2) + "d", intermediateResults.get(i).getMod()))
                      .append(LINE_SEPARATOR);
          }
      }
      finalFormatting();
      return result.toString();
  }

  private void finalFormatting() {
      int[] index = calculateIndexes();

      int numberOfSpaces = DivisionUtils.countDigits(dividend) + 1 - index[0];
      result.insert(index[2], DivisionUtils.buildString(numberOfSpaces, ' ') + "|" + quotient.toString());
      result.insert(index[1], DivisionUtils.buildString(numberOfSpaces, ' ') + "|"
              + DivisionUtils.buildString(quotient.length(), '-'));
      result.insert(index[0], "|" + divisor);
      result.replace(1, index[0], Integer.toString(dividend));
  }

  private int[] calculateIndexes() {
      int[] index = new int[3];
      char separator;

      if (LINE_SEPARATOR.equals("\r\n") || LINE_SEPARATOR.equals("\r")) {
          separator = '\r';
      } else {
          separator = '\n';
      }
      findIndexes(index, separator);
      return index;
  }

  private void findIndexes(int[] index, char separator) {
      for (int i = 0, j = 0; i < result.length(); i++) {
          if (result.charAt(i) == separator) {
              index[j] = i;
              j++;
          }
          if (j == 3) {
              break;
          }
      }
  }
}
