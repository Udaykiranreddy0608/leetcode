package com.newton.code.dp;

import java.util.HashMap;

public class GridTraveller {
    private static final HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Number of paths : " + uniquePaths(3, 6));
    }

    public static int uniquePaths(int m, int n) {
        String key = m + "_" + n;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m == 0 || n == 0) {
            return 0;
        }
        map.put(key, uniquePaths(m - 1, n) + uniquePaths(m, n - 1));
        return map.get(key);
    }


}
