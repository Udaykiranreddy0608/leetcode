package com.newton.code.strings;

import java.util.HashMap;

public class UniqueCharString {
    public static void main(String[] args) {

        int firstUniqChar = firstUniqChar("loveleetcode");
        System.out.printf("\t" + firstUniqChar);
    }

    public static int firstUniqChar(String s) {

        HashMap<Character, Integer> stringHashMap = new HashMap<Character, Integer>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            stringHashMap.put(c, stringHashMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < length; i++) {
            if (stringHashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
