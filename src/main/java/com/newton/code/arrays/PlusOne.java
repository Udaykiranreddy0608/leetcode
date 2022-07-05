package com.newton.code.arrays;

public class PlusOne {
  public static void main(String[] args) {
    int[] nums = {9, 9, 9, 9};
    int[] ints = plusOne(nums);
    for (int i = 0; i < ints.length; i++) {
      System.out.printf("" + ints[i]);
    }
  }

  private static int[] plusOne(int[] digits) {
    int carry = 1;

    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] == 9 && carry != 0) {
        digits[i] = 0;
      } else {
        digits[i] = digits[i] + carry;
        carry = 0;
      }
    }

    if (carry == 1) {
      int[] res1 = new int[digits.length + 1];
      res1[0] = carry;
      return res1;
    } else {
      return digits;
    }

  }
}
