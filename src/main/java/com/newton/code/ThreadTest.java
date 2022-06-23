package com.newton.code;

public class ThreadTest {
  public static void main(String[] args) throws InterruptedException {
    Thread.sleep(100L);
    Thread t1 = new Thread("test-1");
    Thread.sleep(100L);
    t1.interrupt();
    System.out.println(t1.isInterrupted());
  }
}
