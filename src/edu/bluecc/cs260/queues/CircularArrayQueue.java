package edu.bluecc.cs260.queues;

import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements Queue<E> {

  public static void main(String[] args) {

  }

  private E[] a = (E[])(new Object[1000]);
  // values have to match the contracts.  Only cast the data types when pulling the information at runtime.

  private int front = 0;
  private int back = 0;
  private int end = -1;

  /**
   * Adds an element to the queue. Returns false if the queue is full.
   * @param value - the value to add
   * @return - true if the element was added, false otherwise
   */
  @Override
  public boolean add(E value) {
    // if the queue is full, return false
    // if back is one less than front -- the queue is full

    // put the element in "back", then  increment back (circularly, usuing the modulo operator)
    return false;
  }


  /**
   * @return true if this queue contains no elements
   */
  @Override
  public E remove() {
    if (isEmpty())
      throw new NoSuchElementException("Queue is Empty");
    return null;
  }

  @Override
  public boolean isEmpty() {
    // if the queue is empty, then front and back are the same
    return false;
  }

  /**
   * Clears the queue
   */
  @Override
  public void clear() {
    // if the queue should be empty after this method is executed.
  }
}
