package edu.bluecc.cs260.trees;

public class TreeNode<E> {

  private E value;
  private TreeNode<E> parent;
  private TreeNode<E> left;
  private TreeNode<E> right;
  private int count = 1;

  public TreeNode(E value) {
    this.value = value;
  }

  public TreeNode(E value, TreeNode<E> parent) {
    this.value = value;
    this.parent = parent;
  }

  public void setParent(TreeNode<E> parent) {
    this.parent = parent;
  }

  public void setLeft(TreeNode<E> left) {
    this.left = left;
  }

  public void setRight(TreeNode<E> right) {
    this.right = right;
  }

  public void incrementCount() {
    count++;
  }

  public E getValue() {
    return value;
  }

  public TreeNode<E>  getParent() {
    return parent;
  }

  public TreeNode<E>  getLeft() {
    return left;
  }

  public TreeNode<E>  getRight() {
    return right;
  }

  public int getCount() {
    return count;
  }
}
