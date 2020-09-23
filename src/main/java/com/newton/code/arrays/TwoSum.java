package com.newton.code.arrays;


/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

import java.util.HashMap;

public class TwoSum {
  public static void main(String[] args) {
    int[] nums = new int[]{10, 2, 3, 4, 5, 6, 7};
    int[] res = twoSum(nums, 17);
    if (res != null) {
      System.out.println("[" + res[0] + "," + res[1] + "]");
    } else {
      System.out.println("Couldn't find a match");
    }
  }


  public static int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    for (int x = 0; x <= nums.length; x++) {
      int isExist = target - nums[x];
      if (hashMap.containsKey(isExist)) {
        res[0] = hashMap.get(isExist);
        res[1] = x;
        break;
      }
      hashMap.put(nums[x], x);
    }
    return res;
  }
  

  /*
   * Returns the indexes of the to numbers which matches the sum
   */
  public static int[] twoSum1(int[] nums, int target) {

    int temp1 = nums[0];
    for (int x = 1; x < nums.length; x++) {
      if (temp1 + nums[x] == target) {
        int[] res = new int[]{0, x};
        return res;
      }
    }
    return null;
  }
}
