package com.newton.code.matrix;

public class ReshapeMatrix {

  public static void main(String[] args) {
    int[][] mat = new int[][]{{1, 2}, {3, 4}};
    int[][] ints = matrixReshape(mat, 4, 1);
    for (int i = 0; i < ints.length; i++) {
      for (int i1 = 0; i1 < ints[i].length; i1++) {
        System.out.printf("\t" + ints[i][i1]);
      }
      System.out.println();
    }
  }

  public static int[][] matrixReshape(int[][] mat, int r, int c) {
    int m = mat.length;
    int n = mat[0].length;
    if (m * n != r * c) {
      return mat;
    }
    int[][] res = new int[r][c];

    int x = 0;
    int y = 0;
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        res[x][y] = mat[i][j];
        y++;
        if (y == c) {
          y = 0;
          x++;
        }
      }
    }
    return res;
  }
}
