package com.sanchi.java.datastructure.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class TwoSum {

  /**
   * Solutions: 1. Brute-force method - iterate over every element and find an
   * element which is target - i. Time complexity - O(n^2), Space complexity -
   * O(1)
   *
   * 2. Two pass solution - iterate over every element and save it in a map as
   * (value, index). Now, iterate over every element again and look for target
   * -i in the map keys. If found return the indexes. Time complexity - O(2n) =
   * O(n), Space complexity - O(n)
   *
   * 3. One pass solution - iterate over every element and do a) save the value
   * in the map as (value, index) b) look for target -i in the map keys. Time
   * complexity - O(n), Space complexity - O(n)
   */

  public static void main(String[] args) {

    int data[] = {2, 7, 11, 15};
    int target = 9;

    int[] indexes = getTwoSumIndexes(data, target);
    System.out.println("Indexes are - " + Arrays.toString(indexes));
  }

  /**
   * Return the indexes of the elements that sums up to the target.
   */
  public static int[] getTwoSumIndexes(int[] data, int target) {

    if (data == null || data.length == 0) {
      throw new IllegalArgumentException("Data array is null or empty");
    }

    HashMap<Integer, Integer> dataMap = new HashMap<>();
    for (int i = 0; i < data.length; i++) {

      int complement = target - data[i];
      if (dataMap.keySet().contains(complement)) {
        return new int[]{dataMap.get(complement), i};
      } else {
        dataMap.put(data[i], i);
      }
    }

    throw new IllegalArgumentException("No two sum solution found");
  }

}
