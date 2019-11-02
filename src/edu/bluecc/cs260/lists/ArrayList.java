package edu.bluecc.cs260.lists;

import java.util.Arrays;

// Includes the re-sizing of the array

public class ArrayList implements List {

  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    // testMain1(list);
       testMain2(list);

//    // test array resizing:
//    for (int i = 0; i < 500; i++)
//      list.add("Jello");
//    System.out.println(list);
  }

  public static void testMain1(List list) {
    list.add("Gerald");
    list.add("Bob");
    list.add("Joe");
    list.add(1,"Jerry");
    list.remove("Joee");
    System.out.println("Find it? " + list.contains("Joe"));
    System.out.println("Find it? " + list.contains("Bob"));
    System.out.println("Find it? " + list.contains("Tasha"));
    System.out.println("Empty? " + list.isEmpty());
    System.out.println("List size: " + list.size());
    System.out.println(list);
    list.clear();
    System.out.println("List size: " + list.size());
    System.out.println("Empty? " + list.isEmpty());
  }

  public static void testMain2(List list) {
    list.add("Gerald");
    list.add("Bob");
    list.add("Joe");
    System.out.println(list);
    for (int i = 0; i < 2; i++)
      list.add("Jello");
    list.add(1,"Pudding"); // INSERT at index 1
    System.out.println(list);
    list.add(0,"Popsicle"); // INSERT at index 0; the beginning
    System.out.println(list);
  }

  private String[] a = new String[100];
  private int end = -1;

  /**
   * Retrieve a value from the list at a given index
   * Implements RETRIEVE(p) → v
   *
   * @param index
   * @return the element at the given index
   */
  @Override
  public String get(int index) {
    if (index < 0 || index > end)
      throw new IndexOutOfBoundsException(index + " is an invalid index");
    return a[index];
  }

  /**
   * Search for value in the list
   * Implements LOCATE(v) → p
   *
   * @param val
   * @return the first index in the list with the given value, or -1 if it's not found
   */
  @Override
  public int find(String val) {
    for (int i = 0; i <= end; i++) {
      if (a[i].equals(val))
        return i;
    }
    return -1;
  }

  /**
   * Appends the specified element to the end of the list
   * Implements APPEND(v)
   *
   * @param val
   * @return true if the element is successfully added, false if the list is full
   */
  @Override
  public boolean add(String val) {
    if (a.length == end + 1)
      return false;
    a[++end] = val;
    if (end > 0.2*a.length)   // Re-sizing of the array
      a = Arrays.copyOf(a,(int)(1.5*a.length));
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
    if (end >= a.length)
      throw new IndexOutOfBoundsException(index + " is an invalid index");

    for (int i = end+1; i > index; i--) {
      a[i] = a[i-1];
    }
    a[index] = val;
    end++;
  }

  /**
   * Removes the first occurrence of the given value from the list, if it exists
   * Implements DELETE(v)
   *
   * @param val
   * @return true the value was removed, false if wasn't found in the list
   */
  @Override
  public boolean remove(String val) {
    int index = find(val);
    if (index != -1) {
      remove(index);
      return true;
    }
    return false;
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
    if (index > end || index < 0)
      throw new IndexOutOfBoundsException(index + " is an invalid index");
    String value = a[index];
    for (int i = index; i < end; i++)
      a[i] = a[i+1];
    end--;
    return value;
  }

  /**
   * This method gets the value of the end variable -1 to indicate the list size
   * Implements LENGTH() → int
   *
   * @return return the size of the list
   */
  @Override
  public int size() {
    return end + 1;
  }

  /**
   * This method checks to see if the list is empty
   * This was not in the Abstract List of Operations
   *
   * @return Return true if the list is empty, false if it's not
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
   * @return Return true if the value is in the list, false if it's not
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
    end = -1;
  }

  /**
   * This method overrides the default toString method and return comma separated element in the list.
   * This was not in the Abstract List of Operations
   *
   * @return comma separated element in the list
   */
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    if (end < 0)
      return "";
    for (int i = 0; i < end; i++) {
      s.append(a[i]).append(",");
    }
    return s.append(a[end]).toString();
  }
}