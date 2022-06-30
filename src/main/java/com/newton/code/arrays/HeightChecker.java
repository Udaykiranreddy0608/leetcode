package com.newton.code.arrays;

public class HeightChecker {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 0};
        heightChecker(arr);

    }

    public static int heightChecker(int[] heights) {
        int cnt = 0;


        int[] sortHeight = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            sortHeight[i] = heights[i];
        }

        for (int i = 0; i < sortHeight.length; i++) {
            for (int j = i + 1; j < sortHeight.length; j++) {

                if (sortHeight[i] > sortHeight[j]) {
                    int temp = sortHeight[i];
                    sortHeight[i] = sortHeight[j];
                    sortHeight[j] = temp;
                }
            }
        }

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortHeight[i]) {
                cnt++;
            }
        }

        return cnt;
    }


}
