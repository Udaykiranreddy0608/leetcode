package com.newton.code.arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {-1,3,4,5,6,7};
        int k = 2;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        int numsLength = nums.length;
        int[] n = new int[numsLength];
        int lastIndex = numsLength - 1 - k;
        for (int i = numsLength - 1; i > lastIndex; i--) {
            n[--k] = nums[i];
        }
        for (int y = 0; y <= lastIndex; y++) {
            n[k++] = nums[y];
        }
        for (int i = 0; i < n.length; i++) {
            nums[i] = n[i];
        }


    }
}
