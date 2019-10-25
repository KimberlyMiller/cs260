package edu.bluecc.cs260.queues;

import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements Queue<E> {
  private E[] a = (E[])(new Object[1000]);
  // values have to match the contracts.  Only cast the data types when pulling the information at runtime.

  private int front = 0;
  private int back - 0;

  @Override
  public boolean add(E value) {
    // if the queue is full, return false
    // if back is one less than front -- the queue is full

    // put the element in "back", then  increment back (circularly)
    return false;
  }

  /**
   * Removes a value from the front of the queue
   *
   * @return - the removed value
   */
  @Override
  public E remove() {
    if (isEmpty())
      throw new NoSuchElementException("Queue is Empty");
    // does something else go here?.....
    return null;
  }

  @Override
  public boolean isEmpty() {
    // if the queue is empty, then front and back are the same
    if
    return false;
  }

  @Override
  public boolean clear() {
    // if the queue should be empty after this method is executed.
    return false;
  }
}