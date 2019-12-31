package edu.bluecc.cs260.hashtable;

import java.util.LinkedList;
import java.util.List;

public class HashTableClassNotes<K,V> implements Map<K,V> {

  public static void main(String[] args) {
    // Map<String, Integer> map = new HashTable<>();
    HashTableClassNotes<String, Integer> map = new HashTableClassNotes<>();
    System.out.println("Size: " + map.size());
//    map.put("xyz", 123);
//    map.put("abc", 456);
//    System.out.println(map.get("xyz")); // 123
//    System.out.println(map.get("abc")); // 456
//    System.out.println(map.get("Abc")); // null
//    System.out.println(map.get("lkajdflkjalkjfdk")); // null

    System.out.println("Empty?: " + map.isEmpty());
    map.put("Letters", 1);
    System.out.println(map.get("Letters")); // 1

    System.out.println("Contains? " + map.containsKey("Letters"));

    map.put("Letters", 2);
    System.out.println(map.get("Letters")); // 2

    System.out.println("Empty?: " + map.isEmpty());

//    System.out.println(map.loadFactor());
//    for (int i = 0; i < 1000; i++) {
//      map.put("abc"+i,i);
//    }
    System.out.println(map);
    System.out.println(map.loadFactor()); // 1002/100 =  10.02   or if 10000 spots  1002/10000 = 0.1002
    System.out.println("Size: " + map.size());


  }

//  public static void main(String[] args) {
//    Map<String, Integer> map = new HashTable<>();
//    System.out.println("Size: " + map.size());
//    map.put("xyz", 42);
//    map.put("xyzA", 42234);
//    map.put("I like pandas", 987123);
//    map.put("3434", 1);
//    map.put("niasd987fi", 2);
//    map.put("jello", -897123);
////    String s = "key";
////    for (int i = 0; i < 1000; i++) {
////      map.put(s + i, i);
//
//    System.out.println(map);
//    System.out.println("Size: " + map.size());
//
//    // -------------------
//    System.out.println(map.get("I like pandass"));
//  }

//  public static void main(String[] args) {
//    String[] a = new String[1000]; // an array of pointers
//    // they are all null pointers to start with
//    String s = "abc";
//    String s2 = s.toUpperCase();
//    String s3 = a[45].toUpperCase(); // this is a reference to a String object in memory
//
//    System.out.println(s3);
////    // a[45] // this is null.  // this is a reference to a String object in memory
////    // a[location].add() // this is null.  // this is a reference to a String object in memory
////    new Entry<String, String>("t","k").hashCode();
////    System.out.println("xyz".hashCode());
////    System.out.println("xzy".hashCode());
////    System.out.println("zyx".hashCode());
////    System.out.println("zxy".hashCode());
////    System.out.println("zxy adljf 234 alfk 43l 1ljkfa 21ajf 234 aldkj \n f 21 325 andda slktd ow21 4343 aldk adljf 234 alfk 43l 1ljkfa 21ajf 234 aldkjf 21 325 andda slktd ow21 4343 aldk".hashCode());
  // -------------------
//    map.get("I like pandas"); // returns an Integer object, or null if it's not in the table

//    String s = "key";
//    for (int i = 0; i < 1000; i++) {
//      map.put(s + i, 987123);
  // s = s + i;  // this line makes the key values very long, so put this in the string value of the put() method's parameter so shorten the string...

  // HashTable<String,Student>
//      map.get("1234"); // --> a Student or null
//  }

  //<Entry<K, V>>[] a = (List<Entry<K, V>>[]) new List[1000]; // this is explicit casting to put it into the Entry // initialize the array

  private List<Entry<K, V>>[] a = (List<Entry<K, V>>[]) new List[10]; // this is explicit casting to put it into the Entry // initialize the array
  private int size = 0;

  // LOAD FACTOR is the ratio of the size of the table (how many entries) to the length of the underlying array. // So 100 spots (a.length is 100),  if there are 5 entries in the table the load factor is (alpah) = 5/100 = 0.05.  If there are 60 entries in a table with 100 spots, then alpha = 60/100 = 0.6.  If there are 100 entries in a table with 100 spots, then alpha = 100/100 = 1.  Alpha can be > 1.  If 1000 entries in a table with 100 spots, then alpha = 1000/100 = 10! <--- the problem is that isa big load factor, meaning lots of collisions! More duplication/collisions means worse performance.  More like 0(N) than 0(1).  // Can re-size our array and re-hash all values when the load factor is above 0.7 (say)

  // private LinkedList<Entry<K, V>>[] a = (LinkedList<Entry<K, V>>[]) new LinkedList[100]; //...

  /**
   * Associates the specified value with the specified key in this map.
   * if the map previously contained a mapping for the key, the old
   * value is replaced by the specified value.
   *
   * @param key key
   * @param value value
   */
  public void put(K key, V value){
    // Done...fixed the what if all the keyes exists
    // Replace the existing value with the new one
    // create a helper method for finding an existing entry (return an Entry object, not a value!)
    //     findEntry(key)

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

    size++;
  }

  public Entry<K,V> findEntry(K key){
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
    int location = getLocation(key); // 1.  apply the hash function to get location of this key in the array
    if (a[location] == null)
      return null;

    for (Entry<K,V> entry : a[location]) { // 2. if the location in the array is null --> return null // the array is an array of Lists. Each location is a list // loop through every Entry the list (linear search), checking for the key
      if (entry.getKey().equals(key))
        return entry.getValue();
    }
    return null;  // we get here only if they was not found

    // Note 1: // if a.length is 100 // 98273489765 --> 65 // 12312365 --> 65 // Note 2: // List<Entry<K, V>> entries = a[5]; // entries.get(4); // lambda expressions; Java Stream // Note 3: // compare two Java objects, must use .equals NOT == !!!  5 == 5; // !val // objPointer == null;
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
  public boolean containsKey(K key){ //  public boolean contains(K key);  // <-- alternate name used in class
    // Use the existing get. Easily done in one line
    return get(key) != null;
  }

  /**
   * Returns true if this map contains no key-value mappings.
   * @return true if this map contains a mapping for the specified key
   */
  public boolean isEmpty(){
    // a very simple one-liner
    return size == 0;
  }

  /**
   * Returns the number of key-value mappings in this map.
   * @return
   */
  public int size(){
    return size;
  }

  public String toString() {
    // shows every entry in the array
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < a.length; i++)
      builder.append(String.format("%d: %s\n", i, a[i]));
    return builder.toString();
  }

  private double loadFactor() {
    // ). If after adding a new entry the load factor is above 0.7, double the size of the array and re-hash all the values.
    // Note: you'll have to be careful doing the re-hashing: you don't want to re-hash existing key/value pairs into the same array or things will get very mixed up.
    // Instead, you'll need to create a new array with the new size and re-calculate the location for every existing item.
    // You can test your code by creating a helper method to show the size of the array, then set the original array size to something small (say, 5) and try adding a bunch of entries.
    // Each time, print out the array size (NOT the size of the hash table) to make sure your re-hashing is working correctly.
    // TODO write this
    return (1.0*size)/a.length;
  }
}
