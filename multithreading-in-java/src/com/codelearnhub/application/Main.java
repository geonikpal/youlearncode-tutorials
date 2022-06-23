package com.codelearnhub.application;

import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

  public static void main(String[] args) throws InterruptedException {
  
    //emailService();
    //printService();
    //threadInterference();
    //arrayProducerAndConsumer();
    //volatileProducerConsumer();
    //doDeadLock();
    //messagingService();
    ConditionLock();
    //executorMessagingService();
    //executorCounterService(); // Callable
    //executorCounterServiceWithATask();
    //scheduleExecutorService();
    //scheduleWithFixedDelayExecutorService();
    //scheduleAtFixedRateExecutorService();
    //fairCounter();
    //semaphore();
    //threadLocal();
    
    System.out.println("The main thread has finished!");
  }
  
  private static void threadLocal() {
    List<Date> dates = new ArrayList<>(100);
    for (int i = 0; i < 100; i++) {
      dates.add(Date.from(Instant.now().plus(i, ChronoUnit.DAYS)));
    }
    for (int i = 0; i < 5; i++) {
      new Thread(new SimpleDateFormatterThread(dates)).start();
    }
  }
  
  private static void semaphore() {
    Semaphore semaphore = new Semaphore(2);
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 10; i++) {
      executorService.execute(new LongTask(semaphore));
    }
    executorService.shutdown();
  }
  
  private static void fairCounter() {
    new Thread(new FairCounter("Thread-1", Color.PURPLE)).start();
    new Thread(new FairCounter("Thread-2", Color.YELLOW)).start();
    new Thread(new FairCounter("Thread-3", Color.CYAN)).start();
  }
  
  private static void scheduleAtFixedRateExecutorService() {
    ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
    getInstant("Main thread");
    service.scheduleAtFixedRate(new Job("Thread-1", 8), 9, 9, TimeUnit.SECONDS);
    service.scheduleAtFixedRate(new Job("Thread-2", 4), 11, 2, TimeUnit.SECONDS);
  
    sleep(service);
  }
  
  private static void scheduleWithFixedDelayExecutorService() {
    ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
    getInstant("Main thread");
    service.scheduleWithFixedDelay(new Job("Thread-1", 10), 5, 3, TimeUnit.SECONDS);
    service.scheduleWithFixedDelay(new Job("Thread-2", 5), 10, 10, TimeUnit.SECONDS);
    sleep(service);
  }
  
  private static void scheduleExecutorService() {
    
    ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
    getInstant("Main thread");
    service.schedule(new Job("Thread-1", 5), 15, TimeUnit.SECONDS);
    service.schedule(new Job("Thread-2", 10), 10, TimeUnit.SECONDS);
    service.schedule(new Job("Thread-3", 15), 5, TimeUnit.SECONDS);
  
    sleep(service);
  }
  
  private static void sleep(ScheduledExecutorService service) {
    try {
      Thread.sleep(20000);
    } catch (InterruptedException ignored) { }
    service.shutdown();
  }
  
  public static void getInstant(String thread) {
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
    LocalTime time = LocalTime.now();
    System.out.println(thread + " at " + time.format(formatter));
  }
  
  private static void executorCounterServiceWithATask() {
    ExecutorService executorService = Executors.newCachedThreadPool();
    Future<List<Integer>> future = executorService.submit(new NumberGenerator());
  
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ignored) {}
  
    System.out.println("About to invoke the get() method!");
    executorService.execute(new Task(future));
    executorService.shutdown();
    System.out.println("I won't have to wait until future is done ANYMORE! ;)");
  }
  
  private static void executorCounterService() {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<List<Integer>> future = executorService.submit(new NumberGenerator());
    // Pretend we are doing some other tasks meanwhile...
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ignored) {}
    
    List<Integer> numbers = new ArrayList<>();
    try {
      System.out.println("About to invoke the get() method!");
      //numbers = future.get();
      numbers = future.get(30, TimeUnit.SECONDS); // Lock if not ready!
      
      System.out.println("I wil have to wait until future is done. :(");
    } catch (TimeoutException e) {
      System.out.println("I couldn't wait after all!");
      future.cancel(true);
    } catch (ExecutionException | InterruptedException e) {
       e.printStackTrace(); // May throw exceptions.
    }
    executorService.shutdown(); // Don't forget to shut me down!
  }
  
  private static void executorMessagingService() {
    List<String> messages = new ArrayList<>();
    ReentrantLock msgLock = new ReentrantLock();
  
    MessageWriter msgWriter = new MessageWriter(messages, msgLock);
    MessageReader msgReader1 = new MessageReader(messages, msgLock);
    MessageReader msgReader2 = new MessageReader(messages, msgLock);
    
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.execute(msgWriter);
    executorService.execute(msgReader1);
    executorService.execute(msgReader2);
    
    executorService.shutdownNow();
  }
  
  private static void ConditionLock() {
    ArrayCondition arrayCondition = new ArrayCondition();
    new Thread(new ProducerCondition(arrayCondition)).start();
    new Thread(new ConsumerCondition(arrayCondition)).start();
  }
  
  private static void messagingService() {
    List<String> messages = new ArrayList<>();
    ReentrantLock msgLock = new ReentrantLock(true);
    MessageWriter msgWriter = new MessageWriter(messages, msgLock);
    MessageReader msgReader1 = new MessageReader(messages, msgLock);
    MessageReader msgReader2 = new MessageReader(messages, msgLock);
    
    new Thread(msgWriter).start();
    new Thread(msgReader1).start();
    new Thread(msgReader2).start();
  }
  
  private static void doDeadLock() {
    final Person john = new Person("John");
    final Person georgios = new Person("Georgios");
    //new Thread(() -> {john.wave(georgios);}).start();
    //new Thread(() -> {georgios.wave(john);}).start();
    var t1 = new Thread(() -> john.wave(georgios));
    var t2 = new Thread(() -> georgios.wave(john));
    t1.start();
    t2.start();
  
    try {
      Thread.sleep(30000);
      System.out.println(t1.getState());
      System.out.println(t2.getState());
      //System.exit(130);
    } catch (InterruptedException ignored) { }
  }
  
  private volatile static int countdown = 6;
  private static void volatileProducerConsumer() {
    
    new Thread(() -> {
      int local_countdown = countdown;
      while (local_countdown > 0) {
        System.out.println("Decrementing to "+ (local_countdown - 1));
        countdown = --local_countdown;
        try {
          Thread.sleep(1000);
        } catch (InterruptedException ignored) { }
      }
    }).start();
    
    new Thread(() -> {
      int local_countdown = countdown;
      while (local_countdown > 0) {
        if (local_countdown != countdown) {
          System.out.println("Value changed: " + countdown);
          local_countdown = countdown;
        }
      }
    }).start();
  }
  
  private static void arrayProducerAndConsumer() {
    Array array = new Array();
    new Thread(new Producer(array)).start();
    new Thread(new Consumer(array)).start();
  }
  
  private static void printService() throws InterruptedException {
    
    String doc1 = "Printing Java doc...";
    String doc2 = "Printing Code Learn Hub article...";
    
    PrintService printService1 = new PrintService(doc1, Color.YELLOW);
    PrintService printService2 = new PrintService(doc2, Color.PURPLE);
    printService1.start();
    //printService1.join();
    printService2.start();
    //printService2.join();
  }
  
  private static void emailService() {
    Thread emailService1 = new Thread(new EmailService("Receiving Email..."));
    //emailService1.run();
    emailService1.start();
    Thread emailService2 = new Thread(new EmailService("Sending Email..."));
    //emailService2.run();
    emailService2.start();
  }
  
  private static void threadInterference() {
    Counter counter = new Counter();
    new CounterThread(counter).start();
    new CounterThread(counter).start();
  }
  
  private static void doBlockedThread() throws InterruptedException {
    Hanger hanger1 = new Hanger();
    Hanger hanger2 = new Hanger();
    
    hanger1.start();
    hanger2.start();
    Thread.sleep(2000);
    printState(hanger2);
    System.exit(0);
  }
  
  private static void printState(Thread thread) {
    System.out.println(thread.getState());
  }
}