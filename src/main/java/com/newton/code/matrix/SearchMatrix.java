package com.newton.code.matrix;

public class SearchMatrix {

  public static void main(String[] args) {
    int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    int target = 30;
    System.out.println(searchMatrix(matrix, target));

  }

  public static boolean searchMatrix(int[][] matrix, int target) {

    int requiredIndex = -1;
    int length = matrix.length;
    for (int i = 0; i < length - 1; i++) {
      if (matrix[i][0] < target && matrix[i + 1][0] > target) {
        requiredIndex = i;
        break;
      } else if (matrix[i][0] == target) {
        requiredIndex = i;
        return true;
      } else if (matrix[i + 1][0] == target) {
        requiredIndex = i + 1;
        return true;
      } else if (i + 1 == length - 1 && matrix[i + 1][0] < target) {
        requiredIndex = i + 1;
        break;
      }
    }
    if (matrix.length == 1) {
      for (int i = 0; i < matrix[0].length; i++) {
        if (matrix[0][i] == target) {
          return true;
        }
      }
    }

    int length1 = matrix[0].length;
    if (requiredIndex != -1) {
      for (int i = 0; i < length1; i++) {
        if (matrix[requiredIndex][i] == target) {
          return true;
        }
      }
    }
    return false;
  }
}
