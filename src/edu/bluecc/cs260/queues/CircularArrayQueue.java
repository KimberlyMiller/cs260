package edu.bluecc.cs260.queues;

import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements Queue<E> {

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
   * Removes a value from the front of the queue
   * @return - the removed value
   */
  @Override
  public E remove() {
    if (isEmpty())
      throw new NoSuchElementException("Queue is empty");
    E value = a[front];
    for (int i = front; i < back; i++) //loops through all the indexes that will be remaining, because we will have one less index in the queue
      a[i] = a[i+1]; // shifts everything back
    back--;
    return value;
  }

  /**
   * The front of the queue is always at index zero, we just want to know what this is.
   * Returns the value at the front of the queue without removing it
   * @return - the value at the front of the queue
   */
  public E peek() {
    if (isEmpty())
      throw new NoSuchElementException("Queue is empty");
    return a[front];
  }

  /**
   * if the queue is empty, then front and back are the same
   * Returns true if this list contains no elements.
   * @return true if this list contains no elements
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
