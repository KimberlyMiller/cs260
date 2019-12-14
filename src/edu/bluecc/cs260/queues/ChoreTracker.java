package edu.bluecc.cs260.queues;

import java.util.Scanner;

public class ChoreTracker {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
//    Queue<String> q = new ArrayQueue<>();
//    Queue<String> q = new LinkedQueue<>();
    Queue<String> q = new CircularArrayQueue<>();
    runProgram(q);
  }

  private static void runProgram(Queue<String> q) {
    promptUser();
    String input = scanner.nextLine();

    while (!"q".equalsIgnoreCase(input)) {

        if ("a".equalsIgnoreCase(input)) {
          System.out.print("Enter a job: ");
           input = scanner.nextLine();
            q.add(input);
        } else if ("g".equalsIgnoreCase(input)) {
            System.out.print(anyMoreJobs(q));
        } else if ("c".equalsIgnoreCase(input)) {
            System.out.print(validateYN(q,input));
        } else
          System.out.println("* Invalid selection: " + input + " *");
      promptUser();
      input = scanner.nextLine();
    }
    System.out.println("Goodbye!");
  }

  private static void promptUser() {
    System.out.print("\nWould you like to (A)dd a job, (G)et a job, (C)lear the queue, or (Q)uit? ");
  }

  private static String validateYN(Queue<String> q, String input) {
    System.out.print("Are you sure (y/n)?");
    input = scanner.nextLine();

    while (!"y".equalsIgnoreCase(input) || !"n".equalsIgnoreCase(input)) {
      if (input.equalsIgnoreCase("y")) {
        q.clear();
        return " * Cleared! * \n";
      } else if (input.equalsIgnoreCase("n")) {
        return "";
      }

      System.out.print("Are you sure (y/n)?");
      input = scanner.nextLine();
    }
  return "";
  }

  private static String anyMoreJobs(Queue<String> q) {
    String s = "";

    if (q.isEmpty())
      s = " * No more jobs! * \n";
    else  {
      s = " ==> " + q.peek() + "\n";
      q.remove();
      return s;
    }
    return s;
  }

}
