package com.newton.code.slidingwindow;

/**
 * Minimum Size Subarray Sum
 * <p>
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray
 * [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or
 * equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class MinSizeSubArraySum {

    public static void main(String[] args) {

        int target = 7;
        int[] nums = {1, 5, 1, 3, 6, 1, 0,2};
        System.out.println(minSubArrayLenUsingTwoPointer(target, nums));
    }


    public static int minSubArrayLenUsingTwoPointer(int target, int[] nums) {
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
