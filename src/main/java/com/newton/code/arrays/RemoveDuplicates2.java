package com.newton.code.arrays;

import java.util.Hashtable;

public class RemoveDuplicates2 {
  public static void main(String[] args) {
    int[] nums = {0, 3, 2, 1};
    //removeDuplicates(nums);
  }

  public static int removeDuplicates(int[] nums) {
    int k = 0;
    for (int i = 1; i < nums.length; i++) {

      if (nums[i] != nums[k]) {
        k++;
        nums[k] = nums[i];
      }
    }

    for (int num : nums) {
      System.out.printf("\t" + num);
    }

    System.out.println("");

    System.out.println("k :" + k);
    return 0;
  }

  public static boolean checkIfExist(int[] arr) {
    Hashtable<Integer, Integer> hashtable = new Hashtable<>();

    for (int i : arr) {
      if (hashtable.contains(i) || hashtable.contains(i * 2)) {
        return true;
      } else {
        hashtable.put(i, i * 2);
      }
    }
    return false;
  }
}
