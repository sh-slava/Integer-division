package com.integerdivision;

public class IntermediateResult {
  private final int localDividend;
  private final int squareLocalResult;
  private final int mod;
  private final int digitIndex;

  public IntermediateResult(int localDividend, int squareLocalResult, int mod, int digitIndex) {
      this.localDividend = localDividend;
      this.squareLocalResult = squareLocalResult;
      this.mod = mod;
      this.digitIndex = digitIndex;
  }

  public int getLocalDividend() {
      return localDividend;
  }

  public int getSquareLocalResult() {
      return squareLocalResult;
  }

  public int getMod() {
      return mod;
  }

  public int getDigitIndex() {
      return digitIndex;
  }
}
