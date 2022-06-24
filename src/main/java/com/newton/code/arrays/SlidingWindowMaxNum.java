package com.newton.code.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaxNum {
  public static void main(String[] args) {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int k = 3;

    SlidingWindowMaxNum slidingWindowMaxNum = new SlidingWindowMaxNum();
    final int[] ints = slidingWindowMaxNum.maxSlidingWindow2(nums, k);

    for (int anInt : ints) {
      System.out.println(anInt);
    }
  }


  public int[] maxSlidingWindow2(int[] nums, int k) {
    Deque<Integer> dq = new LinkedList<>();
    int[] ret = new int[nums.length - k + 1];
    int idx = 0;
    for (int i = 0; i < k; i++) {
      while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
        dq.pollLast();
      }
      dq.addLast(i);
    }
    ret[idx] = nums[dq.peekFirst()];
    idx++;
    for (int i = k; i < nums.length; i++) {
      while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
        dq.pollFirst();
      }
      while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
        dq.pollLast();
      }
      dq.addLast(i);
      ret[idx] = nums[dq.peekFirst()];
      idx++;
    }
    return ret;
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
