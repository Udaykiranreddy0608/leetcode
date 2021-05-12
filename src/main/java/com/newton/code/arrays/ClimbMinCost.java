package com.newton.code.arrays;

public class ClimbMinCost {

    public static void main(String[] args) {
        //int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost = {10, 15, 20};

        climbCost(cost);
    }

    private static int climbCost(int[] cost) {
      int[] minCost = new int[cost.length+1];

        for (int i = 2; i < minCost.length; i++) {

        }


      return minCost[minCost.length-1];
    }


}
