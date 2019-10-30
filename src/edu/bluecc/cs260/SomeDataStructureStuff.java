package edu.bluecc.cs260;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomeDataStructureStuff {

  // not a global "state."  We are not changing it during the program
  private static Scanner scanner = new Scanner(System.in);

//  public static void main(String[] args) {
//    System.out.println("How many scores do you want to enter?");
//    int numScores = scanner.nextInt();
//    int[] scores = new int[numScores];
//    for (int i = 0; i < numScores; i++) {
//      System.out.println("Enter a score: ");
//      scores[i] = scanner.nextInt();
//    }
//    show(scores);
//  }

  public static void main(String[] args) {
    // TODO what did the instructor add here in regards to the stack and queue?
    System.out.print("Enter a score, 'Q' to quit: ");
    String input = scanner.next();
    List<Integer> scores = new ArrayList<>();  // List is a built in interface in Java
    while (!"q".equalsIgnoreCase(input)) {
      scores.add(Integer.valueOf(input));
      System.out.print("Enter a score, 'Q' to quit: ");
      input = scanner.next();
    }
    //scores.remove(100); // TODO what did the instructor do with this?
    //scores.add(6,45);  // TODO what did the instructor do with this?
    System.out.print(scores);
  }


  public static void show(int[] a) {
    for (int v : a)
      System.out.println(v + " ");
    System.out.println();
  }
}
