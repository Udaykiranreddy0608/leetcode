package com.newton.code.arrays;

public class ParityArray {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 7};
        parity(nums);
    }

    private static int[] parity(int[] nums) {
        int j = nums.length - 1;
        for (int i = 0; i < j; ) {
            if (nums[i] % 2 == 0) {
                i++;
            } else if (nums[i] % 2 != 0) {
                if (nums[j] % 2 == 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j--;
            }
        }
        return nums;
    }
}
