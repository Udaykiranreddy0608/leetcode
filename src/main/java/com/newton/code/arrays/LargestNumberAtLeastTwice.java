package com.newton.code.arrays;

public class LargestNumberAtLeastTwice {
    public static void main(String[] args) {
        int[] ints = {3, 6, 1, 0};
        System.out.println(largestTwice(ints));
    }

    private static int largestTwice(int[] nums) {
        int maxValue = 0;
        int maxValueIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > maxValue && i != maxValueIndex) {
                return -1;
            }
        }
        return maxValueIndex;
    }
}
