package com.newton.code.arrays;

public class DuplicateZeros {

  public static void main(String[] args) {
    int[] arr = {2, 0, 0, 0, 7, 0};
    duplicateZeros(arr);
  }

  public static void duplicateZeros(int[] arr) {
    int cnt = 0;

    // Get all zeros from an array except the last one
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] == 0) {
        cnt++;
      }
    }

    // replace number of zeros with array tailing
    for (int x = arr.length - 1; x >= arr.length - cnt; x--) {
      arr[x] = 0;
    }


    //int end = arr.length - 1;
    for (int i = arr.length - (cnt + 1); i >= 0; i--) {
      if (arr[i] == 0) {
        arr[i + cnt] = arr[i];
        cnt--;
        arr[i + cnt] = arr[i];
      } else {
        arr[i + cnt] = arr[i];
      }

    }


    for (int i : arr) {
      System.out.printf("\t" + i);
    }
  }
}
