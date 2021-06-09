package com.newton.code.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class KpairDiff {

    public static void main(String[] args) {
        int nums[] = {3, 3, 1, 4, 1, 3, 5};
        int k = 2;
        findPairs(nums, k);
    }

    public static int findPairs(int[] nums, int k) {

        HashMap<Integer, Set<Integer>> integerListHashMap = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            Set<Integer> setOfIndex = integerListHashMap.getOrDefault(nums[i], new HashSet<>());
            setOfIndex.add(i);
            integerListHashMap.put(nums[i], setOfIndex);
        }

        int unique = 0;
        Set<Integer> processed = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!processed.contains(nums[i])) {
                int x = nums[i] - k;
                int y = nums[i] + k;
                if (integerListHashMap.containsKey(x)) {
                    Set<Integer> integers = integerListHashMap.get(x);
                    int finalI = i;
                    if (integers.stream().filter(p -> p > finalI && !processed.contains(nums[p])).collect(Collectors.toSet()).size() > 0) {
                        unique++;
                    }
                }
                if (integerListHashMap.containsKey(y) && k!=0 ) {
                    Set<Integer> integers = integerListHashMap.get(y);
                    int finalI = i;
                    if (integers.stream().filter(p -> p > finalI && !processed.contains(nums[p])).collect(Collectors.toSet()).size() > 0) {
                        unique++;
                    }
                }
                processed.add(nums[i]);
            }
        }
        return unique;
    }
}
