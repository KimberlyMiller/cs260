package edu.bluecc.cs260.stacks;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {

  public static void main(String[] args) { } // DELETE this later, it just wouldn't compile without it
  private Node<E> top; // this is what shows that they are linked together.
  private Node<E> first;
  private int size = 0;

  /**
   * Pushes a value onto the top of this stack
   *
   * @param item - the value to be pushed onto the stack
   * @return the value
   */
  @Override
  public E push(E item) {
    Node node = new Node(item);
    if (first == null)
      first =  node;
    else {
      top.setNext(node);
    }
    top =  node;
    size++;
    return item;
  }

  /**
   * Pops a value off the stack
   *
   * @return the popped value
   */
  @Override
  public E pop() {
    if (isEmpty())
      throw new EmptyStackException();

    Node node = top;
    top =  top.getNext();
    size--;
    // think about how you move your top pointer in here to remove from the top
    return top.getValue();
  }

  /**
   * Returns the top value without removing it
   *
   * @return the top value
   */
  @Override
  public E peek() {
    return top.getValue();
  }

  /**
   * Tests if this stack is empty
   *
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
      return (first == null);
  }
}
