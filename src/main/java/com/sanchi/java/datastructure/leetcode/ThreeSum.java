package com.sanchi.java.datastructure.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of
 * zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4], A solution set is: [ [-1,
 * 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum {

  public static void main(String[] args)
  {
    int[] input = {1, -1, -1, 0, 2, 4};

    List<int[]> result = getThreeSumCombo(input, 0);

    for(int[] arr : result)
    {
      System.out.println("Result - "+Arrays.toString(arr));
    }
  }

  public static List<int[]> getThreeSumCombo(int[] data, int target) {
    List<int[]> result = new ArrayList<>();

    // case 1: handle null and empty scenario.
    if (data == null || data.length == 0) {
      return result;
    }

    /*
     * Sort the array.
     * Reason 1 - Helps to avoid duplicates
     * Reason 2 - Helps to increment and decrement the pointer to find complement.
     * Reason 3 - Reduces the time complexity from O(n^3) to O(n^2)
     */

    Arrays.sort(data);

    for (int i = 0; i < data.length - 3; i++) {

      if (i == 0 || data[i] > data[i - 1]) {
        int start = i + 1;
        int end = data.length -1;
        while (start < end) {
          if (data[i] + data[start] + data[end] == target) {
            result.add(new int[]{data[i], data[start], data[end]});
          }

          if ((data[i] + data[start] + data[end]) < 0) {
            // sum is less than 0 then move right.
            int currentStart = start;
            // skip duplicates on the way.
            while (data[currentStart] == data[start] && start < end) {
              start++;
            }
          } else {
            // sum is greater than 0 then move left.
            int currentEnd = end;
            // skip duplicates on the way.
            while (data[currentEnd] == data[end] && start < end) {
              end--;
            }
          }
        }
      }
    }
    return result;
  }
}
