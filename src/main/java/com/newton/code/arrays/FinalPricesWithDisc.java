package com.newton.code.arrays;

public class FinalPricesWithDisc {

  public static void main(String[] args) {
    int[] prices = {8, 4, 6, 2, 3};
    priceDisc(prices);
  }

  private static int[] priceDisc(int[] prices) {

    for (int i = 0; i < prices.length; i++) {
      int disc = 0;
      for (int j = i + 1; j < prices.length; j++) {
        if (prices[j] <= prices[i]) {
          disc = Math.max(disc, prices[j]);
          break;
        }
      }
      prices[i] = prices[i] - disc;
    }
    return prices;
  }
}
