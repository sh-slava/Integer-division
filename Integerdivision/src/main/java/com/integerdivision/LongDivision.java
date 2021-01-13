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
    int localDividend;
    int mod;
    int digitsInDivisor = DivisionUtils.countDigits(divisor);
    int squareLocalResult;

    for (int i = 0; i < dividendDigits.length; i++) {
      remainder.append(dividendDigits[i]);
      localDividend = Integer.parseInt(remainder.toString());

      if (localDividend >= divisor) {
        mod = localDividend % divisor;
        squareLocalResult = (localDividend / divisor) * divisor;

        String localDividendString = String.format("%" + (i + 2) + "s", "_" + Integer.toString(localDividend));
        result.append(localDividendString).append(LINE_SEPARATOR);

        String squareLocalResultString = String.format("%" + (i + 2) + "d", squareLocalResult);
        result.append(squareLocalResultString).append(LINE_SEPARATOR);

        int numberOfSpaces = localDividendString.length() - DivisionUtils.countDigits(squareLocalResult);
        int numberOfDashes = DivisionUtils.countDigits(localDividend);
        result.append(DivisionUtils.makeDelimiter(numberOfSpaces, numberOfDashes)).append(LINE_SEPARATOR);

        quotient.append(localDividend / divisor);

        remainder.replace(0, remainder.length(), Integer.toString(mod));
        localDividend = Integer.parseInt(remainder.toString());
      } 
      else {
        if (i >= digitsInDivisor) {
          quotient.append(0);
        }
      }

      if (i == dividendDigits.length - 1) {
        result.append(String.format("%" + (i + 2) + "s", Integer.toString(localDividend))).append(LINE_SEPARATOR);
      }
    }
    
    return prettyFormatting(dividend, divisor);
  }

  private String prettyFormatting(int dividend, int divisor) {
    Formatter formatter = new Formatter();

    DivisionResultDTO dto = new DivisionResultDTO();
    dto.setDividend(dividend);
    dto.setDivisor(divisor);
    dto.setResult(result);
    dto.setQuotient(quotient);

    return formatter.format(dto);
  }
}
