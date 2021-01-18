package com.integerdivision;

import java.util.List;

public class DivisionResult {
  private final int dividend;
  private final int divisor;
  private final StringBuilder quotient;
  private final List<DivisionIntermediateResult> intermediateResults;

  public DivisionResult(int dividend, int divisor, StringBuilder quotient,
      List<DivisionIntermediateResult> intermediateResults) {
    this.dividend = dividend;
    this.divisor = divisor;
    this.quotient = quotient;
    this.intermediateResults = intermediateResults;
  }

  public int getDividend() {
      return dividend;
  }

  public int getDivisor() {
      return divisor;
  }

  public StringBuilder getQuotient() {
      return quotient;
  }

  public List<DivisionIntermediateResult> getIntermediateResults() {
      return intermediateResults;
  }
}
