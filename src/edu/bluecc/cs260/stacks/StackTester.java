package edu.bluecc.cs260.stacks;

public class StackTester {

  public static void main(String[] args) {
    ArrayStack<Integer> integerArrayStack = new ArrayStack<>();
    testIntegerStack(integerArrayStack);

    ArrayStack<String> stringArrayStack = new ArrayStack<>();
    testStringStack(stringArrayStack);

    LinkedStack<Integer> linkedIntegerStack = new LinkedStack<>();
    testIntegerStack(linkedIntegerStack);
  }

  public static void testIntegerStack(Stack<Integer> stack) {
    stack.push(10);
    stack.push(-10);
    stack.push(123564);
    System.out.println(stack.pop());  // 123564
  }

  public static void testStringStack(Stack<String> stack) {
    for (int i = 0; i < 2000; i++)
    stack.push("Jello");
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
