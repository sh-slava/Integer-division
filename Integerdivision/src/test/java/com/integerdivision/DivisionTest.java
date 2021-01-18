package com.integerdivision;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionTest {
  
  Formatter formatter = new Formatter();
  Division division = new Division();

  @Test
  void doDivision_whenSimpleIntegers() {
    String expected =
        "_78945|4" + System.lineSeparator()
      + " 4    |-----" + System.lineSeparator()
      + " -    |19736" + System.lineSeparator()
      + "_38" + System.lineSeparator()
      + " 36" + System.lineSeparator()
      + " --" + System.lineSeparator()
      + " _29" + System.lineSeparator()
      + "  28" + System.lineSeparator()
      + "  --" + System.lineSeparator()
      + "  _14" + System.lineSeparator()
      + "   12" + System.lineSeparator()
      + "   --" + System.lineSeparator()
      + "   _25" + System.lineSeparator()
      + "    24" + System.lineSeparator()
      + "    --" + System.lineSeparator()
      + "     1" + System.lineSeparator();
  
    String actual = formatter.format(division.doDivision(78945, 4));
    assertEquals(expected, actual);
  }
  
  @Test
  void doDivision_whenDividendEqualDivisor() {
    String expected =
        "_9876|9876" + System.lineSeparator()
      + " 9876|-" + System.lineSeparator()
      + " ----|1" + System.lineSeparator()
      + "    0" + System.lineSeparator();
  
    String actual = formatter.format(division.doDivision(9876, 9876));
    assertEquals(expected, actual);
  }
  
  @Test
  void doDivision_whenNegativeDividend() {
    String expected =
        "_123|3" + System.lineSeparator()
      + " 12 |--" + System.lineSeparator()
      + " -- |41" + System.lineSeparator()
      + "  _3" + System.lineSeparator()
      + "   3" + System.lineSeparator()
      + "   -" + System.lineSeparator()
      + "   0" + System.lineSeparator();
  
    String actual = formatter.format(division.doDivision(-123, 3));
    assertEquals(expected, actual);
  }
  
  @Test
  void doDivision_whenNegativeDivisor() {
    String expected =
        "_123|3" + System.lineSeparator()
      + " 12 |--" + System.lineSeparator()
      + " -- |41" + System.lineSeparator()
      + "  _3" + System.lineSeparator()
      + "   3" + System.lineSeparator()
      + "   -" + System.lineSeparator()
      + "   0" + System.lineSeparator();
  
    String actual = formatter.format(division.doDivision(123, -3));
    assertEquals(expected, actual);
  }
  
  @Test
  void doDivision_whenBothNegative() {
    String expected =
        "_123|3" + System.lineSeparator()
      + " 12 |--" + System.lineSeparator()
      + " -- |41" + System.lineSeparator()
      + "  _3" + System.lineSeparator()
      + "   3" + System.lineSeparator()
      + "   -" + System.lineSeparator()
      + "   0" + System.lineSeparator();
  
    String actual = formatter.format(division.doDivision(-123, -3));
    assertEquals(expected, actual);
  }
  
  @Test
  void doDivision_whenDividendLessThanDivisor() {
    String expected =
        "_123|1234" + System.lineSeparator()
      + "   0|-" + System.lineSeparator()
      + " ---|0" + System.lineSeparator()
      + " 123" + System.lineSeparator();
  
    String actual = formatter.format(division.doDivision(123, 1234));
    assertEquals(expected, actual);
  }
  
  @Test
  void doDivision_whenDividendIsZero() {
    String expected =
        "_0|123" + System.lineSeparator()
      + " 0|-" + System.lineSeparator()
      + " -|0" + System.lineSeparator()
      + " 0" + System.lineSeparator();
  
    String actual = formatter.format(division.doDivision(0, 123));
    assertEquals(expected, actual);
  }
  
  @Test
  void doDivision_shouldThrowArithmeticException_whenDivisorIsZero() {
    assertThrows(ArithmeticException.class, () -> division.doDivision(123, 0));
  }
  
  @Test
  void doDivision_shouldThrowArithmeticException_whenBothZero() {
    assertThrows(ArithmeticException.class, () -> division.doDivision(0, 0));
  }
}
