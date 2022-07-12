package com.newton.code.dp;

public class HouseRobber {
  public static void main(String[] args) {
    int[] nums = {2, 1, 7, 1, 1, 9, 4, 3, 1};
    System.out.println(rob(nums));
  }

  public static int rob(int[] nums) {
    int[] ans = new int[nums.length];
    ans[0] = nums[0];
    ans[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
    }
    return ans[ans.length - 1];
  }
}
