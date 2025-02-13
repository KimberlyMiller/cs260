package edu.bluecc.cs260.stacks;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {

  private Node<E> top; // this is what shows that they are linked together.
  private int size = 0;

  /**
   * Pushes a value onto the top of this stack
   * @param item - the value to be pushed onto the stack
   * @return the value
   */
  @Override
  public E push(E item) {
    Node node = new Node(item);
    if (top == null)
      top =  node;
    else {
      node.setNext(top);
    }
    top =  node;
    size++;
    return item;
  }

  /**
   * Pops a value off the stack
   * @return the popped value
   */
  @Override
  public E pop() {
    if (isEmpty())
      throw new EmptyStackException();
    E item = top.getValue();
    top = top.getNext();
    size--;
    return item;
  }

  /**
   * Returns the top value without removing it
   * @return the top value
   */
  @Override
  public E peek() {
    return top.getValue();
  }

  /**
   * Tests if this stack is empty
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
      return (top == null);
  }
}
