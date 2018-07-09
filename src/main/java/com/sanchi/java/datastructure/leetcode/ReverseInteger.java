package com.sanchi.java.datastructure.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1: Input: 123 Output: 321
 *
 * Example 2: Input: -123 Output: -321
 */
public class ReverseInteger {

  public static void main(String[] args) {
    System.out.println("123 - " + reverseInteger(123));
    System.out.println("-123 - " + reverseInteger(-123));
    System.out.println("120 - " + reverseInteger(120));
  }

  public static int reverseInteger(int origValue){

    int value = origValue;
    int reverseValue = 0;

    while(value != 0){
      int lastDigit = value%10;
      value = value/10;
      reverseValue = (reverseValue * 10) + lastDigit;
    }

    return reverseValue;
  }

}
