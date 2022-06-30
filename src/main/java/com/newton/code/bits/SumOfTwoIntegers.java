package com.newton.code.bits;

public class SumOfTwoIntegers {
    public static void main(String[] args) {

        sumOfTwoIntegers(1, 3);
    }

    public static boolean checkPos(int i, int shiftNum) {
        return (i & shiftNum) >= 1;
    }

    private static void sumOfTwoIntegers(int num1, int num2) {

        int carry = 0;
        for (int shift = 0; shift <= 32; shift++) {

            boolean b1 = checkPos(num1, 1 << shift);

            boolean b2 = checkPos(num2, 1 << shift);

            if (b1 == b2) {
                carry = 1;
            } else {

            }
        }



        /*
        0000001
        0000001
        -------
        0000001 -> 1

        000011
        000001
        ------
        000001 ->  1


        res = 0
        carry = 1

        000001
        000010
        ------
        0000000 -> 0

        00000011
        00000010
        ---------
        000000010 1<<1 -> 1

        res = 00
        carry = 1


        00000011
        00000010
        ---------
        000000100 1<<2 -> 0






        res - 100

         */

    }

}
