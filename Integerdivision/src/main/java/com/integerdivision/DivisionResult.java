package com.integerdivision;

import java.util.List;

public class DivisionResult {
  private int dividend;
  private int divisor;
  private StringBuilder quotient;
  private List<DivisionIntermediateResult> intermediateResults;

  public int getDividend() {
      return dividend;
  }

  public void setDividend(int dividend) {
      this.dividend = dividend;
  }

  public int getDivisor() {
      return divisor;
  }

  public void setDivisor(int divisor) {
      this.divisor = divisor;
  }

  public StringBuilder getQuotient() {
      return quotient;
  }

  public void setQuotient(StringBuilder quotient) {
      this.quotient = quotient;
  }

  public List<DivisionIntermediateResult> getIntermediateResults() {
      return intermediateResults;
  }

  public void setIntermediateResults(List<DivisionIntermediateResult> intermediateResults) {
      this.intermediateResults = intermediateResults;
  }
}
