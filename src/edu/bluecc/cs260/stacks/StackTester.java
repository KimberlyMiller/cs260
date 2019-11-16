package edu.bluecc.cs260.stacks;

import edu.princeton.stlib.StdOut;

public class StackTester {

  public static void main(String[] args) {
//    Stack<String> stack = new ArrayStack<>();
//    testStack(stack);
//
//    StringStack stringArrayStack = new StringArrayStack();
//    testStringStack(stringArrayStack);
//
//    ArrayStack arrayStringStack = new ArrayStack();
//    testStringArrayStack(arrayStringStack);
//
//    ArrayStack arrayIntegerStack = new ArrayStack();
//    testIntegerArrayStack(arrayIntegerStack);
//
    LinkedStack linkedStringStack = new LinkedStack();
    testStringLinkedStack(linkedStringStack);
//
//    LinkedStack linkedIntegerStack = new LinkedStack();
//    testIntegerLinkedStack(linkedIntegerStack);
  }

  public static void testStringLinkedStack(Stack<String> stack) {
    for (int i = 0; i < 3; i++)
      stack.push("Jello");
    System.out.println(stack.isEmpty());  // false
   // System.out.println(stack.pop());  // Jello
   // System.out.println(stack.peek());
  //  System.out.println(stack.isEmpty());  // true
  }

  public static void testIntegerLinkedStack(Stack<Integer> stack) {
    for (int i = 0; i < 3; i++)
      stack.push(1);
    System.out.println(stack.isEmpty());  // false
    System.out.println(stack.pop());  // 1
    System.out.println(stack.pop());  // 1
    System.out.println(stack.pop());  // 1
    System.out.println(stack.isEmpty());  // true
  }

  public static void testStringArrayStack(Stack<String> stack) {
    for (int i = 0; i < 3; i++)
      stack.push("Jello");
    System.out.println(stack.isEmpty());  // false
    System.out.println(stack.pop());  // Jello
    System.out.println(stack.pop());  // Jello
    System.out.println(stack.peek());
    System.out.println(stack.pop());  // Jello
    System.out.println(stack.isEmpty());  // true
  }

  public static void testIntegerArrayStack(Stack<Integer> stack) {
    for (int i = 0; i < 3; i++)
      stack.push(1);
    System.out.println(stack.isEmpty());  // false
    System.out.println(stack.pop());  // 1
    System.out.println(stack.pop());  // 1
    System.out.println(stack.peek());
    System.out.println(stack.pop());  // 1
    System.out.println(stack.isEmpty());  // true
  }

  public static void testStack(Stack<String> stack) {
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


  public static void testStringStack(StringStack stack) {
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
