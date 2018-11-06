package com.sanchi.java.datastructure.leetcode;

import java.util.HashSet;

public class SetMatrixZeroes {

  public static void main(String[] args) {

    int[][] matrix = {
        {1, 0, 3, 4},
        {1, 3, 4, 5},
        {2, 6, 0, 8}
    };

    for(int i =0; i< matrix.length; i++){
      for(int j=0; j<matrix[i].length; j++){
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }

    setMatrixZeroes(matrix);
    System.out.println("-------------------------");

    for(int i =0; i< matrix.length; i++){
      for(int j=0; j<matrix[i].length; j++){
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }
  }

  public static void setMatrixZeroes(int[][] input){
    HashSet<Integer> zeroRows = new HashSet<>();
    HashSet<Integer> zeroColumns = new HashSet<>();

    if(input == null){
      return;
    }

    for(int i =0; i< input.length; i++){
      for(int j=0; j<input[i].length; j++){
        if(input[i][j] == 0){
          zeroRows.add(i);
          zeroColumns.add(j);
        }
      }
    }

    for(int i =0; i< input.length; i++){
      for(int j=0; j<input[i].length; j++){
        if(zeroRows.contains(i) || zeroColumns.contains(j)){
          input[i][j] = 0;
        }
      }
    }
  }
}
