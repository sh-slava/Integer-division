package com.integerdivision;

public class IntermediateResult {
  private final int localDividend;
  private final int squareLocalResult;
  private final int mod;
  private final int count;

  public IntermediateResult(int localDividend, int squareLocalResult, int mod, int count) {
      this.localDividend = localDividend;
      this.squareLocalResult = squareLocalResult;
      this.mod = mod;
      this.count = count;
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

  public int getCount() {
      return count;
  }
}
