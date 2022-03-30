package com.newton.code.arrays;

public class RemoveElement {
  public static void main(String[] args) {
    int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
    int val = 2;
    removeElement(nums, val);
  }

  public static int removeElement(int[] nums, int val) {
    int k = 0;
    for (int num : nums) {
      if (num != val) {
        nums[k] = num;
        k++;
      }
    }

    for (int num : nums) {
      System.out.printf("\t" + num);
    }
    System.out.println();
    System.out.println("K :" + k);
    return k;
  }
}
