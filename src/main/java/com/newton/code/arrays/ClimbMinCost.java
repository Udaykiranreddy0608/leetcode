package com.newton.code.arrays;

public class ClimbMinCost {

    public static void main(String[] args) {
        //int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost = {10, 15, 20};

        climbCost(cost);
    }

    private static int climbCost(int[] cost) {
        int[] minCost = new int[cost.length + 1];

        for (int i = 2; i < minCost.length; i++) {
            int stepOne = minCost[i - 1] + cost[i - 1];
            int stepTwo = minCost[i - 2] + cost[i - 2];
            minCost[i] = Math.min(stepOne, stepTwo);
        }
        return minCost[minCost.length - 1];
    }

    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

}
