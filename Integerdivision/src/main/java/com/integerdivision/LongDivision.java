package com.integerdivision;

public class LongDivision {
  
  private StringBuilder result;
  private StringBuilder remainder;
  private StringBuilder quotient;
  private final String LINE_SEPARATOR;

  public LongDivision() {
      this.result = new StringBuilder();
      this.remainder = new StringBuilder();
      this.quotient = new StringBuilder();
      this.LINE_SEPARATOR = System.lineSeparator();
  }

  public String doDivision(int dividend, int divisor) {

      if (divisor == 0) {
          throw new ArithmeticException("Error! Divisor should be above zero");
      }

      if (dividend < 0) {
          dividend = Math.abs(dividend);
      }
      if (divisor < 0) {
          divisor = Math.abs(divisor);
      }

      if (dividend < divisor) {
          return "Result of integer division " + dividend + " / " + divisor + " = 0";
      }

      return getResultOfDivision(dividend, divisor);
  }

  private String getResultOfDivision(int dividend, int divisor) {
      String[] dividendDigits = String.valueOf(dividend).split("");
      Integer localDividend;
      Integer mod;
      Integer digitsInDivisor = countDigits(divisor);
      Integer squareLocalResult;

      for (int i = 0; i < dividendDigits.length; i++) {
          remainder.append(dividendDigits[i]);
          localDividend = Integer.parseInt(remainder.toString());

          if (localDividend >= divisor) {
              mod = localDividend % divisor;
              squareLocalResult = (localDividend / divisor) * divisor;

              String localDividendString = String.format("%" + (i + 2) + "s", "_" + localDividend.toString());
              result.append(localDividendString).append(LINE_SEPARATOR);

              String squareLocalResultString = String.format("%" + (i + 2) + "d", squareLocalResult);
              result.append(squareLocalResultString).append(LINE_SEPARATOR);

              Integer numberOfSpaces = localDividendString.length() - countDigits(squareLocalResult);
              Integer numberOfDashes = countDigits(localDividend);
              result.append(makeDelimiter(numberOfSpaces, numberOfDashes)).append(LINE_SEPARATOR);

              quotient.append(localDividend / divisor);

              remainder.replace(0, remainder.length(), mod.toString());
              localDividend = Integer.parseInt(remainder.toString());
          }
          else  {
              if (i >= digitsInDivisor) {
                  quotient.append(0);
              }
          }

          if(i == dividendDigits.length - 1) {
              result.append(String.format("%" + (i + 2) + "s", localDividend.toString())).append(LINE_SEPARATOR);
          }
      }
      viewFormatter(dividend, divisor);
      return result.toString();
  }

  private void viewFormatter(Integer dividend, Integer divisor) {
      int[] index = calculateIndexes();

      int numberOfSpaces = countDigits(dividend) + 1 - index[0];
      result.insert(index[2], buildString(numberOfSpaces , ' ') +"|" + quotient.toString());
      result.insert(index[1], buildString(numberOfSpaces, ' ') +"|" + buildString(quotient.length(), '-'));
      result.insert(index[0], "|" + divisor);
      result.replace(1, index[0], dividend.toString());
  }

  private int[] calculateIndexes() {
    int[] index = new int[3];
    char separator;

    if (LINE_SEPARATOR.equals("\r\n") || LINE_SEPARATOR.equals("\r")) {
      separator = '\r';
    } 
    else {
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

  private String makeDelimiter(Integer numberOfSpaces, Integer numberOfDashes) {
      return buildString(numberOfSpaces, ' ') + buildString(numberOfDashes, '-');
  }

  private String buildString(int numberOfSymbols, char symbol) {
      StringBuilder resultString = new StringBuilder();
      for (int i = 0; i < numberOfSymbols; i++) {
          resultString.append(symbol);
      }
      return resultString.toString();
  }

  private int countDigits(int number) {
      int num = number;
      int count = 0;

      while(num != 0) {
          num /= 10;
          count++;
      }
      return count;
  }

}
