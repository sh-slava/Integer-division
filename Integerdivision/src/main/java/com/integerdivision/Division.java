package com.integerdivision;

import java.util.*;

public class Division {

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
    return getResultOfDivision(dividend, divisor);
  }

  private DivisionResultDTO getResultOfDivision(int dividend, int divisor) {
    StringBuilder remainder = new StringBuilder();
    StringBuilder quotient = new StringBuilder();
    List<IntermediateResult> intermediateResults = new ArrayList<>();

    if (dividend < divisor) {
      quotient.append("0");
      intermediateResults.add(new IntermediateResult(dividend, 0, dividend, Integer.toString(dividend).length() - 1));
      return getDivisionResultDTO(dividend, divisor, quotient, intermediateResults);
    }

    String[] dividendDigits = String.valueOf(dividend).split("");
    int localDividend;
    int mod;
    int digitsInDivisor = DivisionUtils.countDigits(divisor);
    int squareLocalResult;

    for (int digitIndex = 0; digitIndex < dividendDigits.length; digitIndex++) {
      remainder.append(dividendDigits[digitIndex]);
      localDividend = Integer.parseInt(remainder.toString());

      if (localDividend >= divisor) {
        mod = localDividend % divisor;
        squareLocalResult = (localDividend / divisor) * divisor;

        intermediateResults.add(new IntermediateResult(localDividend, squareLocalResult, mod, digitIndex));
        quotient.append(localDividend / divisor);
        remainder.replace(0, remainder.length(), Integer.toString(mod));
      } 
      else {
        if (digitIndex >= digitsInDivisor) {
          quotient.append(0);
        }
      }
    }
    return getDivisionResultDTO(dividend, divisor, quotient, intermediateResults);
  }

  private DivisionResultDTO getDivisionResultDTO(int dividend, int divisor, StringBuilder quotient,
      List<IntermediateResult> intermediateResults) {
    DivisionResultDTO dto = new DivisionResultDTO();
    dto.setDividend(dividend);
    dto.setDivisor(divisor);
    dto.setQuotient(quotient);
    dto.setIntermediateResults(intermediateResults);
    return dto;
  }
}