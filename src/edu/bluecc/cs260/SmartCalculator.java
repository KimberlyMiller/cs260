package edu.bluecc.cs260;

public class SmartCalculator implements Calculator {

  /**
   * Adds the two integers
   *
   * @param a interger 1
   * @param b integer 2
   * @return the sum of a and b
   */
  @Override
  public int add(int a, int b) {
    return a+b;
  }

  /**
   * Subtracts the two integers
   *
   * @param a interger 1
   * @param b integer 2
   * @return a minus b
   */
  @Override
  public int subtract(int a, int b) {
    return a-b;
  }

  /**
   * Multiplies the two integers
   *
   * @param a interger 1
   * @param b integer 2
   * @return a times b
   */
  @Override
  public int multiply(int a, int b) {
    return a*b;
  }

  public double divide(int a, int b) {
    return a*1.0/b;
  }

}
