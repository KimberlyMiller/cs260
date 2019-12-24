package edu.bluecc.cs260.hashtable;

public interface Map<K,V> {

  /**
   * Associates the specified value with the specified key in this map.
   * if the map previously contained a mapping for the key, the old
   * value is replaced by the specified value.
   *
   * @param key key
   * @param value value
   */
  public void put(K key, V value);

  /**
   * Returns the value to which the specified key is mapped or null
   * if this map contains no mapping for this key
   *
   * @param key key
   * @return the value or null if this map does not contain the specified key
   */
  public V get(K key);

  /**
   * Returns true if this map contains a mapping for the specified key.
   *
   * @param key key
   * @return true if this map contains a mapping for the specified key
   */
  public boolean containsKey(K key);  //  public boolean contains(K key);  // <-- alternate name used in class

  /**
   * Returns true if this map contains no key-value mappings.
   * @return true if this map contains a mapping for the specified key
   */
  public boolean isEmpty();

  /**
   * Returns the number of key-value mappings in this map.
   * @return
   */
  public int size();

}