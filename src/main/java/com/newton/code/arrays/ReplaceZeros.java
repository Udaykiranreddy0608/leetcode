package com.newton.code.arrays;

public class ReplaceZeros {
  public static void main(String[] args) {
    int[] arr = {0, 1, 2};
    sortArrayByParity(arr);

  }

  public static void moveZeroes(int[] nums) {

    int p = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[p] == 0 && nums[i] != 0) {
        nums[p] = nums[i];
        nums[i] = 0;
        p++;
      } else if (nums[p] != 0) {
        p++;
      }
    }


    for (int anInt : nums) {
      System.out.printf("\t" + anInt);
    }
  }


  public static int[] sortArrayByParity(int[] nums) {

    int p = 0;
    for (int i = 1; i < nums.length; i++) {

      if (nums[p] % 2 != 0 && nums[i] % 2 == 0) {
        int temp = nums[i];
        nums[i] = nums[p];
        nums[p] = temp;
        p++;
      } else if (nums[p] % 2 == 0) {
        p++;
      }
    }
    for (int num : nums) {
      System.out.printf("\t" + num);
    }
    return nums;
  }
}
