package edu.bluecc.cs260.trees;

public class LinkedBST implements BinarySearchTree<Integer>{

  public static void main(String[] args) {
    // Assume that 'node will always point to something
    //    15
    //   /  \
    //  11  18
    //      / \
    //     17  23
    //    /
    //   16

    LinkedBST tree = new LinkedBST();
    System.out.println("Is empty?: " + tree.isEmpty()); // true
    tree.add(15);
    tree.add(11);
    tree.add(18);
    tree.add(42);
    tree.add(17);
    tree.add(16);
    tree.add(-123);
    for (int i = 0; i < 100; i++)
     tree.add(-123);
    tree.add(23);
    tree.add(23);
    tree.showTree();
//    System.out.println("Is empty?: " + tree.isEmpty()); // false
//    System.out.println(tree.contains(15)); // true
//    System.out.println(tree.contains(11)); // true
//
//    System.out.println(tree.contains(-12345)); // false
//    System.out.println(tree.contains(2)); // false
//    System.out.println(tree.contains(23)); // true
//
//    System.out.println("Contains 15?:  " + tree.contains(15)); // true
//    tree.remove(15);
//    System.out.println("Contains 15?:  " + tree.contains(15)); // false
//
//    tree.remove(16);
  }

  // pointer to the root node
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
    if (root == null)
      root = new TreeNode<>(value);
    else
      add(value, root);
  }

  public void add(Integer value, TreeNode<Integer> node) {
    if (value > node.getValue()) {
      if (node.getRight() == null) {
        node.setRight(new TreeNode<>(value, node)); // This combines these three lines:  // TreeNode<Integer> newNode = new TreeNode<>(value); // node.setRight(newNode); // newNode.setParent(node);
      } else {
        add(value, node.getRight()); // go right
      }
    } else if (value < node.getValue()) {
      if (node.getLeft() == null) {
        node.setLeft(new TreeNode<>(value, node)); // This combines these three lines: // TreeNode<Integer> newNode = new TreeNode<>(value); //node.setLeft(newNode); //newNode.setParent(node);
      } else {
        add(value, node.getLeft());  // go left
      }
    } else {
      // System.out.println("Found duplicate value: " + value);
      // throw new IllegalArgumentException("Dup1icate values not allowed!");
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
    return false;
  }

  /**
   * Returns true if this tree contains the specified element.
   * @param value value whose presence in this tree is to be tested
   * @return true if this list contains the specified value
   */
  public boolean contains(Integer value) {
    return false;
  }

  /**
   * Returns true of this tree contains no values
   *
   * @return true of this tree contains no values
   */
  @Override
  public boolean isEmpty() {
    return false;
  }

  private void showTree() {
    showLVR(root);
    System.out.println();
    showVLR(root);
  }

  // L V R
  private void showLVR(TreeNode<Integer> node) {
    if (node == null)
      return;
    showLVR(node.getLeft()); // L Left
    //System.out.print(node.getValue() + " "); // V Visit
    System.out.printf("%d:%d ",node.getValue(),node.getCount());
    showLVR(node.getRight()); // R Right
  }

  // V L R
  private void showVLR(TreeNode<Integer> node) {
    if (node == null)
      return;
    //System.out.print(node.getValue() + " "); // V Visit
    System.out.printf("%d:%d ",node.getValue(),node.getCount());
    showVLR(node.getLeft()); // L Left
    showVLR(node.getRight()); // R Right
  }
}
