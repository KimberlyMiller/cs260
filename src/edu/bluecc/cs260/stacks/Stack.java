package edu.bluecc.cs260.stacks;

public interface Stack<E> {

  /**
   * Pushes a value onto the top of this stack
   * @param item - the value to be pushed onto the stack
   * @return the value
   */
  public E push(E item);

  /**
   * Pops a value off the stack
   * @return the popped value
   */
  public E pop();

  /**
   * Returns the top value without removing it
   * @return the top value
   */
  public E peek();

  /**
   * Tests if this stack is empty
   * @return true if the stack is empty, false otherwise
   */
  public boolean isEmpty();
}
