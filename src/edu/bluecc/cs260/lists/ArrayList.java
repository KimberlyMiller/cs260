package edu.bluecc.cs260.lists;

public class ArrayList {

  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("Gerald");
    list.add("Bob");
    list.add("Joe");
    System.out.println(list);
  }

  public static void testMain(String[] args) {
    ArrayList list = new ArrayList();
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
  }

  private String[] a = new String[1000];
  private int end = -1;

  // No overrideen constructor needed


  // APPEND (v)
  public void add(String value) {
    // ++end CHANGES the number of end
    a[++end] = value;
  }

  // Retrieve (p) - > v
  public String get(int index) {
    if (index > end || index < 0)
      throw new IndexOutOfBoundsException(index + " is an invalid index");
    return a[index];
  }

  // LENGTH() ->
  public int size() {
    // end + 1 does NOT change the number of end
    return end + 1;
  }

  /** search for value in the list
   * return the index when it is first found, or -1 if not in the list
   * @param value value to search for
   * @return index or -1 if not found
   */
  // LOCATE(v) -> p
  public int find(String value) {
    // Linear search...
    for (int i = 0; i <= end; i++) {
      if (a[i].equals(value))
        return 1;
    }
    return -1;
  }

  // INSERT(p,v)
  // Throw an IndexOutOfBoundsException if the index is invalid
  //public void add(int index, String val);

  // DELETE (v) =>p
  // This will just move everything over one left, until you get to the index to be overritten.
  // return the value that's removed; throw an IndexOutOfBoundsException if the index is invalid
  public void remove(int index) {
    if (index > end || index < 0)
      throw new IndexOutOfBoundsException(index + " is an invalid index");
    for (int i = index; i < end; i++)
      a[i] = a[i+1];
    end--;
  }

  // we didn't list this as an abstract operation; try it anyway
  // Return true if the list is empty, false if it's not
  // public boolean isEmpty();

  // DELETE_ALL()
  // public void clear();


  // TO_STRING
  // override default and return comma separated element in the list.
  public String toString() {
    String s = "";
    if (end <0)  // this checks before the loops to check for anything in the array
      return s;
    for (int i = 0; i < end; i++) {
        s = s + a[i] + ", ";
    }
    return s + a[end];
  }
}
