package edu.bluecc.cs260.lists;

public interface List {

  /**
   * Implements RETRIEVE(p) → v
   * Gets the element at the given index
   *
   * @param index
   * @return the element at the given index
   */
  public String get(int index); // Throw an IndexOutOfBoundsException if the index is invalid

  /**
   * Implements LOCATE(v) → p
   * Return the first index in the list with the given value, or -1 if it's not found
   * @param val
   * @return
   */
  public int find(String val);

  // APPEND(v)
  // Return true if the element is successfully added, false if the list is full
  public boolean add(String val);

  // INSERT(p,v)
  // Throw an IndexOutOfBoundsException if the index is invalid
  public void add(int index, String val);

  // DELETE(v)
  // This method should return true only if the value is in the list and removed,
  // false if the value isn't found in the list
  public boolean remove(String val);

  // DELETE(p)
  // return the value that's removed; throw an IndexOutOfBoundsException if the index is invalid
  public String remove(int index);

  // LENGTH() → int
  public int size();

  // we didn't list this as an abstract operation; try it anyway
  // Return true if the list is empty, false if it's not
  public boolean isEmpty();

  // we didn't list this as an abstract operation; try it anyway
  // Return true if the value is in the list, false if it's not
  public boolean contains(String value);

  // DELETE_ALL()
  public void clear();

  // Convert the contents into a single string with values separated by commas.
  // It's OK to have a comma at the end of the String.
  // TODO remove the public String toString();  from the List interface, it only needs to be in the classes.
}
