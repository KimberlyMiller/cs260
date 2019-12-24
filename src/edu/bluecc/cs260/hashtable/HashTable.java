package edu.bluecc.cs260.hashtable;

import java.util.LinkedList;
import java.util.List;

public class HashTable<K,V> implements Map<K,V> {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashTable<>();
    System.out.println("Size: " + map.size());
    map.put("xyz", 42);
    map.put("I like pandas", 987123);
    map.put("3434", 1);
    map.put("niasd987fi", 2);
    map.put("jello", -897123);
    String s = "key";
    for (int i = 0; i < 100; i++) {
      map.put(s + i, 987123);
      // s = s + i;  // this line makes the key values very long, so put this in the string value of the put() method's parameter so shorten the string...

    // -------------------
    map.get("I like pandas"); // returns an Integer object, or null if it's not in the table

    // HashTable<String,Student>
      map.get("1234"); // --> a Student or null
    }
    System.out.println(map);
    System.out.println("Size: " + map.size());
  }

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
//  }

  List<Entry<K, V>>[] a = (List<Entry<K, V>>[]) new List[1000]; // this is explicit casting to put it into the Entry // initialize the array
  private int size = 0;

  // private LinkedList<Entry<K, V>>[] a = (LinkedList<Entry<K, V>>[]) new LinkedList[100];
 //...

  /**
   * Associates the specified value with the specified key in this map.
   * if the map previously contained a mapping for the key, the old
   * value is replaced by the specified value.
   *
   * @param key key
   * @param value value
   */
  public void put(K key, V value){
    int location = Math.abs(key.hashCode()) % a.length;
    if (a[location] == null)
      a[location] = new LinkedList<>();
    a[location].add(new Entry<>(key, value));
    size++;
  }

  /**
   * Returns the value to which the specified key is mapped or null
   * if this map contains no mapping for this key
   *
   * @param key key
   * @return the value or null if this map does not contain the specified key
   */
  public V get(K key){
    // TODO write this
    return null;
  }

  /**
   * Returns true if this map contains a mapping for the specified key.
   *
   * @param key key
   * @return true if this map contains a mapping for the specified key
   */
  public boolean containsKey(K key){ //  public boolean contains(K key);  // <-- alternate name used in class
    // TODO write this
    return false;
  }

  /**
   * Returns true if this map contains no key-value mappings.
   * @return true if this map contains a mapping for the specified key
   */
  public boolean isEmpty(){
    // TODO write this
    return false;
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
}
