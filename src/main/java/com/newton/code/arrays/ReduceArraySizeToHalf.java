package com.newton.code.arrays;

import java.util.*;

public class ReduceArraySizeToHalf {

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        minSetSize2(arr);
    }


    private static int minSetSize2(int[] arr) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i : arr) {
            integerHashMap.put(i, integerHashMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return integerHashMap.get(o2) - integerHashMap.get(o1);
            }
        });


        for (Integer integer : integerHashMap.keySet()) {







            pq.add(integer);
        }

        int n = arr.length / 2;
        int currSize = 0;
        int count = 0;
        while (currSize < n) {
            currSize += integerHashMap.get(pq.poll());
            count++;
        }

        for (Integer integer : pq) {
            System.out.println(""+integer);
        }

        return count;
    }



    private static int minSetSize(int[] arr) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i : arr) {
            integerHashMap.put(i, integerHashMap.getOrDefault(i, 0) + 1);
        }
        int arrLen = arr.length;
        int lenReq = arr.length / 2;
        int preVal = 0;

        Set<Integer> result = new HashSet<>();
        while (true) {
            int maxKey = getMaxKeyFromHashMap(integerHashMap);
            preVal = preVal + integerHashMap.get(maxKey);
            arrLen = arr.length - preVal;
            integerHashMap.remove(maxKey);
            result.add(maxKey);
            if (arrLen <= lenReq) {
                break;
            }
        }
      return  result.size();
    }

    private static int getMaxKeyFromHashMap(HashMap<Integer, Integer> integerHashMap) {
        int maxKey = 0;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : integerHashMap.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            if (value > maxValue) {
                maxValue = value;
                maxKey = integerIntegerEntry.getKey();
            }

        }
        return maxKey;
    }
}
