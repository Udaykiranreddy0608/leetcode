package com.newton.code.arrays;

public class DuplicateZeros2 {

    public static void main(String[] args) {
        int[] arr = {2, 0, 0, 0, 7, 0};
        duplicateZeros(arr);
    }

    public static void duplicateZeros(int[] arr) {
        int count = 0;
        int index = 0;
        int end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count += 2;
            } else {
                count++;
            }

            if (count >= arr.length) {
                index = i;
                break;
            }
        }

        if (count > arr.length) {
            arr[end--] = 0;
            index--;
        }


        for (int i = index; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[end--] = 0;
            }
            arr[end--] = arr[i];
        }

        System.out.println("Index" + count);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("\t" + arr[i]);
        }
    }
}
