package com.newton.code.matrix;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {
  public static void main(String[] args) {
    int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

    /**
     * 0, 1, 2, 0
     *
     * <p>3, 4, 5, 2
     *
     * <p>1, 3, 1, 5
     */

    /**
     * For a given matrix first we identify the row and columns position which has zero
     *
     * <p>Later we iterate through the entire matrix and when such position with above row /col is
     * identified we mark it as zero.
     */
    System.out.println("---------------- input ------------");
    printMatrix(matrix);
    System.out.println("---------------- Output ------------");
    printMatrix(setZeroes(matrix));
  }

  private static void printMatrix(int[][] matrix) {
    for (int[] ints : matrix) {
      for (int anInt : ints) {
        System.out.printf(anInt + "\t");
      }
      System.out.println("\n");
    }
  }

  public static int[][] setZeroes(int[][] matrix) {
    int r = matrix.length;
    int n = matrix[0].length;

    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < n; j++) {
        if (rows.contains(i) || cols.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
    return matrix;
  }
}
