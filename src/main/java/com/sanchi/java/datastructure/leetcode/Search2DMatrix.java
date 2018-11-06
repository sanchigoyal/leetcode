package com.sanchi.java.datastructure.leetcode;

public class Search2DMatrix {

  /*
   * Solutions :
   * This is a typical problem of binary search. You may try to solve this
   * problem by finding the row first and then the column. There is no need to
   * do that. Because of the matrix's special features, the matrix can be
   * considered as a sorted array. Your goal is to find one element in this
   * sorted array by using binary search.
   */
  public static void main(String[] args) {
    int[][] matrix = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };

    int[] coordinates = search(matrix, 34);
    System.out.println(String
        .format("Coordinates of 34 is [%s, %s]", coordinates[0],
            coordinates[1]));
  }


  public static int[] search(int[][] matrix, int target) {

    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      throw new IllegalArgumentException("Invalid inputs");
    }

    int rows = matrix.length;
    int columns = matrix[0].length;
    int start = 0;
    int end = (rows * columns) - 1;

    while (start <= end) {

      // this is the mid considering one single array.
      int mid = (start + end) / 2;
      // this is the count of rows till we reach mid
      int midX = mid / rows;
      // this is remaining elements, which is count of columns
      int midY = mid % rows;

      if (matrix[midX][midY] == target) {
        return new int[]{midX, midY};
      }

      if (matrix[midX][midY] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    throw new ElementNotFoundException("Target=" + target);
  }

  static class ElementNotFoundException extends RuntimeException {

    ElementNotFoundException(String message) {
      super(message);
    }
  }
}
