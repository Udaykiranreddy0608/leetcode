package com.newton.code.arrays;

import java.util.TreeSet;

public class Test {
  public static void main(String[] args) {
    TreeSet<Integer> integers = new TreeSet<>();
    integers.add(10);
    integers.add(20);
    integers.add(30);
    integers.add(40);
    System.out.println(integers.floor(41));
    System.out.println(integers.ceiling(40));
  }
}
