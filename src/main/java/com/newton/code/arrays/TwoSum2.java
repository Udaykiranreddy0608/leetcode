package com.newton.code.arrays;

import java.util.HashMap;

public class TwoSum2 {
  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 13};
    int target = 9;
    twoSum2(nums, target);
  }


  public static int[] twoSum2(int[] numbers, int target) {
    int[] val = new int[2];
    HashMap<Integer, Integer> integerHashMap = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      int x = target - numbers[i];
      if (integerHashMap.containsKey(x)) {
        val[1] = i + 1;
        val[0] = integerHashMap.get(x) + 1;
        return val;
      } else {
        integerHashMap.put(numbers[i], i);
      }
    }
//        for (int i : val) {
//            System.out.printf("\t" + i);
//        }
    return val;
  }
}
