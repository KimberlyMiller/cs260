package edu.bluecc.cs260.trees;

public interface BinarySearchTree<E> {

  public void add(E value);

  public void remove(E value);

  public boolean contains(E value);

  public boolean isEmpty();
}
