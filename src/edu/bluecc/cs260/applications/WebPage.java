package edu.bluecc.cs260.applications;

import java.net.URL;
import java.time.LocalDateTime;

public class WebPage {

  private URL url;
  private LocalDateTime timestamp;

  public WebPage(URL url) {
    this.url = url;
    this.timestamp = LocalDateTime.now();
  }

  public URL getUrl() {
    return url;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "************************************\n\n" +
        "URL: " + url + "\n" +
        "Timestamp: " + timestamp + "\n\n" +
        "************************************\n";
  }
}