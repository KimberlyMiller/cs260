package edu.bluecc.cs260.stacks;

public class Node<E> {

  private E value;  // this is a generic data type variable name
  private Node<E> next;

  public Node(E value) {
    this.value = value;
  }

  public E getValue() {
    return value;
  }

  public Node<E> getNext() {
    return next;
  }

  public void setNext(Node<E> next) {
    this.next = next;
  }
}
