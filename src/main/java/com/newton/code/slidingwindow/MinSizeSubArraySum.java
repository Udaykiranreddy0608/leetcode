package com.newton.code.slidingwindow;

/**
 * Minimum Size Subarray Sum
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
 * subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no
 * such subarray, return 0 instead.
 * <p>
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: The subarray [4,3] has the minimal length under the
 * problem constraint. Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4] Output: 1 Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1] Output: 0
 */
public class MinSizeSubArraySum {

  public static void main(String[] args) {

    int target = 7;
    int[] nums = {1, 5, 1, 3, 6, 1, 0, 2};
    System.out.println(minSubArrayLen(target, nums));
  }


  /**
   * Below problem is solved using two pointer approach.
   * <p>
   * - scan through the array 0 to nums length - 1 - get the sum of numbers as you pass through - once sum is >= target
   * get the index size and mark the least index that you achieve - check further if you can reduce the index from left
   * and still achieve target number - while doing above increment the left and also subtract that number from actual
   * sum - that's all you should be able to solve this.
   * </p>
   *
   * @param target target num to searched for.
   * @param nums   array of number as input.
   * @return min array size obtained.
   */
  public static int minSubArrayLen(int target, int[] nums) {
    int ans = Integer.MAX_VALUE;
    int left = 0;
    int currentSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];
      while (currentSum >= target) {
        ans = Math.min(ans, i + 1 - left);
        currentSum -= nums[left++];
      }
    }
    return ans != Integer.MAX_VALUE ? ans : 0;
  }
}
