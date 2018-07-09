package com.sanchi.java.datastructure.leetcode;


import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

  /**
   * Solution: Brute-force - Time complexity=O(n^2). Sliding window - Time
   * complexity=O(2n) = O(n) as in worst case each node is visited twice once by
   * each i and j. Space complexity = O(1) and the HashSet is a character set
   * limited to 256 char.
   */

  public static void main(String[] args) {
    System.out
        .println("abcabcbb - " + getLengthOfNonRepeatingSubstring("abcabcbb"));
    System.out
        .println("bbbbb - " + getLengthOfNonRepeatingSubstring("bbbbb"));
    System.out
        .println("pwwkew - " + getLengthOfNonRepeatingSubstring("pwwkew"));
  }

  public static int getLengthOfNonRepeatingSubstring(String value) {

    if (value == null || value.isEmpty()) {
      return 0;
    }

    HashSet<Character> charSet = new HashSet<>();
    int i = 0, j = 0;
    int length = value.length();
    int maxLength = 0;
    while (i < length && j < length) {
      char first = value.charAt(i);
      char last = value.charAt(j);
      if (!charSet.contains(last)) {
        charSet.add(last);
        j++;
      } else {
        charSet.remove(first);
        maxLength = Math.max(maxLength, j - i);
        i++;
      }
    }

    return maxLength;
  }

}
