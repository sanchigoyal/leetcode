package com.sanchi.java.datastructure.leetcode;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121 Output: true Example 2:
 *
 * Input: -121 Output: false Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10 Output: false Explanation: Reads 01 from right to left. Therefore
 * it is not a palindrome.
 */
public class PalindromeNumber {

  /**
   * Solution: 1. Reverse the number and compare with original.
   */
  public static void main(String[] args) {
    System.out.println("121 is a palindrome - " + isPalindrome(121));
    System.out.println("-121 is a palindrome - " + isPalindrome(-121));
    System.out.println("10 is a palindrome - " + isPalindrome(10));
  }

  public static boolean isPalindrome(int number) {

    // doing this to adjust to problem statement.
    if (number < 0) {
      return false;
    }

    int reverse = ReverseInteger.reverseInteger(number);

    return reverse == number;
  }
}
