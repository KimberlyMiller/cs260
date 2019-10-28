package edu.bluecc.cs260.lists;

public class ListTester {


  public static void main(String[] args) {
    ArrayList arrayList = new ArrayList();
    //test(arrayList);
    LinkedList linkedList = new LinkedList();
    //test(linkedList);
    SortedDoubleLinedList sdList = new SortedDoubleLinedList();
    test(sdList);
    sdList.add(0,"Q");
  }

  public static void test(List list) { // this is passing the contract data type:  List.java
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
    list.get(0);
  }
}
