package com.newton.code.strings;

public class MakeEqual {
    public static void main(String[] args) {
        String[] words = {"abc", "aabc", "bc"};
        // for each and split by .


        // come from the end and combine both
        // declare a string outside
        // concatate the string and use domain[i]

        // add condition that domain[i] == 0
        for (int i = words.length - 1; i >= 0; i--) {
            words[i] = words[i - 1] + "." + words[i];
            System.out.println(words[i - 1]);
        }
    }
}
