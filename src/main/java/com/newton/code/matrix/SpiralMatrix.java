package com.newton.code.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spiralOrder(matrix);
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integers = new ArrayList<>();

        int length = matrix.length;
        int lengthI = matrix[0].length;
        int i = 0;
        int j = 0;

        int tr = 0;
        int bl = 0;
        int rd = 0;
        int lt = 0;

        while (integers.size() != length * lengthI) {

            for (; j < lengthI - rd; j++) {
                integers.add(matrix[i][j]);
            }
            tr++;
            j--;
            i++;
            for (; i < length - bl && integers.size() != length * lengthI; i++) {
                integers.add(matrix[i][j]);
            }
            rd++;
            i--;
            j--;

            for (; j >= lt && integers.size() != length * lengthI; j--) {
                integers.add(matrix[i][j]);
            }
            bl++;
            j++;
            i--;

            for (; i >= tr && integers.size() != length * lengthI; i--) {
                integers.add(matrix[i][j]);
            }
            lt++;
            j++;
            i++;
        }
        return integers;
    }
}
