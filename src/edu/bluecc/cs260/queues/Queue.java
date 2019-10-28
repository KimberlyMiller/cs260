//package edu.bluecc.cs260.queues;
//
//public interface Queue<E> {
//
//  public static void main(String[] args) {
//    Queue<String> q = new ArrayQueue<>();
//    test(q);
//  }
//
//  private E[] = (E[])(new Object[1000]);
//  private int back = -1;
//
//  /**
//   *
//   */
//  public boolean add(E value){
//    a[++back] = value;
//    return false;
//  }
//
//  /**
//   *
//   */
//  public E remove() {
//    E value = a[0];
//    for (int i = 0; i < back; i++)
//      front = front + 1;
//    back--;
//    // System.arraycopy(a,1,a,0,back); // this is less efficent, then using the loop. This creates a whole copy of an array, just to shift everything over.
//    return value;
//  }
//
//  public boolean isEmpty() {
//    return back < 0;
//  }
//
//  public boolean clear() {
//    back = -1;
//  }
//}
