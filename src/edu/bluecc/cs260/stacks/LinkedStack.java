package edu.bluecc.cs260.stacks;

public class LinkedStack<E> implements Stack<E> {

  public static void main(String[] args) { } // DELETE this later, it just wouldn't compile without it
  private Node<E> top; // this is what shows that they are linked together.

  /**
   * Pushes a value onto the top of this stack
   *
   * @param item - the value to be pushed onto the stack
   * @return the value
   */
  @Override
  public E push(E item) {
    // TODO write this method
    return null;
  }

  /**
   * Pops a value off the stack
   *
   * @return the popped value
   */
  @Override
  public E pop() {
    // TODO write this method
    // think about how you move your top pointer in here to remove from the top
    return null;
  }

  /**
   * Returns the top value without removing it
   *
   * @return the top value
   */
  @Override
  public E peek() {
    // TODO write this method
    return null;
  }

  /**
   * Tests if this stack is empty
   *
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    // TODO write this method
    return false;
  }
}
