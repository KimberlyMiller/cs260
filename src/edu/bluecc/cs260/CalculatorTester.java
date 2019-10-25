package edu.bluecc.cs260;

public class CalculatorTester {

  public static void main(String[] args) {
    test(new SimpleCalculator());

    testSimple();
    testSmart();
  }

  public static void test(Calculator calc) {
    System.out.println("\n\nActual Calculator");
    System.out.println(calc.add(2,5));  // 7
    System.out.println(calc.subtract(2,5));  // -3
    System.out.println(calc.multiply(2,5));  // 10
  }

  public static void testSimple() {
    System.out.println("\n\nTest Calculator");
    SimpleCalculator calc = new SimpleCalculator();
    System.out.println(calc.add(2,5));  // 7
    System.out.println(calc.subtract(2,5));  // -3
    System.out.println(calc.multiply(2,5));  // 10
  }

  public static void testSmart() {
    System.out.println("\n\nSmart Calculator");
    SmartCalculator calc = new SmartCalculator();
    System.out.println(calc.add(2,5));  // 7
    System.out.println(calc.subtract(2,5));  // -3
    System.out.println(calc.multiply(2,5));  // 10
    System.out.println(calc.divide(2,5));  // 10
  }
}
