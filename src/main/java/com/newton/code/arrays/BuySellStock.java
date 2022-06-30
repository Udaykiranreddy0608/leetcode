package com.newton.code.arrays;

public class BuySellStock {
  public static void main(String[] args) {
    System.out.println("Max profit is : " + maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
  }

  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        int profit = prices[j] - prices[i];
        if (profit > maxProfit) {
          maxProfit = profit;
        }
      }
    }
    return maxProfit;
  }

  public static int maxProfit2(int[] prices) {
    int maxProfit = 0;
    int minVal = Integer.MAX_VALUE;
    int len = prices.length;
    for (int i = 0; i < len; i++) {
      maxProfit = Math.max(maxProfit, prices[i] - minVal);
      if (prices[i] < minVal) {
        minVal = prices[i];
      }
    }
    return maxProfit;
  }


}
