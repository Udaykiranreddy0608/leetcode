package com.newton.code.arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {1};
        moveZeros(nums);
    }

    private static int[] moveZeros(int[] nums) {

        int i, j = 0;

        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }


        for (int s : nums) {
            System.out.printf(s + "\t");
        }
        return nums;
    }
}
