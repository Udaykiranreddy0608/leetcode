package com.newton.code.arrays;

public class TownJudge {
  public static void main(String[] args) {
    int n = 3;
    int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
    findJudge(n, trust);
  }

  public static int findJudge(int n, int[][] trust) {

    int[] trusted = new int[n + 1];
    int[] trusting = new int[n + 1];

    for (int[] ints : trust) {
      int p1 = ints[0];
      int p2 = ints[1];
      trusted[p2]++;
      trusting[p1]++;
    }

    for (int i = n; n >= 0; i--) {

      if (trusted[i] == n - 1 && trusting[i] == 0) {
        return i;
      }
    }
    return -1;
  }
}
