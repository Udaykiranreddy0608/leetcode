package com.newton.code.arrays;

import java.util.HashSet;
import java.util.Set;

public class SmallestInteger {

    public static void main(String[] args) {
        System.out.printf("Min :" + solution(new int[]{1, 3, 6, 4, 1, 2}));
    }

    public static int solution(int[] A) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 1; i <= A.length + 1; i++) {
            integers.add(i);
        }


        for (int i = 0; i < A.length; i++) {
            integers.remove(A[i]);
        }

        int min = Integer.MAX_VALUE;

        for (Integer integer : integers) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
    }
}
