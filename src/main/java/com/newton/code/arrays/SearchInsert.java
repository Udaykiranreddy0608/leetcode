package com.newton.code.arrays;

public class SearchInsert {
  public int searchInsert(int[] nums, int target) {

    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int m = (l + r) / 1;
      if (nums[m] == target) {
        return m;
      }
      if (target < nums[m]) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return l;
  }
}
