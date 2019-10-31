package edu.bluecc.cs260.lists;

public class ArrayList implements List {

  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    for (int i = 0; i < 1000; i++)
      list.add("Jello");
    System.out.println(list);
  }

  public static void testMain(String[] args) {
   /* ArrayList list = new ArrayList();
    list.add("Gerald");
    list.add("Bob");
    list.add("Joe");
    System.out.println(list.size()); // 3
    System.out.println(list.get(2)); // Joe
    System.out.println(list.get(1)); // Bob
    System.out.println(list.get(0)); /// Gerald
    list.remove(1);
    System.out.println(list.size()); // 2
    System.out.println(list.get(1)); // Joe
    System.out.println(list.get(0)); // Gerald
    list.remove(0);
    System.out.println(list.size()); // 1
    System.out.println(list.get(0)); // Joe
    list.remove(0);
    //System.out.println(list.size()); // 0  - zero is an invalid index so it will throw an invalid index message
    System.out.println(list);
    */
  }

  private String[] a = new String[1000];
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
    if (index < 0 || index > end)    // this checks to see if this index is out of bounds
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
        return 1;
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
      return false; // false if we can't actually add it
    a[++end] = val;  // ++end CHANGES the number of end
    System.out.println("Added at position " + end);
    return true;
    // EXTRA CREDIT
    // When the array is 20% full, add 20% to its size (resize after you add something,
    // check to see if the array is 20 percent full. never use a static number.
    // You have to make copies of the array to do this.
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
    // TODO write this
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
    // TODO first find its index and then remove it at the index. use the find
    // method to find the first position.
    // then call the remove method.
    // so return true if you removed it
    // check to see if it is in the list.
    return false;  // if it is not in the list
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
    // insert for assignment String s = "";
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
   * @param
   * @return return the size of the list
   */
  @Override
  public int size() {
    // TODO write this // end + 1 does NOT change the number of end
    return end + 1;
  }

  /**
   * This method checks to see if the list is empty
   * This was not in the Abstract List of Operations
   *
   * @param
   * @return Return true if the list is empty, false if it's not
   */
  @Override
  public boolean isEmpty() {
    // TODO write this
    return false;
  }

  /**
   * This method checks to see if value is in the list
   * This was not in the Abstract List of Operations
   *
   * @param
   * @return Return true if the value is in the list, false if it's not
   */
  @Override
  public boolean contains(String value) {
    // TODO write this
    return false;
  }

  /**
   * This method checks to see if value is in the list
   * Implements DELETE_ALL()
   *
   * @param
   * @return Return true if the value is in the list, false if it's not
   */
  @Override
  public void clear() {
    // TODO write this
  }

  /**
   * This method overrides the default toString method and return comma separated element in the list.
   * This was not in the Abstract List of Operations
   *
   * @param
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