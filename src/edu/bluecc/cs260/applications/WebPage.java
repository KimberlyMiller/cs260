package edu.bluecc.cs260.applications;

import java.net.URL;
import java.time.LocalDateTime;

public class WebPage {

  private URL url;
  private LocalDateTime timestamp;

  public WebPage(URL url) {
    this.url = url;
    this.timestamp = LocalDateTime.now(0);
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}