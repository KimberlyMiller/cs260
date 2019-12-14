package edu.bluecc.cs260.lists;

public class ListTester {


  public static void main(String[] args) {
    //ArrayList arrayList = new ArrayList();
    //test(arrayList);
    // LinkedList linkedList = new LinkedList();
    //test(linkedList);
    // SortedDoubleLinedList sdList = new SortedDoubleLinedList();
    // test(sdList);
    // sdList.add(0,"Q");


    LinkedList list = new LinkedList();
    // test1(list);
    // test2(list);

    list.add("A");
    list.add("B");
    list.add("C");
    list.add("Sun");
    System.out.println(list.isEmpty()); // false
    System.out.println(list.size()); // 4
    list.add("Sky");
    list.add(3,"blue");
    System.out.println(list.size()); // 6
// list.clear();     System.out.println(list.size()); // 0
//     for (int i = 0; i < list.size(); i++)
//       System.out.println(list.get(i));
     System.out.println(list);
     list.remove(5);
     System.out.println(list);

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

  public static void test1(List list) {
    System.out.println(list.size());
    for (int i = 0; i < 3; i++)
      list.add("Gerald");
    System.out.println(list.size());
    System.out.println("Done");
  }

  public static void test2(List list) {
    list.add("A");
    list.add("B");
    list.add("C");
    System.out.println(list.size()); // 3
    System.out.println(list.get(2)); // C
    System.out.println(list.get(0)); // A
    System.out.println(list.get(1)); // B
  }
}
