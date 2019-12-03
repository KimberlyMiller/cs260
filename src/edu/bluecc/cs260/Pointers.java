package edu.bluecc.cs260;

import edu.bluecc.cs260.stacks.Node;
import edu.bluecc.cs260.queues.WebServer;

public class Pointers {

  public static void main(String[] args) {

    Node<WebServer> webServerNode = new Node<>(new WebServer());
    System.out.println(webServerNode);

    // 1
//    new Node<>("Coffee");

    // 2
//  Node<String> n1 = new Node<>("Coffee");

    // 3
//    Node<String> n1 = new Node<>("Coffee");
//    Node<String> n2 = new Node<>("Tea");

    // 4
//     Node<String> n1 = new Node<>("Coffee");
//     Node<String> n2 = new Node<>("Tea");
//     n2.setNext(n1);

    // 5
//      Node<String> n3 = new Node<>("Coffee");
//      Node<String> n4 = new Node<>("Tea");
//      n3.setNext(n4);
//      n4.setNext(n3);

    // 6
//    Node<String> n5 = new Node<>("Coffee");
//    Node<String> n6 = new Node<>("Tea");
//    n6.setNext(n5);
//    n5.setNext(n6);
//    Node<String> xyz = n5;  // this does is create a duplicate pointer to an object in memory.
//    while (xyz != null) {  // this will loop around on itself endlessly
//      System.out.println(xyz.getValue() + " " + xyz);  // this prints the memory location of what it is being pointed too. (it will be both the location of coffee, and tea)
//      xyz = xyz.getNext();
//    }
  }
}
