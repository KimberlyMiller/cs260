package edu.bluecc.cs260.trees;

/**
 * An interface for the operations available on a Binary Search Tree (BST)
 * A BST is a binary tree where each node is less than all the nodes in its right sub-tree
 * and greater than all of the nodes in its left sub-tree.
 *
 * @param <E> the type of elements held in this tree
 * @author Greg Schulberg*
 */
public interface BinarySearchTree<E> {

  /**
   * Add a value to this tree following the BST algorithm
   * Values to the right of a node are greater than the node value
   * Values to the left of a node are less than the node value
   * @param value The value to add
   */
  public void add(E value);

  /**
   * Remove a value from this tree
   * @param value The value to remove
   */
  public boolean remove(E value);

  /**
   * Returns true if this tree contains the specified element.
   * @param value value whose presence in this tree is to be tested
   * @return true if this list contains the specified value
   */
  public boolean contains(E value);

  /**
   * Returns true of this tree contains no values
   * @return true of this tree contains no values
   */
  public boolean isEmpty();

}