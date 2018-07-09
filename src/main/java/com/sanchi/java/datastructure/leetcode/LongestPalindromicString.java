package com.sanchi.java.datastructure.leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 *
 * Example 1: Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 *
 * Example 2: Input: "cbbd" Output: "bb"
 */
public class LongestPalindromicString {

  public static void main(String[] args) {
    System.out.println(
        "Longest palindrome in 'cbbd' is " + getLongestPalindromicSubstring(
            "cbbd"));
    System.out.println(
        "Longest palindrome in 'babad' is " + getLongestPalindromicSubstring(
            "babad"));
  }


  public static String getLongestPalindromicSubstring(String value) {

    if (value == null || value.isEmpty()) {
      return value;
    }

    int maxLength = 1;
    String longestPalindrome = "" + value.charAt(0);
    int length = value.length();
    for (int i = 1; i < length; i++) {

      // even check
      MatchResult evenResult = getMaxMatch(value,length, i-1, i);
      if(evenResult.length > maxLength){
        longestPalindrome = evenResult.value;
      }

      // odd check
      MatchResult oddResult = getMaxMatch(value,length, i-1, i+1);
      if(oddResult.length > maxLength){
        longestPalindrome = oddResult.value;
      }
    }

    return longestPalindrome;
  }

  private static MatchResult getMaxMatch(String value, int length, int low, int high){
    while (low >= 0 && high < length
        && value.charAt(low) == value.charAt(high)) {
      low--;
      high++;
    }

    // once it has stopped matching, save the data.
    int matchLength = (high - 1 - (low + 1) + 1);
    String matchString = value.substring(low + 1, high);
    return new MatchResult(matchLength, matchString);
  }

  static class MatchResult {
    private int length;
    private String value;

    public MatchResult(int length, String value){
      this.length = length;
      this.value = value;
    }
  }
}
