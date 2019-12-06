package edu.bluecc.cs260.queues;

import java.util.Scanner;

public class ChoreTracker {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
   // Queue<String> q = new ArrayQueue<>();
   // Queue<String> q = new LinkedQueue<>(); // Fix this:  gets a null pointer exception when an item is removed.. // it also has nothing to get.. nothing was added to the queue
   Queue<String> q = new CircularArrayQueue<>();
    runProgram(q);
  }

  private static void runProgram(Queue<String> q) {
    promptUser();
    String input = scanner.nextLine();

    while (!"q".equalsIgnoreCase(input)) {

        if ("a".equalsIgnoreCase(input)) {
          System.out.println("Enter a job: ");
          input = scanner.nextLine();
          q.add(input);
        } else if ("g".equalsIgnoreCase(input)) {
          if (!q.isEmpty()) {
            if (q.peek() != null) {
              System.out.println(" ==> " + q.peek());
              q.remove();
            } else
              System.out.println(" * No more jobs! *");
          } else {
            System.out.println(" * No more jobs! *");
          }
        } else if ("c".equalsIgnoreCase(input)) {
          System.out.println(validateYN(q,input));
        } else
          System.out.println("* Invalid selection: " + input + "*");
      promptUser();
      input = scanner.nextLine();
    }
    System.out.println("Goodbye!");
  }

  private static void promptUser() {
    System.out.println("\nWould you like to (A)dd a job, (G)et a job, (C)lear the queue, or (Q)uit? ");
  }

  private static String validateYN(Queue<String> q, String input) {
    System.out.println("Are you sure (y/n)?");
    input = scanner.nextLine();

    while (!"y".equalsIgnoreCase(input) || !"n".equalsIgnoreCase(input)) {
      if (input.equalsIgnoreCase("y")) {
        q.clear();
        return " * Cleared! *";
      } else if (input.equalsIgnoreCase("n")) {
        return "";
      }

      System.out.println("Are you sure (y/n)?");
      input = scanner.nextLine();
    }
  return "";
  }

}
