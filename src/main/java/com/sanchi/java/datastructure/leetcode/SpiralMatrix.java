package com.sanchi.java.datastructure.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 *
 * Example 1:
 */

/* Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };

    List<Integer> spiralMatrix = convert(matrix);
    System.out.println(Arrays.asList(spiralMatrix));
  }

  public static List<Integer> convert(int[][] matrix) {
    List<Integer> spiralMatrix = new ArrayList<>();

    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return spiralMatrix;
    }

    int rows = matrix.length;
    int columns = matrix[0].length;
    int x = 0;
    int y = 0;

    while (rows > 0 && columns > 0) {

      if (rows == 1) {
        for (int i = 0; i < columns; i++) {
          spiralMatrix.add(matrix[x][y++]);
        }
        break;
      } else if (columns == 1) {
        for (int i = 0; i < rows; i++) {
          spiralMatrix.add(matrix[x++][y]);
        }

        break;
      }

      // move right
      for (int i = 0; i < columns - 1; i++) {
        spiralMatrix.add(matrix[x][y++]);
      }

      // move  down
      for (int i = 0; i < rows - 1; i++) {
        spiralMatrix.add(matrix[x++][y]);
      }

      // move left
      for (int i = 0; i < columns - 1; i++) {
        spiralMatrix.add(matrix[x][y--]);
      }

      // move up
      for (int i = 0; i < rows - 1; i++) {
        spiralMatrix.add(matrix[x--][y]);
      }

      x++;
      y++;
      rows = rows - 2;
      columns = columns - 2;
    }

    return spiralMatrix;
  }
}