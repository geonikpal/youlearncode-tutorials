package com.codelearnhub.application;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

public class SimpleDateFormatterThread implements Runnable {
  
  List<Date> dates;
  public SimpleDateFormatterThread(List<Date> dates) {
    this.dates = dates;
  }
  //private static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
  private static ThreadLocal<SimpleDateFormat> dateFormatterThread =
    ThreadLocal.withInitial(() -> new SimpleDateFormat("MM-dd-yyyy"));
  
  @Override
  public void run() {
    for (Date date : dates) {
      System.out.println(
        Thread.currentThread().getName() + ": " + dateFormatterThread.get().format(date));
      //System.out.println(
        //Thread.currentThread().getName() + ": " + sdf.format(date));
    }
  }
}
