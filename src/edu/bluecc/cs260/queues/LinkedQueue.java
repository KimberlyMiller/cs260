package edu.bluecc.cs260.queues;

import edu.bluecc.cs260.stacks.Node;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E>  {

  public static void main(String[]args){
    System.out.println("test");
  }

  private Node<E> first;
  private Node<E> last;

  /**
   * Adds an element to the queue. Returns false if the element cannot be added.
   * @param value - the value to add
   * @return - true if the element was added, false otherwise
   */
  public boolean add(E value) {
    Node<E> node = new Node(value);
    if (first == null)
      first =  node;
    else {
      last.setNext(node);
    }
    last =  node;

    return true;
  }

  /**
   * Removes a value from the front of the queue
   * @return - the removed value
   */
  public E remove() {
    if (isEmpty())
      throw new NoSuchElementException("Queue is empty");

    E value = first.getValue();
    first = first.getNext();
    return value;
  }

  /**
   * Retursn the value at the front of the queue without removing it
   * @return - the value at the front of the queue
   */
  public E peek() {
    if (isEmpty())
      throw new NoSuchElementException("Queue is empty");

    return first.getValue();
  }

  /**
   * Returns true if this list contains no elements.
   * @return true if this list contains no elements
   */
  public boolean isEmpty() {
    if (first != null)
      return false;
    return true;
  }

  /**
   * Clears the queue
   */
  public void clear() {
    first = null;
  }

  /**
   * Convert the contents into a single string with values separated by commas.
   * It's OK to have a comma at the end of the String.
   * This was not in the Abstract List of Operations
   *
   * @return comma separated element in the list
   */
  @Override
  public String toString() {
    String s = "";
    edu.bluecc.cs260.lists.Node i = null;
    for (Node<E> x = first; x != null; x = x.getNext())
      s += x.getValue() + ", ";
    return s;
  }
}