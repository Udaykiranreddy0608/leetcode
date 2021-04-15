package com.newton.code.strings;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
  public static void main(String[] args) {
    // Given a string s, find the length of the longest substring without repeating characters.
    //
    //
    //
    // Example 1:
    //
    // Input: s = "abcabcbb"
    // Output: 3
    // Explanation: The answer is "abc", with the length of 3.
    // Example 2:
    //
    // Input: s = "bbbbb"
    // Output: 1
    // Explanation: The answer is "b", with the length of 1.
    // Example 3:
    //
    // Input: s = "pwwkew"
    // Output: 3
    // Explanation: The answer is "wke", with the length of 3.
    // Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    // Example 4:
    //
    // Input: s = ""
    // Output: 0
    //
    //
    // Constraints:
    //
    // 0 <= s.length <= 5 * 104
    // s consists of English letters, digits, symbols and spaces.

    int length = lengthOfLongestSubstring("123451");
    System.out.println("Length of longest substring is :" + length);
  }

  private static int lengthOfLongestSubstring(String s) {
     Set<Character> seen = new HashSet<>();

    int max = 0;
    int i = 0;

    for (int j = 0; j < s.length(); j++) {
      // Get the first chat of string
      char c = s.charAt(j);
      while (seen.contains(c)) {
        seen.remove(s.charAt(i++));
      }
      seen.add(c);
      max = Math.max(max, j - i + 1);
    }
    return max;
  }
}
