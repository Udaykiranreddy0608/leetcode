package com.newton.code.arrays;

public class MissingNumber {
  public static void main(String[] args) {
    int[] nums = {0, 1, 3};
    System.out.println("Missing number : " + missingNum(nums));
  }

  private static int missingNum(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
      missing ^= i ^ nums[i];
    }
    return missing;
  }
}
