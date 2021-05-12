package com.newton.code.arrays;

public class DefuseBomb {

    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};

        //5, 7, 1, 4 ,5, 7, 1, 4

        int k = 2;

        int[] res = defuse2(code, k);

        for (int i : res) {
            System.out.println("" + i);
        }
    }


    private static int[] defuse2(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];
        if (k > 0) {
            for (int i = 0; i < length; i++) {
                int res = 0;
                for (int j = i + 1; j < i + k + 1; j++) {
                    if (j >= length) {
                        res = code[j - length];
                    } else {
                        res = res + code[j];
                    }
                }
                result[i] = res;
            }
        } else if (k < 0) {
            for (int i = 0; i < length; i++) {
                int res = 0;
                for (int j = i - 1; j >= i + k; j--) {
                    if (j < 0) {
                        res = res + code[j + length];
                    } else {
                        res = res + code[j];
                    }
                }
                result[i] = res;
            }
        } else if (k == 0) {
            return result;
        }

        return result;
    }


    private static int[] defuse(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];
        if (k > 0) {
            for (int i = 0; i < length; i++) {
                int res = 0;
                int m = i + 1;
                for (int j = 0; j < k; j++) {
                    if (m == length) {
                        m = 0;
                    }
                    res = res + code[m];
                    m++;
                }
                result[i] = res;
            }
        } else if (k < 0) {
            for (int i = 0; i < length; i++) {
                int res = 0;
                int m = i - 1;
                for (int j = 0; j < k * -1; j++) {
                    if (m < 0) {
                        m = length - 1;
                    }
                    res = res + code[m];
                    m--;
                }
                result[i] = res;
            }
        } else if (k == 0) {
            return result;
        }

        return result;
    }
}
