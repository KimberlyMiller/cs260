package edu.bluecc.cs260.stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {

    private E[] a = (E[])new Object[1000];
    private int top = -1;

    /**
     * Pushes a value onto the top of this stack
     * @param item - the value to be pushed onto the stack
     * @return the value
     */
    @Override
    public E push(E item) {
      a[++top] = item;
      if (top > 0.8*a.length)
        a = Arrays.copyOf(a,(int)(1.5*a.length)); // re-size the array
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
      return a[top--];
    }

    /**
     * Returns the top value without removing it
     * @return the top value
     */
    @Override
    public E peek() {
      return a[top];
    }

    /**
     * Tests if this stack is empty
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
      return top < 0;
    }
  }
