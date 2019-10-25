package edu.bluecc.cs260;

public interface Calculator {

  /**
   * Adds the two integers
   * @param a interger 1
   * @param b integer 2
   * @return the sum of a and b
   */
  public int add(int a, int b);

  /**
   * Subtracts the two integers
   * @param a interger 1
   * @param b integer 2
   * @return a minus b
   */
  public int subtract(int a, int b);

  /**
   * Multiplies the two integers
   * @param a interger 1
   * @param b integer 2
   * @return a times b
   */
  public int multiply(int a, int b);
}
