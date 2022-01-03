package com.newton.code.arrays;

public class TownJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        findJudge(n, trust);
    }

    public static int findJudge(int n, int[][] trust) {

        int[] trusted = new int[n - 1];
        int[] trusting = new int[n - 1];

        for (int i = 0; i < n; i++) {
            int p1 = trust[i][0];
            int p2 = trust[i][1];
            trusted[p1]++;
            trusting[p2]++;
        }

        for (int i = 0; i < n; i++) {

            if (trusted[i] == n - 1 && trusting[i] == 0) {
                return i;
            }

        }


        return -1;
    }
}
