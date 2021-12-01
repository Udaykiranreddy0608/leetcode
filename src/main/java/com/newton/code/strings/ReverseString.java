package com.newton.code.strings;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverse(s);
        String s1 = "let's go";
        reverse2(s1);
    }

    private static char[] reverse(char[] s) {
        int j = s.length - 1;
        for (int i = 0; i < s.length; i++) {
            if (i <= j) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                j--;
            }
        }
        return s;
    }

    private static String reverse2(String s) {
        StringBuffer bf = new StringBuffer();
        String[] s1 = s.split(" ");

        for (String s2 : s1) {
            char[] bytes = s2.toCharArray();
            int j = bytes.length - 1;

            for (int i = 0; i < bytes.length / 2; i++) {
                if (i <= j) {
                    char temp = bytes[i];
                    bytes[i] = bytes[j];
                    bytes[j] = temp;
                    j--;
                }
            }

            for (char aByte : bytes) {
                bf.append(aByte);
            }
            bf.append(" ");
        }
        return bf.toString().trim();
    }
}
