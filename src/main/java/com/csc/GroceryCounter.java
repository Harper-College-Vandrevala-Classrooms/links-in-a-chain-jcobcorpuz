package com.csc;

public class GroceryCounter {
  private int counter;
  private int overflows;

  public GroceryCounter(){
      this.counter = 0;
      this.overflows = 0;
  }

  public void tens(){
      counter += 1000;
      checkOverflow();
  }

  public void ones(){
      counter += 100;
      checkOverflow();
  }

  public void tenths(){
      counter += 10;
      checkOverflow();
  }

  public void hundredths(){
      counter += 1;
      checkOverflow();
  }

  public String total(){
      int dollars = counter / 100;
      int cents = counter % 100;
      return String.format("$%d.%02d", dollars, cents);
  }

  private void checkOverflow(){
      if(counter > 9999){
          overflows++;
          counter -= 9999;
      }
  }


  public int number_of_overflows(){
      return overflows;
  }
  public void clear(){
      counter = 0;
      overflows = 0;
  }

  public static void main(String[] args){
      GroceryCounter counter = new GroceryCounter();

      System.out.println(counter.total());

      counter.tens();
      counter.tens();
      counter.hundredths();

      System.out.println(counter.total());
      System.out.println(counter.number_of_overflows());

      for(int i = 0; i < 35; i++) {
          counter.ones();
      }

      System.out.println(counter.total());
      System.out.println(counter.number_of_overflows());

      for(int i = 0; i < 100; i++) {
          counter.ones();
      }

      System.out.println(counter.total());
      System.out.println(counter.number_of_overflows());

      counter.clear();

      System.out.println(counter.total());
      System.out.println(counter.number_of_overflows());
  }
}
