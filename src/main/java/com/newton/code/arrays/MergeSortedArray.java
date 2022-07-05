package com.newton.code.arrays;

public class MergeSortedArray {
  public static void main(String[] args) {
    //Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    int[] nums1 = {7, 8, 9, 0, 0, 0}, nums2 = {1, 2, 6};
    int m = 3, n = 3;

    merge(nums1, m, nums2, n);
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int len = m + n;
    int a = m - 1;
    int b = n - 1;

    while (a >= 0 && b >= 0) {
      if (nums1[a] >= nums2[b]) {
        nums1[--len] = nums1[a];
        a--;
      } else {
        nums1[--len] = nums2[b];
        b--;
      }
    }

    while (b >= 0) {
      nums1[b] = nums2[b];
      b--;
    }
  }
}


