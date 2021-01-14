package com.integerdivision;

import java.util.List;

public class DivisionResultDTO {
  private int dividend;
  private int divisor;
  private StringBuilder quotient;
  private List<IntermediateResult> intermediateResults;

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

  public List<IntermediateResult> getIntermediateResults() {
      return intermediateResults;
  }

  public void setIntermediateResults(List<IntermediateResult> intermediateResults) {
      this.intermediateResults = intermediateResults;
  }
}
