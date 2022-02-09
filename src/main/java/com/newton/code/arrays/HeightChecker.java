package com.newton.code.arrays;

public class HeightChecker {
  public static void main(String[] args) {
    int[] arr = {0, 1, 2};
    heightChecker(arr);

  }

  public static int heightChecker(int[] heights) {
    int cnt = 0;
    int max = heights[0];

    for (int i = 1; i < heights.length; i++) {

      if (heights[i] >= max) {
        max = heights[i];
      } else {
        cnt++;
      }

    }
    return cnt;
  }

}
