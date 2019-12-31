/* ************************************************************
HashTable.java
Created by Kim Miller on 31 December 2019
CS260 Fall 2019

Description: This program creates a HashTable using an underlining array data structure. The Maps interface accepts two different variable types of K (key) and V (value). Then this HashTable client
uses the string and integer as the variable's data types.

Client: HashTable.java
Interface: Map<K,V>.java
Object: Entry.java
Library: java.util.Arrays
Library: java.util.LinkedList
Library: java.util.List

% java HashTable

//Sample Output:
0: [abc3: 3]
1: null
2: [abc0: 0]
************************************************************ */

package edu.bluecc.cs260.hashtable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K,V> implements Map<K,V> {

  public static void main(String[] args) {
   // Map<String, Integer> map = new HashTable<>();
    HashTable<String, Integer> map = new HashTable<>();
    System.out.println("Hashtable size: " + map.size());
    System.out.println("Empty?: " + map.isEmpty());
//    map.put("xyz", 123);
//    map.put("abc", 456);
//    System.out.println("Key's value: " + map.get("xyz")); // 123
//    System.out.println("Key's value: " + map.get("abc")); // 456
//    System.out.println("Key's value: " + map.get("Abc")); // null
//    System.out.println("Key's value: " + map.get("lkajdflkjalkjfdk")); // null
//    System.out.println("Contains key? " + map.containsKey("lkajdflkjalkjfdk"));
//    System.out.println("Empty?: " + map.isEmpty());

    map.put("Letters", 1);
    System.out.println("Get value: " + map.get("Letters")); // 1
    System.out.println("Contains key? " + map.containsKey("Letters"));
    map.put("Letters", 2);
    System.out.println("Get value: " + map.get("Letters")); // 2
    System.out.println("Empty?: " + map.isEmpty());

    System.out.println(map.loadFactor());
    for (int i = 0; i < 10; i++) {
      map.put("abc"+i,i);
    }
    System.out.println(map);
    System.out.println(map.loadFactor());
    System.out.println("Hashtable size: " + map.size());
    }

  private List<Entry<K, V>>[] a = (List<Entry<K, V>>[]) new List[5];
  private int size = 0;

  /**
   * Associates the specified value with the specified key in this map.
   * if the map previously contained a mapping for the key, the old
   * value is replaced by the specified value.
   *
   * @param key key
   * @param value value
   */
  public void put(K key, V value){
    Entry<K,V> newEntry = new Entry<>(key, value);
    int location = getLocation(key);
    Entry<K,V> found = findEntry(key);

    if (found != null) { // trace: System.out.println("Found: " + found.getKey());
      if (newEntry.getKey().equals(found.getKey())) {
        System.out.println("same key!");
        a[location] = new LinkedList<>();  // if the key already exists this will replace it with the new key and it's new corresponding value
        size--;
      }
    }

    if (a[location] == null)
      a[location] = new LinkedList<>();
    a[location].add(newEntry);

    if (loadFactor() > 0.7)
      rehash();

    size++;
  }

  /**
   * if the entry exists return the Entry<K,V> object if it does exist
   * @param key
   * @return null if the Entry<K,V> object doesn't exist
   */
  private Entry<K,V> findEntry(K key){
    int location = getLocation(key);
    if (a[location] == null)
      return null;

    for (Entry<K,V> entry : a[location]) {
      if (entry.getKey().equals(key))
        return entry;
    }
    return null;
  }

  /**
   * Returns the value to which the specified key is mapped or null
   * if this map contains no mapping for this key
   *
   * @param key key
   * @return the value or null if this map does not contain the specified key
   */
  public V get(K key){
    int location = getLocation(key);
    if (a[location] == null)
      return null;

    for (Entry<K,V> entry : a[location]) {
      if (entry.getKey().equals(key))
        return entry.getValue();
    }
    return null;
  }

  /**
   * Apply the hash function to this key
   * @param key the key
   * @return the location for this key in the underlying array
   */
  private int getLocation(K key) {
    return Math.abs(key.hashCode()) % a.length;
  }

  /**
   * Returns true if this map contains a mapping for the specified key.
   *
   * @param key key
   * @return true if this map contains a mapping for the specified key
   */
  public boolean containsKey(K key){
    return get(key) != null;
  }

  /**
   * Returns false if this map contains no key-value mappings.
   * @return true if this map contains a mapping for the specified key
   */
  public boolean isEmpty(){
    // a very simple one-liner
    return size == 0;
  }

  /**
   * @return the number of key-value mappings in this map.
   */
  public int size(){
    return size;
  }

  /**
   * @return every entry in the array to the console
   */
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < a.length; i++)
      builder.append(String.format("%d: %s\n", i, a[i]));
    return builder.toString();
  }

  /**
   * @return the load factor
   */
  private double loadFactor() {
    return (1.0*size)/a.length;
  }

  /**
   * if the load factor is above 0.7, double the size of the array
   * @return a rehashed of all the values
   */
  private void rehash() {
    while (loadFactor() > 0.7) {
      sizeOfArray();  // trace: just a helper trace method
      a = Arrays.copyOf(a,(int)(2*a.length));
    }
    sizeOfArray();  // trace: just a helper trace method
  }

  /**
   * Helper trace method to make sure the size of the array is recalculating correctly.
   * Outputs data sizes
   */
  private void sizeOfArray() {
    System.out.println("----------------");
    System.out.println("Over 0.7!");
    System.out.println("Load Factor: " + loadFactor());
    System.out.println("Hashtable Size: " + size());
    System.out.println("Array size: " + a.length);
    System.out.println();
  }
}