package edu.bluecc.cs260.queues;


import edu.bluecc.cs260.stacks.Node;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E>  {

  public static void main(String[]args){
    System.out.println("test");
  }

  private Node<E> first;
  private Node<E> last;
  private int front = 0;
  private int end = -1;
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
    end++;
    return true;
  }

  /**
   * Removes a value from the front of the queue
   * @return - the removed value
   */
  public E remove() {
    Node<E> prev = null;
    Node<E> node = first;
    while (node != null) {
        prev.setNext(node.getNext());
        if (prev == null) {
          first = first.getNext();
        } else {
          prev.setNext(node.getNext());
        }

      prev = node;
      node = node.getNext();
    }
    end--;
    return node.getValue();
  }

  /**
   * Retursn the value at the front of the queue without removing it
   * @return - the value at the front of the queue
   */
  public E peek() {
    Node<E> end = last;
    if (isEmpty())
      throw new NoSuchElementException("Queue is empty");
    return end.getValue();
  }

  /**
   * Returns true if this list contains no elements.
   * @return true if this list contains no elements
   */
  public boolean isEmpty() {
    if (front == end)
      return true;
    return false;
  }

  /**
   * Clears the queue
   */
  public void clear() {
    end = -1;
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
