package edu.bluecc.cs260.queues;

import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements Queue<E> {

  public static void main(String[] args) {
  }

  private E[] a = (E[])(new Object[1000]);
  // values have to match the contracts.  Only cast the data types when pulling the information at runtime.

  private int front = 0;
  private int back = -1;

  /**
   * Adds an element to the queue. Returns false if the queue is full.
   * (back == a.length-1) means queue is full, the array has hit its max value // a.length-1
   * @param value - the value to add
   * @return - true if the element was added, false otherwise
   */
  @Override
  public boolean add(E value) {
    if (back == a.length-1)
      return false;
    else
      a[++back] = value;
    back = (back + 1) % a.length;
    return true;
  }

  /**
   * Returns the value at the front of the queue without removing it
   * the front of the queue is always at index zero, we just want to know what this is
   * @return - the value at the front of the queue
   */
  public E peek() {
    if (isEmpty())
      throw new NoSuchElementException("Queue is empty");
    return a[front];
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

  /**
   * if the queue is empty, then front and back are the same
   */
  @Override
  public boolean isEmpty() {
    if (front == back)
      return true;
    return false;
  }

  /**
   * Clears the queue
   * the queue should be empty after this method is executed.
   */
  @Override
  public void clear() {
    back = -1;
  }
}
