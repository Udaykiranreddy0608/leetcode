package com.newton.code.strings;

public class MakeEqual {
    public static void main(String[] args) {
        String[] words = {"abc", "aabc", "bc"};
        System.out.printf("" + makeEqual(words));
    }

    public static boolean makeEqual(String[] words) {
        int[] ints = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                ints[word.charAt(i) - 'a']++;
            }
        }
        for (int anInt : ints) {
            if (anInt % words.length != 0) return false;
        }
        return true;
    }
}
