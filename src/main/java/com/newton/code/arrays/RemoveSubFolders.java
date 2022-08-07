package com.newton.code.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFolders {
    public static void main(String[] args) {
        String[] folder = {"/a/b/c", "/a/b/ca", "/a/b/d"};
        Arrays.sort(folder);

        for (String s : folder) {
            System.out.println(s);
        }
        System.out.println("-------------------------------");
        List<String> output = removeSubfolders(folder);
        for (String s : output) {
            System.out.println(s);
        }
    }

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        String ref = null;
        List<String> output = new ArrayList<>();
        int length = folder.length;
        for (int i = 0; i < length; i++) {
            String val = folder[i];
            if (val.length() == 0 && val.indexOf(val.length()) == '/') {
                continue;
            }
            if (ref == null) {
                ref = val;
                output.add(ref);
                continue;
            }
            if (val.startsWith(ref) && val.charAt(ref.length()) == '/') {
                continue;
            } else {
                ref = val;
                output.add(ref);
            }
        }
        return output;
    }

}
