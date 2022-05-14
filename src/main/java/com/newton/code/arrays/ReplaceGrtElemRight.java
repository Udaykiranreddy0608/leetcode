package com.newton.code.arrays;

public class ReplaceGrtElemRight {

    public static void main(String[] args) {
        int[] arr = {17};
        final int[] ints = replaceElements(arr);
        for (int anInt : ints) {
            System.out.printf("\t" + anInt);
        }
    }

    public static int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] > max) {
                int temp = arr[i];
                arr[i] = max;
                max = temp;
            } else {
                arr[i] = max;
            }
        }
        return arr;
    }

}
