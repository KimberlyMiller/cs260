package edu.bluecc.cs260.hashtable;

public class Entry<K,V> {

  private K key;
  private V value;

  public Entry(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("%s: %s", key, value);
  }
}
