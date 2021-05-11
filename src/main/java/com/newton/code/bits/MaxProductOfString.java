package com.newton.code.bits;

import java.io.UnsupportedEncodingException;

public class MaxProductOfString {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String[] strs = {"ab", "ab","abc","def"};
        System.out.println(maxProductOfString(strs));
    }

    private static int maxProductOfString(String[] words) throws UnsupportedEncodingException {
        int[] vals = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (int i1 = 0; i1 < words[i].length(); i1++) {
                val |= 1 << (words[i].charAt(i1) - 'a');
            }
            vals[i] = val;
        }

        int max = 0;
        for (int i = 0; i < vals.length; i++) {
            for(int j = i +1;j<vals.length;j++ ){
                if((vals[i] & vals[j]) == 0){
                    max = Math.max(max,words[i].length()  * words[j].length());
                }
            }
        }
        return max;
    }

}
