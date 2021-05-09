package com.newton.code.arrays;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

  public static void main(String[] args) {
    int[] nums = {
      0, 0, 1, 1, 2, 3, 3, 3, 4, 4,
    };
    removeDuplicates2(nums);
  }

  public static int removeDuplicates(int[] nums) {
    Set<Integer> integers = new HashSet<>();
    if (nums.length == 0) return nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (integers.contains(nums[i])) {
        continue;
      } else {
        integers.add(nums[i]);
      }
    }
    System.out.println(integers);
    System.out.println(integers.size());
    return integers.size();
  }

  public static int removeDuplicates2(int[] nums) {

    if (nums.length == 0) return nums.length;
    int ref = 0;
    for (int i = 1; i < nums.length; i++) {

      if (nums[i] != nums[ref]) {
        ref++;
        nums[ref] = nums[i];
      }
    }

//    for (int num : nums) {
//      System.out.printf("" + num);
//    }
    System.out.println("Length : " + ref);
    return ref;
  }
}
