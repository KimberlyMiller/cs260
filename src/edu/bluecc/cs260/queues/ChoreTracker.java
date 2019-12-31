/* ************************************************************
ChoreTracker.java
Created by Kim Miller on 13 December 2019
CS260 Fall 2019

Description: This program tracks the chores by having the options add, view, and delete chores from the queue, front to back.

Client: ChoreTracker.java
Object: Queue<String>.java
Object: CircularArrayQueue.java
Library: java.util.Scanner

% java ChoreTracker
// Sample Console:
Would you like to (A)dd a job, (G)et a job, (C)lear the queue, or (Q)uit?
//Sample Output:
A

// Sample Console:
Enter a job:
//Sample Output:
Sweep the floor
************************************************************ */

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

  /**
   * This runs the program until the user types 'q' to quit.  The method will add, remove, check, and validate, the queue stack.
   * @param q
   */
  private static void runProgram(Queue<String> q) {
    promptUser();
    String input = scanner.nextLine();

    while (!"q".equalsIgnoreCase(input)) {

        if ("a".equalsIgnoreCase(input)) {
          add(q,input);
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

  /**
   * This method adds the user's chore to the queue stack
   * @param q Queue object
   * @param input string entered by the user
   */
  private static void add(Queue<String> q, String input) {
    System.out.print("Enter a job: ");
    input = scanner.nextLine();
    q.add(input);
  }

  /**
   * Prompt the User to add or get jobs, clear the queue, or quit
   */
  private static void promptUser() {
    System.out.print("\nWould you like to (A)dd a job, (G)et a job, (C)lear the queue, or (Q)uit? ");
  }

  /**
   * The validates to see if the user really wants to quit the program or not
   * @param "q"  and input
   * @return the string
   */
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

  /**
   * Check the stack to see if there are any jobs left
   * @param "q"
   * @return the string
   */
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
