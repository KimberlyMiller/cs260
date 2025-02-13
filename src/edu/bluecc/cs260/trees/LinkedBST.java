/* ************************************************************
LinkedBST.java
Created by Kim Miller on 31 December 2019
CS260 Fall 2019

Description: This program creates a Binary Search Tree using a linked data structure, and only accepts Integers.

Client: LinkedBST.java
Interface: BinarySearchTree<Integer>.java

% java LinkedBST

//Sample Output:
Is empty?: true
1956725890(V:11 P:356573597 L:null R:null)
356573597(V:15 P:null L:1956725890 R:1735600054)
21685669(V:16 P:2133927002 L:null R:null)
2133927002(V:17 P:1735600054 L:21685669 R:null)
1735600054(V:18 P:356573597 L:2133927002 R:1836019240)
1836019240(V:23 P:1735600054 L:null R:null)
Is empty?: false
************************************************************ */

package edu.bluecc.cs260.trees;

public class LinkedBST implements BinarySearchTree<Integer>{

  public static void main(String[] args) {
    LinkedBST tree = new LinkedBST();
    System.out.println("Is empty?: " + tree.isEmpty()); // true
    tree.add(15);
    tree.add(11);
    tree.add(18);
    tree.add(17);
    tree.add(23);
    tree.add(16);

    tree.showTree();
    System.out.println("Is empty?: " + tree.isEmpty()); // false

    tree.remove(15);  // Example of removing the root
    tree.remove(16);  // Example of removing a leaf
    tree.remove(18);  // Example of removing an internal node
    System.out.println();
    tree.showTree();
  }

  private TreeNode<Integer> root;

  /**
   * Add a value to this tree following the BST algorithm
   * Values to the right of a node are greater than the node value
   * Values to the left of a node are less than the node value
   *
   * @param value The value to add
   */
  @Override
  public void add(Integer value) {
    //check if this is the
    if (root == null)
      root = new TreeNode<>(value);
    else
      add(value, root);
  }

  /**
   * @param value The value to add,
   * @param node TreeNode to add
   */
  public void add(Integer value, TreeNode<Integer> node) {
    if (value > node.getValue()) {
      if (node.getRight() == null)
        node.setRight(new TreeNode<>(value, node));
       else
        add(value, node.getRight());
    } else if (value < node.getValue()) {
      if (node.getLeft() == null)
        node.setLeft(new TreeNode<>(value, node));
      else
        add(value, node.getLeft());
    } else {
      node.incrementCount();
    }
  }

  /**
   * Remove a value from this tree
   *
   * @param value The value to remove
   */
  @Override
  public boolean remove(Integer value) {
    TreeNode<Integer> node = find(value, root);

    if (node == null)
      return false;

    if (node.getLeft() == null && node.getRight() == null) {
      replace(node, null);

    } else if (node.getLeft() == null && node.getRight() != null) {
      replace(node, node.getRight());
    } else if (node.getLeft() != null && node.getRight() == null) {
      replace (node, node.getLeft());
    } else {
      TreeNode<Integer> min = node.getRight();
      while (min.getLeft() != null)
        min = min.getLeft();
      min.setLeft(node.getLeft());
      node.getLeft().setParent(min);
      replace(node, node.getRight());
    }
    return true;
  }

  /**
   * This will replace the node with another while keeping the link chained
   * @param node1 TreeNode<Integer>
   * @param node2 TreeNode<Integer>
   */
  private void replace(TreeNode<Integer> node1, TreeNode<Integer> node2) {
    TreeNode<Integer> parent = node1.getParent();
    if (parent == null)
      root = node2;
    else if (node1.getValue() > parent.getValue()) {
      parent.setRight(node2);
    } else {
      parent.setLeft(node2);
    }
    if (node2 != null)
      node2.setParent(parent);
  }

  /**
   * Returns true if this tree contains the specified element.
   * @param value value whose presence in this tree is to be tested
   * @return true if this list contains the specified value
   */
  public boolean contains(Integer value) {
    return find(value, root).getValue() == value;  //  return find(value, root) != null;
  }

  private TreeNode<Integer> find(Integer value, TreeNode<Integer> node)  {
    if (node == null)
      return null;
    if (value > node.getValue())
      return find(value, node.getRight());
    else if (value < node.getValue())
      return find(value, node.getLeft());
    return node;
  }

  /**
   * Returns true of this tree contains no values
   *
   * @return true of this tree contains no values
   */
  @Override
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * Shows the different types of tree traversals by calling the corresponding Traversal Methods:
   * showLVR()  and showVLR()
   */
  private void showTree() {
    showLVR(root);
   // System.out.println();
   // showVLR(root);
  }

  /**
   * L V R
   * Left Visit Right
   * This prints the LVR traversal of the Binary Search Tree
   * @param node TreeNode<Integer> object
   */
  private void showLVR(TreeNode<Integer> node) {
    if (node == null)
      return;
    showLVR(node.getLeft());
    System.out.printf("%s(V:%d P:%s L:%s R:%s)\n", getLocation(node), node.getValue(),getLocation(node.getParent()), getLocation(node.getLeft()), getLocation(node.getRight()));
    showLVR(node.getRight());
  }

  /**
   * V L R
   * Visit Left Right
   * This prints the VLR traversal of the Binary Search Tree
   * @param node TreeNode<Integer> object
   */
  private void showVLR(TreeNode<Integer> node) {
    if (node == null)
      return;
    System.out.printf("%s(V:%d P:%s L:%s R:%s)\n", getLocation(node), node.getValue(),getLocation(node.getParent()), getLocation(node.getLeft()), getLocation(node.getRight()));
    showVLR(node.getLeft());
    showVLR(node.getRight());
  }

  /**
   *
   * @param node TreeNode<Integer> object
   * @return the location of the node by it's corresponding hashcode integer, rather than a specific memory location address.
   */
  private String getLocation(TreeNode<Integer> node) {
    return node == null ? "null" : node.hashCode() + "";
  }
}
