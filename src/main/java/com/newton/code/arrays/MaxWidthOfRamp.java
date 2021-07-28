package com.newton.code.arrays;

public class MaxWidthOfRamp {
    public static void main(String[] args) {
        int[] nums = {6, 0, 8, 2, 1, 5};
        maxWidth(nums);
    }

    /**
     * [9,8,1,0,1,9,4,0,4,1]
     * <p>
     * [9,8,1,0]
     * [0,1,2,3] 9-3 = 6
     * [0,1,2]   9-2 = 7
     * -------------------
     * [0,1]     9
     * [0]
     * <p>
     * <p>
     * <p>
     * [6,7,4,5,3,5,2,3,0,1]
     * <p>
     * [6,4,3,2,0] ->
     *
     * @param nums
     * @return
     */
    private static int maxWidth(int[] nums) {
        int max = Integer.MIN_VALUE;
        int length = nums.length - 1;

        for (int i = 0; i <= length; i++) {
            if (length - i > max) {
                for (int j = length; j > i; j--) {
                    if (nums[i] <= nums[j]) {
                        max = Math.max(max, j - i);
                        break;
                    }
                }
            }
        }
        if (max == Integer.MIN_VALUE) return 0;
        return max;
    }
}
