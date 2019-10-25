package edu.bluecc.cs260.lists;
// make a note in the header of each method of which
// ABT abstract data type it is using,
// also make a note of java doc comment at the top, what it takes as
// input and output - java doc comments nave /** at begining
// because it is read by the java doc interpeted

// public class ArrayList implements lists {  // this will add methods
public class ArrayList {

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

/// reuse methods to help other methods.
//  Don't rewrite the same code twice!

  /**
   *
   * Appends the specified element to the end of the list
   *
   * implements APPEND(v) in ADT LIST
   * @param value value to be appended to this list
   */
  public boolean add(String value) {
    if (a.length == end + 1)
      return false; // false if we can't actually add it
    a[++end] = value;  // ++end CHANGES the number of end
    System.out.println("Added at position " + end);
    return true;
    // EXTRA CREDIT
    // When the array is 20% full, add 20% to its size (resize after you add something,
    // check to see if the array is 20 percent full. never use a static number.
    // You have to make copies of the array to do this.
  }

  /**
   *
   * Retrieve a value from the list at a given index
   * implements RETRIEVE(p) -> v (value) in ADT LIST
   *
   * @param index the index in the list; 0 is first index
   * @return the value at the given index
   */
  public String get(int index) {
    if (index < 0 || index > end)    // this checks to see if this index is out of bounds
      throw new IndexOutOfBoundsException(index + " is an invalid index");
    return a[index];
  }

  // LENGTH() ->
  public int size() {
    return end + 1;
  }

  /** search for value in the list
   * return the index when it is first found, or -1 if not in the list
   * @param value value to search for
   * @return index or -1 if not found
   */
  // LOCATE(v) -> p   looks for a value, and returns a position index value that is in the array
  public int find(String value) {
    for (int i = 0; i <= end; i++) {
      if (a[i].equals(value))
        return 1;
    }
    return -1;
  }

  /**
   * Implements the DELETE(v) operation of ADT LIST
   * Removes the first occurrence of the given value from the list, if it exists
   *
   * @param value the values to be removed
   * @return true the value was removed, false if wasn't found in the list
   */
  public boolean remove(String value) {
    // TODO first find its index and then remove it at the index. use the find
    // method to find the first position.
    // then call the remove method.
    // so return true if you removed it
    // check to see if it is in the list.
    return false;  // if it is not in the list
  }

  // DELETE (v) =>p
  // This will just move everything over one left, until you get to the index to be overritten.
  // return the value that's removed; throw an IndexOutOfBoundsException if the index is invalid
  // For the assignement this is going to need to return a string
  // so create a temp s method that it can then return.
  public void remove(int index) {
    // insert for assignment String s = "";
    if (index > end || index < 0)
      throw new IndexOutOfBoundsException(index + " is an invalid index");
    String value = a[index];
    for (int i = index; i < end; i++)
      a[i] = a[i+1];
    end--;
  }

  // we didn't list this as an abstract operation; try it anyway
  // Return true if the list is empty, false if it's not
  // public boolean isEmpty();
  // DELETE_ALL()
  // public void clear();

  // INSERT(p,v)
  // Throw an IndexOutOfBoundsException if the index is invalid
  //public void add(int index, String val);

  // TO_STRING
// override default and return comma separated element in the list.
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
