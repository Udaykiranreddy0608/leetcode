package com.newton.code.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisappearedArray {

  public static void main(String[] args) {
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

    findDisappearedNumbers(nums);
  }

  public static List<Integer> findDisappearedNumbers(int[] nums) {
    Set<Integer> set = new HashSet<>();
    List<Integer> integers = new ArrayList<>();
    for (int i = 1; i <= nums.length; i++) {
      set.add(i);
    }

    for (int i = 0; i < nums.length; i++) {
      set.remove(nums[i]);
    }

    List<Integer> res = new ArrayList<>();
    for (Integer integer : set) {
      res.add(integer);
    }

    return res;
  }
}
