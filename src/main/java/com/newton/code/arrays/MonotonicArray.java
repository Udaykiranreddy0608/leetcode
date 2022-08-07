package com.newton.code.arrays;

public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums = {7, 1, 2, 3, 4};

        findMonotinic(nums);
    }

    private static boolean findMonotinic(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                isIncreasing = false;
            }
            if (nums[i] > nums[i + 1]) {
                isDecreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }
}
