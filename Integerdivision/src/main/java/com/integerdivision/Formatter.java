package com.integerdivision;

public class Formatter {
  private int dividend;
  private int divisor;
  private StringBuilder result;
  private StringBuilder quotient;
  private final String LINE_SEPARATOR = System.lineSeparator();

  public String format(DivisionResultDTO dto) {
      setVariables(dto);
      int[] index = calculateIndexes();

      int numberOfSpaces = DivisionUtils.countDigits(dividend) + 1 - index[0];
      result.insert(index[2], DivisionUtils.buildString(numberOfSpaces, ' ') + "|" + quotient.toString());
      result.insert(index[1], DivisionUtils.buildString(numberOfSpaces, ' ') + "|"
              + DivisionUtils.buildString(quotient.length(), '-'));
      result.insert(index[0], "|" + divisor);
      result.replace(1, index[0], Integer.toString(dividend));

      return result.toString();
  }

  private void setVariables(DivisionResultDTO dto) {
      this.dividend = dto.getDividend();
      this.divisor = dto.getDivisor();
      this.result = dto.getResult();
      this.quotient = dto.getQuotient();
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
