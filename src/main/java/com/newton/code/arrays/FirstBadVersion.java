package com.newton.code.arrays;

public class FirstBadVersion {
    public static void main(String[] args) {
        int i = firstBadVersion(5);
        System.out.println("Bad version found at :" + i);
    }

    public static int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (isBadVersion(m)) {

                r = m;
            } else l = m + 1;

        }
        return l;
    }

    public static boolean isBadVersion(int version) {
        return version == 4;
    }
}

