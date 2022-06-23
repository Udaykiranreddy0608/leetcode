package com.newton.code.arrays;

public class SlidingWindowMaxNum {
  public static void main(String[] args) {
    int[] nums = {1};
    int k = 1;

    SlidingWindowMaxNum slidingWindowMaxNum = new SlidingWindowMaxNum();
    final int[] ints = slidingWindowMaxNum.maxSlidingWindow(nums, k);

    for (int anInt : ints) {
      System.out.println(anInt);
    }
  }

  /*
   * This works but doesn't work for large inputs.
   * Use dequeue to solve this problem efficiently
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    int cnt = 0;
    for (int i = 0; i <= nums.length - k; i++) {
      int max = nums[i];
      for (int x = 1; x < k; x++) {

        if (nums[i + x] > max) {
          max = nums[i + x];
        }
      }
      res[cnt++] = max;
    }
    return res;
  }

}
