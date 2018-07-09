package com.sanchi.java.datastructure.leetcode;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 *
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively
 */
public class RemoveDuplicatesInSortedArray {

  /*
   * Solution:
   * Since the array is already sorted, we can keep two pointers i and j,
   * where i is the slow-runner while j is the fast-runner. As long as
   * nums[i] = nums[j], we increment j to skip the duplicate.
   *
   */

  public static void main(String[] args) {

    int[] dataSet1 = {1, 1, 2};
    int[] dataSet2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    System.out.println(
        "After removing duplicates[length=" + removeDuplicates(dataSet1)
            + ", value=" + Arrays
            .toString(dataSet1) + "]");
    System.out.println(
        "After removing duplicates[length=" + removeDuplicates(dataSet2)
            + ", value=" + Arrays
            .toString(dataSet2) + "]");

  }

  public static int removeDuplicates(int[] data) {
    if (data == null || data.length == 0) {
      return 0;
    }

    int i = 0;
    for (int j = 1; j < data.length; j++) {
      if (data[i] != data[j]) {
        i++;
        data[i] = data[j];
      }
    }

    return i + 1;
  }

}
