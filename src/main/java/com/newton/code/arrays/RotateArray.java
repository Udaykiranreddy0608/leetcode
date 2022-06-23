package com.newton.code.arrays;

public class RotateArray {
    public static void main(String[] args) {
        System.out.println(2 % 9);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 4;
        rotate2(nums, k);
    }


    public static void rotate2(int[] nums, int k) {

        if (nums.length <= k) {
            k = k - nums.length;
        }
        int j = nums.length - k;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("i : " + i + "\t j :" + j);
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            if (j == nums.length - 1) {
                j = nums.length - k;
            } else {
                j++;
            }
        }

        for (int num : nums) {
            System.out.printf(num + "\t");
        }
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
