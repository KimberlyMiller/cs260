package edu.bluecc.cs260.lists;

/**
 * This class implements the list interface
 * Keeps the elements sorted as they are added to the list. The list is always sorted.
 *
 */


public class SortedDoubleLinedList implements List {

  /**
   * Implements RETRIEVE(p) → v
   * Gets the element at the given index
   *
   * @param index
   * @return the element at the given index
   */
  @Override
  public String get(int index) {
    return null;
  }

  /**
   * Implements LOCATE(v) → p
   * Return the first index in the list with the given value, or -1 if it's not found
   *
   * @param val
   * @return
   */
  @Override
  public int find(String val) {
    return 0;
  }

  /**
   * Inserts the element in the sorted order
   * @param val
   * @return
   */
  @Override
  public boolean add(String val) {
    return false;
  }

  /**
   * Unsuported operation
   * This is an Unspuported operation because it would not make sense to use it.
   * @param index
   * @param val
   */
  @Override
  public void add(int index, String val) {
    throw new UnsupportedOperationException("Cannot insert into a sorted list");
  }

  @Override
  public boolean remove(String val) {
    return false;
  }

  @Override
  public String remove(int index) {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean contains(String value) {
    return false;
  }

  @Override
  public void clear() {

  }
}
