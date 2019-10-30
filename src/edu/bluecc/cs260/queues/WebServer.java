package edu.bluecc.cs260.queues;

import java.util.concurrent.TimeUnit;

public class WebServer {

  public static void main(String[] args) {
    WebServer server = new WebServer();
    server.request("index.html");
    server.request("ilovecheese.html");
    server.request("homer.html");
    server.request("jello.html");
    server.request("helloworld.html");
    try {
      server.serveRequests();
    } catch (InterruptedException e) {
      System.out.println("Hmmm.. something happened waiting for the server");
      e.printStackTrace();
    }
  }

  private Queue<String> requests = new ArrayQueue<>();

  public void request(String page) {
    requests.add(page);
  }

  public void serveRequests() throws InterruptedException {
    while (!requests.isEmpty()) { // this will keep going until the queue is empty.
      TimeUnit.MILLISECONDS.sleep(500); // sleep throws an exception, so we need to handle it
      String page = requests.remove();
      System.out.printf("Serving page %s..\n\n", page);
    }
  }

}
