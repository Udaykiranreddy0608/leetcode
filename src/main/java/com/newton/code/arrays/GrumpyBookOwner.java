package com.newton.code.arrays;

public class GrumpyBookOwner {
  public static void main(String[] args) {
    int[] customers = {10, 4};
    int[] grumpy = {0, 1};
    int minutes = 2;
    grumpyBookOwner2(customers, grumpy, minutes);
    /**
     *       c [1,0,1,2,1,1,7,5] -- [1,0,1,1,0,0,7,4]
     *       g [0,1,0,1,0,1,0,1]
     *         [1,x,1,2,1,x,7,x]
     *
     *
     */
  }

  private static int grumpyBookOwner2(int[] customers, int[] grumpy, int minutes) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    int len = customers.length;
    for (int i = 0; i < len; i++) {
      if (grumpy[i] == 0) {
        sum = sum + customers[i];
      }
    }

    for (int i = 0; i < minutes; i++) {
      if (grumpy[i] == 1) {
        sum = sum + customers[i];
      }
    }
    if (max < sum) {
      max = sum;
    }
    for (int i = minutes; i < len; i++) {
      if (grumpy[i] == 1) {
        sum = sum + customers[i];
      }
      if (grumpy[i - minutes] == 1) {
        sum = sum - customers[i - minutes];
      }
      max = Math.max(sum, max);
    }
    return max;
  }

  private static int grumpyBookOwner(int[] customers, int[] grumpy, int minutes) {

    int[] resMaxCust = new int[customers.length];
    for (int i = 0; i < customers.length; i++) {
      resMaxCust[i] = customers[i];
    }

    int maxCust = Integer.MIN_VALUE;
    int startPos = 0;
    int endPos = 0;

    int res = 0;
    for (int i = 0; i < resMaxCust.length; i++) {
      if (i < minutes) {
        res += resMaxCust[i];
      } else {
        res -= resMaxCust[i - minutes];
        res += resMaxCust[i];
      }
      if (maxCust < res) {
        startPos = i - minutes + 1;
        endPos = i;
      }
      maxCust = Math.max(maxCust, res);

    }
    int maxSatisfiedCust = 0;

    for (int i = 0; i < customers.length; i++) {
      if ((i >= startPos && i <= endPos) || grumpy[i] == 0) {
        maxSatisfiedCust += customers[i];
      }
    }
    return maxSatisfiedCust;
  }
}
