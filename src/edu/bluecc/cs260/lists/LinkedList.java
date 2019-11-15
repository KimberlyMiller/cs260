package edu.bluecc.cs260.lists;

import org.w3c.dom.ls.LSOutput;

public class LinkedList implements List {



  private Node first;
  private Node last;
  private int size = 0;

  /**
   * Retrieve a value from the list at a given index
   * Throw an IndexOutOfBoundsException if the index is invalid
   * implements RETRIEVE(p) -> v in ADT LIST
   *
   * @param index the index in the list; 0 is first index
   * @return the value at the given index location
   */
  public String get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException(index + " is an invalid index");
    Node temp =  first;
    for (int i = 0; i < index; i++)
      temp = temp.getNext();
    return temp.getValue();
  }

  /**
  * Return the first index in the list with the given value, or -1 if it's not found
  * Implements the LOCATE(v) -> p in ADT LIST
  *
  * @param value
  * @return the index where it was found, or -1 if not in the list
  */
  public int find(String value){
    for (int i = 0; i <= size; i++) {
      if (get(i).equals(value))
        return i;
      else
      return -1;
    }
    return -1;
  }

  /**
  * Appends the specified element to the end of the list
  * implements APPEND(v) in ADT LIST
  *
  * @param value value to be appended to this list
  * @return true if the element is successfully added, false if the list is full
  */
  public boolean add(String value) {
    // create new node
    Node node = new Node(value);
    if (first == null)
      first =  node;
    else {
      last.setNext(node);
    }
    last =  node;
    size++;
    return true;
  }

  /**
  * Throw an IndexOutOfBoundsException if the index is invalid
  * Implements INSERT(p,v)
  *
  * @param index and val
  * @return
  */
  @Override
  public void add(int index, String val) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException(index + " is an invalid index");
    Node newNode = new Node(val);
    Node node = first;
    Node oldFirst = first;
    if (index == 0) { // this doesn't work but at least the first one is what is inserted at zero
      first = newNode;
      first.setNext(oldFirst);
    }
     else if (index == 1)
      index = index - 2;

     else
      index = index - 1;

    for (int i = 0; i < index; i++) {
        node = node.getNext();
     }

    newNode.setNext(node.getNext());
    node.setNext(newNode);

    size++;
  }
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("Sun");
    list.add("Sky");
    list.add(0,"blue");
    System.out.println(list);
  }
  /**
  * Removes the first occurrence of the given value from the list, if it exists
  * Implements the DELETE(v) operation of ADT LIST
  *
  * @param value the values to be removed
  * @return true the value was removed, false if wasn't found in the list
  */
  public boolean remove(String value) {
  Node prev = null;
  Node node = first;
  while (node != null) {
    if (node.getValue().equals(value)) {
      prev.setNext(node.getNext());
      if (prev == null) {
        first = first.getNext();
      } else {
        prev.setNext(node.getNext());
      }
    return true;
    }
    prev = node;
    node = node.getNext();
    }
    return false;  // if it is not in the list
  }

  /**
  * return the value that's removed; throw an IndexOutOfBoundsException if the index is invalid
  * Implements DELETE(p)
  *
  * @param index
  * @return return the value that's removed;
  */
  @Override
  public String remove(int index) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException(index + " is an invalid index");
    Node newNode = new Node("");
    Node node = first; // temporary
    int count = 0;

    for (int i = 0; i < index-2; i++) {
      node = node.getNext();
      count++;
    }
    newNode.setNext(node.getNext());
    node.setNext(newNode);
    size--;
    return node.getValue();
  }

  /**
  * This method gets the value of the end variable -1 to indicate the list size
  * Implements LENGTH() → int
  *
  * @return return the size of the list
  */
  @Override
  public int size() {
    return size;
  }

  /**
  * This method checks to see if the list is empty
  * This was not in the Abstract List of Operations
  *
  * @return true if the list is empty, false if it's not
  */
  @Override
  public boolean isEmpty() {
    if (size() <= 0)
      return true;
    return false;
  }

  /**
  * This method checks to see if value is in the list
  * This was not in the Abstract List of Operations
  *
  * @param value
  * @return true if the value is in the list, false if it's not
  */
  @Override
  public boolean contains(String value) {
    int index = find(value);
    if (index != -1) {
      return true;
    }
    return false;
  }

  /**
  * This method removes everything from the list
  * Implements DELETE_ALL()
  */
  @Override
  public void clear() {
    size = -1;
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
    Node i = null;
    for (Node x = first; x != null; x = x.getNext())
     s += x.getValue() + ", ";
    return s;
  }
}
