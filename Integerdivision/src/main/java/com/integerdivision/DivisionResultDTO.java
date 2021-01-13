package com.integerdivision;

public class DivisionResultDTO {
    private int dividend;
    private int divisor;
    private StringBuilder result;
    private StringBuilder quotient;

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

    public StringBuilder getResult() {
        return result;
    }

    public void setResult(StringBuilder result) {
        this.result = result;
    }

    public StringBuilder getQuotient() {
        return quotient;
    }

    public void setQuotient(StringBuilder quotient) {
        this.quotient = quotient;
    }
}
