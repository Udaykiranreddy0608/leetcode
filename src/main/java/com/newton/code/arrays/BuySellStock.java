package com.newton.code.arrays;

public class BuySellStock {
  public static void main(String[] args) {
    System.out.println("Max profit is : " + maxProfit(new int[] {7, 1, 6, 4, 5, 9}));
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
}
