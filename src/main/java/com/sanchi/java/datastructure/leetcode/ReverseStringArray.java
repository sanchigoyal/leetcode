package com.sanchi.java.datastructure.leetcode;

import java.util.Arrays;

public class ReverseStringArray {

  /**
   * Solutions: 1. start from behind and keep adding the last word to new array
   * and return new array. Time complexity - O(N), Space complexity - O(N)
   *
   * 2. swap first and last elements and keep moving towards the center. Time
   * complexity - O(N/2), Space complexity - O(1)
   */
  public static void main(String[] args) {
    String[] strArray = {"Sanchi", "Rajat", "Derick", "Anita"};

    System.out.println("Original array - " + Arrays.toString(strArray));

    reverse(strArray);

    System.out.println("Reverse array - " + Arrays.toString(strArray));

  }

  public static void reverse(String[] strArray) {
    // case - when input is null or empty.
    if (strArray == null || strArray.length == 0) {
      return;
    }

    for (int i = 0; i < (strArray.length / 2); i++) {
      String temp = strArray[i];
      strArray[i] = strArray[strArray.length - 1 - i];
      strArray[strArray.length - 1 - i] = temp;
    }

  }

}
