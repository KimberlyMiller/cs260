package edu.bluecc.cs260.queues;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

  private E[] a = (E[])(new Object[1000]);
  private int back = -1;

  /**
   * Adds an element to the queue. Returns false if the element cannot be added.
   *
   * @param value - the value to add
   * @return - true if the element was added, false otherwise
   */
  @Override
  public boolean add(E value) {
    if (back == a.length-1) // this means array is full, the array has hit its max value
      return false;
    a[++back] = value; // add the element to the end of the queue. Remember back starts at -1, because we started back as -1, we wll always need to increment it by 1 inorder to be the correct index in the array. We canNOT put a value in a -1 array, it needs to be incremented by 1, so we can put the first value in index 0 of the array.
    return true;
  }

  /**
   * Removes a value from the front of the queue
   *
   * @return - the removed value
   */
  @Override
  public E remove() {
    if (isEmpty()) // this protects us, to check to see if the queue is empty
      throw new NoSuchElementException("Queue is empty");
    E value = a[0]; // stores the front value. The beginng of the queue is always a[0].
    for (int i = 0; i < back; i++) //loops through all the indexes that will be remaining, because we will have one less index in the queue
        a[i] = a[i+1]; // shifts everything back
    back--;
    return value;
  }

  /**
   * Retursn the value at the front of the queue without removing it
   *
   * @return - the value at the front of the queue
   */
  @Override
  public E peek() {
    if (isEmpty()) // this protects us, to check to see if the queue is empty
      throw new NoSuchElementException("Queue is empty");
    return a[0]; // the front of the queue is always at index zero, we just want to know what this is
  }

  /**
   * @return true if this que contains no elements
   */
  @Override
  public boolean isEmpty() {
    return back < 0;
  }

  /**
   * Clears the queue
   */
  @Override
  public void clear() {
    back = -1; // if back is -1, it unhooks everything and everything starts getting overwritten
  }
}
