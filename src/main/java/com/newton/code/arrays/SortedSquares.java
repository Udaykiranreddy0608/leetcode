package com.newton.code.arrays;

public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = {0, 1, 8, 9};
        sortedSquares1(nums);
    }

    public static int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;
        for (int i1 = 0; i1 < nums.length; i1++) {
            if (nums[i1] >= 0) {
                j = i1 - 1;
                k = i1 - 1;
                break;
            }
        }
        if (j <= 0) {
            j = nums.length - 1;
            k = 0;
        }
        if (nums[j] < 0) {
            while (i <= j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
                i++;
            }
        }
        i = k;
        j = nums.length - 1;
        while (j >= 0) {
            if (j == i && j != 0) {
                i--;
            }
            if (nums[i] * nums[i] >= nums[j] * nums[j]) {
                int temp = nums[j];
                nums[j] = nums[i] * nums[i];
                nums[i] = temp;
            } else {
                nums[j] = nums[j] * nums[j];
            }
            j--;
        }

        nums[0] = nums[0] * nums[0];

        for (int num : nums) {
            System.out.printf("\t" + num);
        }
        return nums;
    }

    public static int[] sortedSquares1(int[] nums) {
        int[] arr1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int k = nums.length - 1;
        int j = nums.length - 1;
        for (int i = 0; i <= j; ) {
            if (nums[i] > nums[j]) {
                arr1[k] = nums[i];
                i++;
            } else {
                arr1[k] = nums[j];
                j--;
            }
            k--;
        }
        for (int num : arr1) {
            System.out.printf("\t" + num);
        }
        return nums;
    }

}
