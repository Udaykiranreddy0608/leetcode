package com.newton.code.arrays;

import java.util.ArrayList;

public class AddOneToGivenArray {
    /**
     * Given a non-negative number represented as an array of digits,
     *
     * <p>add 1 to the number ( increment the number represented by the digits ).
     *
     * <p>The digits are stored such that the most significant digit is at the head of the list.
     *
     * <p>Example:
     *
     * <p>If the vector has [1, 2, 3]
     *
     * <p>the returned vector should be [1, 2, 4]
     *
     * <p>as 123 + 1 = 124.
     *
     * @param args
     */
    public static void main(String[] args) {
        //
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        //    integers.add(2);
        //    integers.add(3);
        //    integers.add(4);

        System.out.println(plusOne2(integers));
    }

    public static ArrayList<Integer> plusOne2(ArrayList<Integer> A) {
        int carry = 1;
        int num = 0;
        int n = A.size();

        for (int i = n - 1; i >= 0; i--) {
            num = A.get(i);
            num = num + carry;
            carry = 0;
            if (num == 10) {
                carry = 1;
                num = 0;
            }
            A.set(i, num);
        }

        ArrayList<Integer> result = new ArrayList<>();

        if (carry == 1) {
            result.add(1);
        }

        for (int x : A) {
            if (x == 0 && result.size() == 0) {
                continue;
            }
            result.add(x);
        }
        return result;
    }
}
