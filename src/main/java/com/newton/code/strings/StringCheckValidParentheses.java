package com.newton.code.strings;

public class StringCheckValidParentheses {
    public static void main(String[] args) {
        // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if
        // the input string is valid.
        //
        // An input string is valid if:
        //
        // Open brackets must be closed by the same type of brackets.
        // Open brackets must be closed in the correct order.

        boolean status = checkValidParentheses("({[[({}()[])]]})");
        System.out.println("Is perfect parentheses :" + status);
    }

    private static boolean checkValidParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        if (s.length() == 0) return true;
        if (s.length() == 1) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                sb.append(s.charAt(i));
            } else if (sb.length() < 1) return false;
            switch (s.charAt(i)) {
                case ')':
                    if (sb.charAt(sb.length() - 1) == '(') sb.deleteCharAt(sb.length() - 1);
                    else return false;
                    break;
                case '}':
                    if (sb.charAt(sb.length() - 1) == '{') sb.deleteCharAt(sb.length() - 1);
                    else return false;
                    break;
                case ']':
                    if (sb.charAt(sb.length() - 1) == '[') sb.deleteCharAt(sb.length() - 1);
                    else return false;
                    break;
            }
        }
        return sb.length() == 0;
    }
}
