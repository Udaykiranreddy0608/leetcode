package com.newton.code.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionTwoArrays {
    public static void main(String[] args) {

        intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> integers = new HashMap();
        List<Integer> result = new ArrayList<>();

        for (int i : nums1) {
            Integer orDefault = integers.getOrDefault(i, null);
            if (orDefault == null) {
                integers.put(i, 1);
            } else {
                integers.put(i, integers.get(i) + 1);
            }
        }

        for (int i : nums2) {
            if (integers.containsKey(i)) {
                result.add(i);
                integers.put(i, integers.get(i) - 1);
                if(integers.get(i)<=0){
                    integers.remove(i);
                }
            }
        }
        int[] res = new int[result.size()];
        int cnt = 0;
        for (Integer integer : result) {
            res[cnt] = integer;
            cnt++;
        }

        return res;
    }
}
