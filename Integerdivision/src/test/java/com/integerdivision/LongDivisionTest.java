package com.integerdivision;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongDivisionTest {
  
  LongDivision longDivision = new LongDivision();

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
    
    String actual = longDivision.doDivision(78945, 4);   
    assertEquals(expected, actual);
  }
  
  @Test
  void doDivision_whenDividendEqualDivisor() {
    String expected = 
        "_9876|9876" + System.lineSeparator()
      + " 9876|-" + System.lineSeparator()
      + " ----|1" + System.lineSeparator()
      + "    0" + System.lineSeparator();
    
    String actual = longDivision.doDivision(9876, 9876);
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
    
    String actual = longDivision.doDivision(-123, 3);
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
    
    String actual = longDivision.doDivision(123, -3);
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
    
    String actual = longDivision.doDivision(-123, -3);
    assertEquals(expected, actual);
  }
  
  @Test
  void doDivision_shouldThrowException_whenDividendLessThanDivisor() {
    assertThrows(ArithmeticException.class, () -> longDivision.doDivision(123, 0));  
  }
  
  @Test
  void doDivision_shouldReturnString_whenDividentLessThanDivisor() {
    String expected = "Result of integer division 123 / 124 = 0";
    String actual = longDivision.doDivision(123, 124);   
    assertEquals(expected, actual);
  }
}
