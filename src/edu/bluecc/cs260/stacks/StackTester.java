package edu.bluecc.cs260.stacks;

public class StackTester {

  public static void main(String[] args) {
    Stack<String> stack = new ArrayStack<>();
    testStack(stack);

    StringStack stringArrayStack = new StringArrayStack();
    testStringStack(stringArrayStack);
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
