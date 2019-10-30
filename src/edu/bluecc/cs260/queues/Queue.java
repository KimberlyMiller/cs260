package edu.bluecc.cs260.queues;

public interface Queue<E> {

  /**
   * Adds an element to the queue. Returns false if the element cannot be added.
   * @param value - the value to add
   * @return - true if the element was added, false otherwise
   */
  public boolean add(E value);

  /**
   * Removes a value from the front of the queue
   * @return - the removed value
   */
  public E remove();

  /**
   * Retursn the value at the front of the queue without removing it
   * @return - the value at the front of the queue
   */
  public E peek();

  /**
   *
   * @return true if this queue contains no elements
   */
  public boolean isEmpty();

  /**
   * Clears the queue
   */
  public void clear();
}
