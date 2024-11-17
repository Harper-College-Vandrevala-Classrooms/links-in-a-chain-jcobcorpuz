package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

  GroceryCounter counter;

  @BeforeEach
  void setUp() {
    counter = new GroceryCounter();
  }

  @Test
  void testInitialTotal(){
    assertEquals("$0.00", counter.total());
  }

  @Test
  void testIncrementTens(){
    counter.tens();
    assertEquals("$10.00", counter.total());
  }

  @Test
  void testIncrementOnes(){
    counter.ones();
    assertEquals("$1.00", counter.total());
  }
  @Test
  void testIncrementTenths(){
    counter.tenths();
    assertEquals("$0.10", counter.total());
  }

  @Test
  void testIncrementHundredths(){
    counter.hundredths();
    assertEquals("$0.01", counter.total());
  }

  @Test
  void testTwoTensAndOneHundredths(){
    counter.tens();
    counter.tens();
    counter.hundredths();
    assertEquals("$20.01", counter.total());
  }
  @Test
  void testForLoopOfThirtyFiveOnes(){
    counter.tens();
    counter.tens();
    counter.hundredths();

    for(int i = 0; i < 35; i ++){
      counter.ones();
    }
    assertEquals("$55.01", counter.total());
    assertEquals(0, counter.number_of_overflows());
  }

  @Test
  void testForLoopOfOneHundredOnes(){
    counter.tens();
    counter.tens();
    counter.hundredths();

    for(int i = 0; i < 35; i ++){
      counter.ones();
    }
    for(int i = 0; i < 100; i ++){
      counter.ones();
    }
    assertEquals("$55.02", counter.total());
    assertEquals(1, counter.number_of_overflows());
  }


  @Test
  void testClear(){
    counter.clear();
    assertEquals("$0.00", counter.total());
    assertEquals(0, counter.number_of_overflows());
  }

  @Test
  void itWorks() {
    assertEquals(true, true);
  }

}
