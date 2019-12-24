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
    tree.add(17);
    tree.add(23);
    tree.add(16);
//    System.out.println(tree.contains(11)); // true
//    System.out.println(tree.contains(17)); // false
//    System.out.println();
    tree.showTree();
    System.out.println("Is empty?: " + tree.isEmpty()); // false

    tree.remove(15);  // Example of removing the root
    tree.remove(16);  // Example of removing a leaf
    tree.remove(18);  // Example of removing an internal node
    System.out.println();
    tree.showTree();

//    tree.add(23);
//    tree.add(42);
//    tree.add(17);
//    tree.add(16);
//    tree.add(-123);
//    for (int i = 0; i < 100; i++)
//     tree.add(-123);
//    tree.add(23);
//    tree.add(42);
//    tree.add(15);
//    tree.add(15);
//    tree.showTree();
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
    //check if this is the
    if (root == null)
      root = new TreeNode<>(value);
    else
      add(value, root);
  }

  public void add(Integer value, TreeNode<Integer> node) {
    if (value > node.getValue()) {
      if (node.getRight() == null)
        node.setRight(new TreeNode<>(value, node)); // This combines these three lines:  // TreeNode<Integer> newNode = new TreeNode<>(value); // node.setRight(newNode); // newNode.setParent(node);
       else
        add(value, node.getRight()); // go right
    } else if (value < node.getValue()) {
      if (node.getLeft() == null)
        node.setLeft(new TreeNode<>(value, node)); // This combines these three lines: // TreeNode<Integer> newNode = new TreeNode<>(value); //node.setLeft(newNode); //newNode.setParent(node);
      else
        add(value, node.getLeft());  // go left
    } else {
      node.incrementCount(); // System.out.println("Found duplicate value: " + value); // throw new IllegalArgumentException("Dup1icate values not allowed!");
    }
  }

  /**
   * Remove a value from this tree
   *
   * @param value The value to remove
   */
  @Override
  public boolean remove(Integer value) {
    // Get a TreeNode pointer to the value in the tree
    TreeNode<Integer> node = find(value, root); // might be null!  // <--- this node blows up the program because a boolean cannot be converted to an Integer. That happened when the find() method's return value was boolean. Once the find() method returned a TreeNode object, the problem was resolved because the two data types then matched.

    if (node == null)
      return false; // throw new RuntimeException("Value not found in the tree: " + value);
    // 3 possibilities

    // 1. No children
    if (node.getLeft() == null && node.getRight() == null) {
      replace(node, null);

    // 2. One child (two possibilities: one child to L or R)
    } else if (node.getLeft() == null && node.getRight() != null) {
      replace(node, node.getRight());
    } else if (node.getLeft() != null && node.getRight() == null) {
      replace (node, node.getLeft());
    } else {
      // 3. Two children
      // find min. of R subtree
      TreeNode<Integer> min = node.getRight();
      while (min.getLeft() != null)
        min = min.getLeft();
      min.setLeft(node.getLeft());
      // there's nothing to left of node
      node.getLeft().setParent(min);
      replace(node, node.getRight());
    }
    return true;
  }

  //
  //  45 <-- node1
  //  /
  //  24 <-- node2

  private void replace(TreeNode<Integer> node1, TreeNode<Integer> node2) {
    TreeNode<Integer> parent = node1.getParent();
    if (parent == null)
      root = node2;
    else if (node1.getValue() > parent.getValue()) {
      parent.setRight(node2);
    } else {
      parent.setLeft(node2);
    }
    // change parent of node2
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

//  public boolean contains(Integer value) {
//    return find(value, root);  //  return find(value, root) != null;
//  }
  //  searching for 17
  //    15
  //   /  \
 //   12   18
  //      null < -- node
//  private boolean find(Integer value, TreeNode<Integer> node)  {
//    if (node == null)
//      return false;
//    if (value > node.getValue())
//      return find(value, node.getRight());
//    else if (value < node.getValue())
//      return find(value, node.getLeft());
//    return true;
//  }

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

  private void showTree() {
    showLVR(root);
   // System.out.println();
   // showVLR(root);
  }

  // L V R
  private void showLVR(TreeNode<Integer> node) {
    if (node == null)
      return;
    showLVR(node.getLeft()); // L Left
    // trace: System.out.printf("%d:%d ",node.getValue(),node.getCount()); // V Visit  //System.out.print(node.getValue() + " "); // V Visit
    System.out.printf("%s(V:%d P:%s L:%s R:%s)\n", getLocation(node), node.getValue(),getLocation(node.getParent()), getLocation(node.getLeft()), getLocation(node.getRight()));
    showLVR(node.getRight()); // R Right
  }

  // V L R
  private void showVLR(TreeNode<Integer> node) {
    if (node == null)
      return;
    // trace: System.out.printf("%d:%d ",node.getValue(),node.getCount()); // V Visit  //System.out.print(node.getValue() + " "); // V Visit
    System.out.printf("%s(V:%d P:%s L:%s R:%s)\n", getLocation(node), node.getValue(),getLocation(node.getParent()), getLocation(node.getLeft()), getLocation(node.getRight()));
    showVLR(node.getLeft()); // L Left
    showVLR(node.getRight()); // R Right
  }

  private String getLocation(TreeNode<Integer> node) {
    return node == null ? "null" : node.hashCode() + "";
  }
}
