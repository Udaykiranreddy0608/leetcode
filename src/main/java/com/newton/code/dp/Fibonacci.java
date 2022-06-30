package com.newton.code.dp;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Fibonacci {
    static HashMap<Integer, Integer> mem = new HashMap<>();

    public static void main(String[] args) {
        //   System.out.println(fibonacci(7));
        long start = System.currentTimeMillis();
        System.out.println("Start :" + start);
        System.out.println(fibonacciMem(150));
        long end = System.currentTimeMillis();
        System.out.println("End : " + end);
        System.out.println("Total time :" + TimeUnit.MILLISECONDS.toMinutes(end - start));
    }

    private static int fibonacci(int i) {
        if (i <= 2) {
            return 1;
        }
        int recValue = fibonacci(i - 1) + fibonacci(i - 2);
        return recValue;
    }

    private static int fibonacciMem(int i) {
        if (mem.containsKey(i)) {
            return mem.get(i);
        }
        if (i <= 2) {
            return 1;
        }
        int recValue = fibonacciMem(i - 1) + fibonacciMem(i - 2);
        mem.put(i, recValue);
        return recValue;
    }
}
