package edu.bluecc.cs260.queues;

public class QueueTester {

  // when testing the circular array... have it print the indexes to see when and if they are looping back on themselves, like from index 10 to index 0


  public static void main(String[] args) {
//    Queue<String> qArray = new ArrayQueue<>();
//    testArrayQueue(qArray);

//    Queue qLinked = new LinkedQueue<>();
//    testLinkedQueue(qLinked);

    Queue qCircularArray = new CircularArrayQueue<>();
    testCircularArrayQueue(qCircularArray);
  }

  public static void testArrayQueue(Queue<String> q) {
    q.add("A");
    q.add("B");
    q.add("C");
    q.add("D");
    System.out.println(q.remove()); // A
    System.out.println(q.remove()); // B
    System.out.println(q.peek()); // C
    System.out.println(q.remove()); // C
    q.add("Homer");
    System.out.println(q.remove()); // D
    System.out.println(q.peek()); // Homer
    System.out.println(q.remove()); // Homer

    System.out.println(q.isEmpty()); // True

    for (int i = 0; i < 1000; i++) {
      System.out.print(q.add("Homer") + " ");
    }
    System.out.println();
  }

  public static void testLinkedQueue(Queue<String> q) {
    System.out.println(q.isEmpty()); // True
    q.add("A");
    q.add("B");
    q.add("C");
    q.add("D");
    System.out.println(q.isEmpty()); // False
    System.out.println("peek " + q.peek()); // A
    System.out.println(q.remove()); // A
    System.out.println("peek " + q.peek()); // B
    System.out.println(q.remove()); // B
    System.out.println("peek " + q.peek()); // C
    System.out.println(q.remove()); // C
    q.add("Homer");
    System.out.println("peek " + q.peek()); // D
    System.out.println(q.remove()); // D
    System.out.println("peek " + q.peek()); // Homer
    System.out.println(q.remove()); // Homer

    System.out.println(q.isEmpty()); // True

    for (int i = 0; i < 1000; i++) {
      System.out.print(q.add("Homer") + " ");
    }
    System.out.println();
  }

  public static void testCircularArrayQueue(Queue<String> q) {
    System.out.println(q.isEmpty()); // True
    q.add("A");
    q.add("B");
    q.add("C");
    q.add("D");
    System.out.println(q.isEmpty()); // False
    System.out.println("peek " + q.peek()); // A
    System.out.println(q.remove()); // A
    System.out.println("peek " + q.peek()); // B
    System.out.println(q.remove()); // B
    System.out.println("peek " + q.peek()); // C
    System.out.println(q.remove()); // C
    q.add("Homer");
    System.out.println("peek " + q.peek()); // D
    System.out.println(q.remove()); // D
    System.out.println("peek " + q.peek()); // Homer
    System.out.println(q.remove()); // Homer

    System.out.println(q.isEmpty()); // True

    for (int i = 0; i < 1000; i++) {
      System.out.print(q.add("Homer") + " ");
    }
    System.out.println();
  }
}
