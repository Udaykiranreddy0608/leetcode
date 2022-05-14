package com.newton.code.arrays;

import java.util.HashMap;

public class GoodPairs {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(goodPairs(nums));
    }

    private static int goodPairs(int[] nums) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (integerHashMap.containsKey(nums[i])) {
                integerHashMap.put(nums[i], integerHashMap.get(nums[i]) + 1);
            } else {
                integerHashMap.put(nums[i], 1);
            }
        }

        int pairs = 0;
        for (Integer integer : integerHashMap.keySet()) {
            pairs = pairs + (integerHashMap.get(integer) * (integerHashMap.get(integer) - 1)) / 2;
        }
        return pairs;
    }

}
