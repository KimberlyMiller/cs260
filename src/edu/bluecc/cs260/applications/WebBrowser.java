package edu.bluecc.cs260.applications;

// this code needs the ArrayStack built from the previous class's lecture

import java.net.URL;

public class WebBrowser {

  //private static Scanner scanner = new Scanner(System.in);

  //public static void main(String[] args) {

  //}
/*
  public static void run() {
    Stack<WebPage> history = new ArrayStack<>();
    //  ask the user for a web page to visit
    promptUser();
    String input = scanner.next();
    while (! "Q".equalsIgnoreCase(input)) {  // this will makes that it is never null, so it keeps going until they type the 'Q'
      if ("B".equalsIgnoreCase(input)) {
        if (history.isEmpty()) {
          System.out.println("Nothing to go back to");
        } else {
        WebPage page = history.pop();  // this is a local scoped history, so it won't effect the other 'history'
        System.out.println("Going back...");
        System.out.println(page);
      } else {
        // input represents a URL
        // create a new WebPage, then push it on the stack
        try {
          WebPage page = new WebPage(new URL((input)));
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
    //  store their visit to that page, along a timestamp

    // give an option to Quit ("Q" to quit)

    // give an option to back ("B" to back)
  }

  public static void promptUser() {
    System.out.println("Enter a URL; 'Q' to quit or 'B' to back");
  }

  @Override
  public String toString() {
    return "************************************\n\n" +
    "URL: " + url + "\n" +
    "Timestamp: " + timestamp + "\n\n") +
    "************************************\n";
  }

*/
}
