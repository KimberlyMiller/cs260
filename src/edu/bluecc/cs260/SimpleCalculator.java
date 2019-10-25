package edu.bluecc.cs260;

public class SimpleCalculator implements Calculator{

  /**
   * Adds the two integers
   *
   * @param a interger 1
   * @param b integer 2
   * @return the sum of a and b
   */
  @Override
  public int add(int a, int b) {
    int x = a;
    for (int i = 0; i < b; i++)
      x ++;
    return x;
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
    int x = a;
    for (int i = 0; i < b; i++)
      x--;
    return x;
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
    int x = 0;
    for (int i = 0; i < b; i++)
      x += a;
    return x;
  }
}
