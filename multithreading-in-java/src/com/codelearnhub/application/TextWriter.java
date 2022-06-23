package com.codelearnhub.application;

public class TextWriter implements Runnable {
  
  private Text text;
  
  public TextWriter(Text text) {
    this.text = text;
  }
  
  @Override
  public void run() {
    String script[] = {
      "All trademarks and registered trademarks appearing on Code Learn Hub ",
      "are the property of their respective owners. Java is a trademark or ",
      "registered trademark of Oracle Corporation in the United States and ",
      "other countries. Code Learn Hub is not connected to Oracle Corporation ",
      "and is not sponsored by Oracle Corporation."
    };
    for (int i = 0; i < script.length; i++) {
      text.write(script[i]);
      try {
        Thread.sleep(2000);
      } catch (InterruptedException ignored) {}
    }
  }
}
