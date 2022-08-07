package com.newton.code.arrays;

public class FindMaxAverage {
    public static void main(String[] args) {
        int[] ints = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAvg(ints, k));
    }

    private static double findMaxAvg(int[] ints, int k) {
        double sol = 0;
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length; i++) {
            if (i < k) {
                sol += ints[i];
            } else {
                max = Math.max(max, sol / k);
                sol = sol - ints[i - k] + ints[i];
            }
        }
        max = Math.max(max, sol / k);
        return max;
    }
}
