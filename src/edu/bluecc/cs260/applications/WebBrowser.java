package edu.bluecc.cs260.applications;

// this code needs the ArrayStack built from the previous class's lecture

import edu.bluecc.cs260.stacks.ArrayStack;
import edu.bluecc.cs260.stacks.Stack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebBrowser {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    run();
  }

  public static void run() {
    Stack<WebPage> history = new ArrayStack<>(); //  ask the user for a web page to visit
    promptUser();
    String input = scanner.next();
    while (!"Q".equalsIgnoreCase(input)) {  // this will makes that it is never null
      if ("B".equalsIgnoreCase(input)) {
        if (history.isEmpty()) {
          System.out.println("Nothing to go back to");
        } else {
          WebPage page = history.pop();  // this is a local scoped history, so it won't effect the other 'history'
          System.out.println("Going back...");
          System.out.println(page);
        }
      } else {
        try {
          WebPage page = new WebPage(new URL(input));
          history.push(page);
          System.out.println(page);
        } catch (MalformedURLException e) {
          System.out.println("Malformed URL: " + input);
          System.out.println("Please try again");
        }
      }
      promptUser();
      input = scanner.next();
    }
      System.out.println("Thank you for using this amazing web browser!");
  }

  public static void promptUser() {
    System.out.println("Enter a URL; 'Q' to quit or 'B' to back");
  }

}
