package com.newton.code.strings;

public class OperationsOnString {

    public static void main(String[] args) {
        // Given String 222-234+654

        Integer result = getSum2("5+5+2");
        System.out.println("Final value is :" + result);
    }

    private static Integer getSum2(String s) {
        int result = 0;
        int nVal = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                char op = s.charAt(i);
                int iVal = Integer.valueOf(sb.toString());
                sb = new StringBuilder();
                System.out.println("ival : " + iVal);
                System.out.println("found :" + op);
                StringBuilder sb2 = new StringBuilder();
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '+') {
                        nVal = Integer.valueOf(sb2.toString());
                        switch (op) {
                            case '+':
                                result = iVal + nVal;
                                return result;
                        }
                    } else {
                        sb2.append(s.charAt(j));
                        if (j == s.length() - 1) {
                            result = iVal + Integer.valueOf(sb2.toString());
                            return result;
                        }
                    }
                }

            } else {
                sb.append(s.charAt(i));
            }
        }

        return 0;
    }

    private static int getSum1(String input) {
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '+') {
                if (result == 0) result = Integer.valueOf(sb.toString());
                char op = input.charAt(i);
                StringBuilder sb2 = new StringBuilder();
                for (int j = i + 1; j < input.length(); j++) {

                    if (input.charAt(j) == '-' || input.charAt(j) == '+') {
                        int nextVal = Integer.valueOf(sb.toString());
                        switch (op) {
                            case '-':
                                result = result - nextVal;
                                break;
                            case '+':
                                result = result + nextVal;
                                break;
                        }
                        i = j;
                    } else {
                        sb2.append(j);
                    }
                }
            } else {
                sb.append(input.charAt(i));
            }
            //      if (i == input.length() - 1) {
            //        result = Integer.valueOf(sb.toString());
            //        return result;
            //      }
        }
        return result;
    }

    private static int getSum(String input) {
        int initVal = -1;
        int nextVal = 0;
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '+') {

                if (initVal == -1) {
                    initVal = Integer.valueOf(sb.toString());
                    sb = new StringBuilder();
                } else {
                    nextVal = Integer.valueOf(sb.toString());
                    sb = new StringBuilder();
                    if (input.charAt(i) == '-') {
                        result = initVal - nextVal;
                    } else if (input.charAt(i) == '+') {
                        result = initVal + nextVal;
                    }
                    initVal = -1;
                    nextVal = 0;
                }
            } else {
                sb.append(input.charAt(i));
            }
        }

        return result;
    }
}
