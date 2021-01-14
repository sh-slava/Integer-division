package com.integerdivision;

import java.util.*;

public class LongDivision {
  private StringBuilder remainder;
  private StringBuilder quotient;
  private List<IntermediateResult> intermediateResults;

  public LongDivision() {
    this.remainder = new StringBuilder();
    this.quotient = new StringBuilder();
    this.intermediateResults = new ArrayList<>();
  }

  public DivisionResultDTO doDivision(int dividend, int divisor) {

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
      quotient.append("0");
      intermediateResults.add(new IntermediateResult(dividend, 0, dividend, Integer.toString(dividend).length() - 1));
      return getDivisionResultDTO(dividend, divisor);
    }
    
    return getResultOfDivision(dividend, divisor);
  }

  private DivisionResultDTO getResultOfDivision(int dividend, int divisor) {
    String[] dividendDigits = String.valueOf(dividend).split("");
    int localDividend;
    int mod;
    int digitsInDivisor = DivisionUtils.countDigits(divisor);
    int squareLocalResult;
    int count;

    for (int i = 0; i < dividendDigits.length; i++) {
      remainder.append(dividendDigits[i]);
      localDividend = Integer.parseInt(remainder.toString());

      if (localDividend >= divisor) {
        mod = localDividend % divisor;
        squareLocalResult = (localDividend / divisor) * divisor;
        count = i;

        intermediateResults.add(new IntermediateResult(localDividend, squareLocalResult, mod, count));
        quotient.append(localDividend / divisor);
        remainder.replace(0, remainder.length(), Integer.toString(mod));
      } else {
        if (i >= digitsInDivisor) {
          quotient.append(0);
        }
      }
    }
    return getDivisionResultDTO(dividend, divisor);
  }

  private DivisionResultDTO getDivisionResultDTO(int dividend, int divisor) {
    DivisionResultDTO dto = new DivisionResultDTO();
    dto.setDividend(dividend);
    dto.setDivisor(divisor);
    dto.setQuotient(quotient);
    dto.setIntermediateResults(intermediateResults);
    return dto;
  }
}
