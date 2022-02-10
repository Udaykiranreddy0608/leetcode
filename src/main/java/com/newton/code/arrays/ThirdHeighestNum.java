package com.newton.code.arrays;

public class ThirdHeighestNum {
  public static void main(String[] args) {
    int[] arr = {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
    thirdMax(arr);

  }

  public static int thirdMax(int[] nums) {
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
    // System.out.println(max1);
    int count = nums.length;
    int minValue = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == Integer.MIN_VALUE){
        minValue ++;
      }
      if (minValue > 1 && nums[i] == Integer.MIN_VALUE) {
        count --;
        continue;
      }
      if ((nums[i] == max3 || nums[i] == max2 || nums[i] == max1) && nums[i] != Integer.MIN_VALUE) {
        count --;
        continue;
      }

      if (nums[i] > max3) {
        max3 = nums[i];
      }
      if (max3 > max2) {
        int temp = max2;
        max2 = max3;
        max3 = temp;
      }
      if (max2 > max1) {
        int temp = max1;
        max1 = max2;
        max2 = temp;
      }

    }

    if (count < 3) {
      System.out.println(max1);
      return max1;
    }
    System.out.println(max3);
    return max3;

  }

}
