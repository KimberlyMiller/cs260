package edu.bluecc.cs260.stacks;

public class StackTester {

  public static void main(String[] args) {

//  StringStack stringArrayStack = new StringArrayStack();
//  testStringStack(stringArrayStack);

//  ArrayStack arrayStackString = new ArrayStack();
//  testArrayStackString(arrayStackString);

//  ArrayStack arrayStackInteger = new ArrayStack();
//  testArrayStackInteger(arrayStackInteger);

//  LinkedStack linkedStackString = new LinkedStack();
//  testLinkedStackString(linkedStackString);

  LinkedStack linkedStackInteger = new LinkedStack();
  testLinkedStackInteger(linkedStackInteger);
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

  public static void testArrayStackString(Stack<String> stack) {
//    for (int i = 0; i < 2000; i++)
//      stack.push("Jello");
//    stack.push("Bob");
//    stack.push("Joe");
//    stack.push("Mike");
//    System.out.println(stack.isEmpty());  // false
//    System.out.println(stack.peek()); // Mike
//    System.out.println(stack.pop());  // Mike
//    System.out.println(stack.pop());  // Joe
//    System.out.println(stack.pop());  // Bob
//    System.out.println(stack.isEmpty());  // true
  }

  public static void testArrayStackInteger(Stack<Integer> stack) {
    stack.push(45);
    stack.push(15);
    stack.push(102);
    System.out.println(stack.isEmpty());  // false
    System.out.println(stack.peek()); // 102
    System.out.println(stack.pop());  // 102
    System.out.println(stack.pop());  // 15
    System.out.println(stack.pop());  // 45
    System.out.println(stack.isEmpty());  // true
  }

  public static void testLinkedStackString(Stack<String> stack) {
    stack.push("Bob");
    stack.push("Joe");
    stack.push("Mike");
    System.out.println(stack.isEmpty());  // false
    System.out.println(stack.peek()); // Mike
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());  // true
  }

  public static void testLinkedStackInteger(Stack<Integer> stack) {
    stack.push(45);
    stack.push(15);
    stack.push(102);
    System.out.println(stack.isEmpty());  // false
    System.out.println(stack.peek()); // 102
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());  // true
  }
}