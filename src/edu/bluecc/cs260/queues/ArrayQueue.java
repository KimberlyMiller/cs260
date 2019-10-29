package edu.bluecc.cs260.queues;

public class ArrayQueue<E> implements Queue<E> {

  private E[] a = (E[])(new Object[1000]);

  /**
   * Adds an element to the queue. Returns false if the element cannot be added.
   *
   * @param value - the value to add
   * @return - true if the element was added, false otherwise
   */
  @Override
  public boolean add(E value) {
    return false;
  }

  /**
   * Removes a value from the front of the queue
   *
   * @return - the removed value
   */
  @Override
  public E remove() {
    E value = a[0]; // stores the front value
    for (int i = 0; i < back; i++) //loops through all the indexes
        front = front + 1; // shifts everything back
    back--; // decrements the back variable by one
    return value;
  }

  /**
   * Retursn the value at the front of the queue without removing it
   *
   * @return - the value at the front of the queue
   */
  @Override
  public E peek() {
    return null;
  }

  /**
   * @return true if this que contains no elements
   */
  @Override
  public boolean isEmpty() {
    return false;
  }

  /**
   * Clears the queue
   */
  @Override
  public void clear() {

  }
}
