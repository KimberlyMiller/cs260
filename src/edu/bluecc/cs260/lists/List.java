package edu.bluecc.cs260.lists;

public interface List {

  /**
   * Retrieve a value from the list at a given index
   * Implements RETRIEVE(p) → v
   *
   * @param index
   * @return the element at the given index
   */
  public String get(int index); // Throw an IndexOutOfBoundsException if the index is invalid

  /**
   * Search for value in the list
   * Implements LOCATE(v) → p
   *
   * @param val
   * @return the first index in the list with the given value, or -1 if it's not found
   */
  public int find(String val);

  /**
   * Appends the specified element to the end of the list
   * Implements APPEND(v)
   *
   * @param val
   * @return true if the element is successfully added, false if the list is full
   */
  public boolean add(String val);

  /**
   * Throw an IndexOutOfBoundsException if the index is invalid
   * Implements INSERT(p,v)
   *
   * @param index and val
   * @return
   */
  public void add(int index, String val);

  /**
   * Removes the first occurrence of the given value from the list, if it exists
   * Implements DELETE(v)
   *
   * @param val
   * @return true the value was removed, false if wasn't found in the list
   */
  public boolean remove(String val);

  /**
   * return the value that's removed; throw an IndexOutOfBoundsException if the index is invalid
   * Implements DELETE(p)
   *
   * @param index
   * @return return the value that's removed;
   */
  public String remove(int index);

  /**
   * This method gets the value of the end variable -1 to indicate the list size
   * Implements LENGTH() → int
   *
   * @param
   * @return return the size of the list
   */
  public int size();

  /**
   * This method checks to see if the list is empty
   * This was not in the Abstract List of Operations
   *
   * @param
   * @return Return true if the list is empty, false if it's not
   */
  public boolean isEmpty();

  /**
   * This method checks to see if value is in the list
   * This was not in the Abstract List of Operations
   *
   * @param
   * @return Return true if the value is in the list, false if it's not
   */
  public boolean contains(String value);

  /**
   * This method checks to see if value is in the list
   * Implements DELETE_ALL()
   *
   * @param
   * @return Return true if the value is in the list, false if it's not
   */
  public void clear();

  /**
   * This method overrides the default toString method and return comma separated element in the list.
   * This was not in the Abstract List of Operations
   *
   * @param
   * @return comma separated element in the list
   */
  public String toString();
  // TODO remove the public String toString();  from the List interface, it only needs to be in the classes.
}
