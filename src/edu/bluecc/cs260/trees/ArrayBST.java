package edu.bluecc.cs260.trees;

/**
 * Array implementation of the BinarySearchTree interface. This tree only accepts integers.
 *
 * @author Greg Schulberg
 */
public class ArrayBST implements BinarySearchTree<Integer> {

  public static void main(String[] args) {
    ArrayBST tree = new ArrayBST();
    System.out.println("Is empty?: " + tree.isEmpty()); // true
    tree.add(7);
    tree.add(12);
    tree.add(6);
    tree.add(-42);
    tree.add(15);
    System.out.println("Is empty?: " + tree.isEmpty()); // false
    System.out.println(tree.contains(7)); // true
    System.out.println(tree.contains(12)); // true

    System.out.println(tree.contains(-12345)); // false
    System.out.println(tree.contains(11)); // false
    System.out.println(tree.contains(-42)); // true

    System.out.println("Contains 15?:  " + tree.contains(15)); // true
    tree.remove(15);
    System.out.println("Contains 15?:  " + tree.contains(15)); // false

    System.out.println("Contains 12?:  " + tree.contains(15)); // true
    tree.remove(12);
    System.out.println("Contains 12?:  " + tree.contains(15)); // false

    System.out.println("Contains 7?:  " + tree.contains(15)); // true
    tree.remove(7);
    System.out.println("Contains 7?:  " + tree.contains(15)); // false

    tree.remove(150);
  }

  private Integer[] a = new Integer[100];
  private int root = 0;

  /**
   * Add a value to this tree following the BST algorithm
   * Values to the right of a node are greater than the node value
   * Values to the left of a node are less than the node value
   *
   * @param value The value to add
   */
  @Override
  public void add(Integer value) {
    add(value, 0);
  }

  private void add(int value, int location) {
    if (a[location] == null) {
      a[location] = value;
      root = value;
    } else if (value > a[location])
      add(value, 2 * location + 2); // go right
    else if (value < a[location])
      add(value, 2 * location + 1); // go left
  }

  //This operation is not supported and will throw an UnsupportedOperationException
   /**
   * Remove a value to this tree following the BST algorithm
   * Values to the right of a node are greater than the node value
   * Values to the left of a node are less than the node value
   *
   * @param value The value to be removed
   */
  public boolean remove(Integer value) {
    if (contains(value) == false)
      throw new UnsupportedOperationException("This operation is not allowed");
   else {
      remove(value, 0);
      return true;
    }
  }

  public boolean remove(int value, int location) {
    System.out.println("a: " + a[location]); // trace
    System.out.println("root: " + root); // trace



    if (value == a[location] && root == value) {
      System.out.println("This is it!! " + a[location]);  // trace
      a[location] = a[location*2+1];
      return true;
    }

     if (value > a[location]) {
      remove(value, location*2+2); // go right
    } else if (value < a[location]) {
      remove(value, location*2+1); // go left
    }
    return false;
  }

  /**
   * Returns true if this tree contains the specified element.
   * @param value value whose presence in this tree is to be tested
   * @return true if this list contains the specified value
   */
  @Override
  public boolean contains(Integer value) {
    return find(value, 0);
  }

  private boolean find(int value, int location) {
    if (a[location] == null)
      return false;
    if (value == a[location])
      return true;
    if (value > a[location])
      return find(value, location*2+2);
    else
      return find(value, location*2+1);
  }

  /**
   * Returns true of this tree contains no values
   * @return true of this tree contains no values
   */
  @Override
  public boolean isEmpty() {
    return a[0] == null;
  }

  /**
   * Build a String representation of this tree as values inside the underlying array. Empty spots in the array
   * will be "null". Separate values by spaces
   * @return A String representation of the underlying array
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Integer value : a)
      sb.append(value).append(" ");
    return sb.toString();
  }
}