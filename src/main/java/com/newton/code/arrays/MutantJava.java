package com.newton.code.arrays;

import java.util.Arrays;

public class MutantJava {
    public static void main(String[] args) {
        int[] nums = {60864, 25176, 27249, 21296, 20204};
        int target = 10;
        findMutant(nums, target);
    }

    private static void findMutant(int[] arr, int target) {

        Arrays.sort(arr);
        int minReq = Integer.MAX_VALUE;
        int reqValue = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int absValue = Math.abs(sum + (arr[i] * (arr.length - i)) - target);
            if (absValue < minReq) {
                reqValue = arr[i];
            }
            minReq = Math.min(minReq, absValue);
            sum = sum + arr[i];
        }


        System.out.println("ReqValue : " + reqValue);

        //20204
        // 56803 / len =  x
        // 20204 - x

        for (int i : arr) {
            System.out.println("" + i);
        }
    }
}
