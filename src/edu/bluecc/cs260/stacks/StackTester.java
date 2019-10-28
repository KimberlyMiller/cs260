package edu.bluecc.cs260.stacks;

public class StackTester {

  public static void main(String[] args) {
    ArrayStack arrayStack = new ArrayStack();
    test(arrayStack);
  }

  public static void test(Stack stack) {
    stack.push("B");
    stack.push("C");
    stack.push("A");
    stack.push("D");
    System.out.println(stack.pop());  // D
    System.out.println(stack.pop());  // A
    System.out.println(stack.pop());  // C
    System.out.println(stack.peek());  // B
    System.out.println(stack.isEmpty());  // false
    System.out.println(stack.pop());  // B
    System.out.println(stack.isEmpty());  // true

  }

}
