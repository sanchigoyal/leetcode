package com.sanchi.java.datastructure.leetcode;

public class NumberToShort {

  public static void main(String[] args) {
    System.out.println("1234 convert to "+toShort(1234));
    System.out.println("124 convert to "+toShort(124));
    System.out.println("34500000 convert to "+toShort(34500000));
    System.out.println("256000000 convert to "+toShort(256000000));
  }

  public static String toShort(long number){

    long[] dividers = {1000000000, 1000000, 1000};
    String[] suffixes = {"B", "M", "K"};

    for(int i = 0 ; i < 3; i ++){

      if((number/dividers[i]) > 0){
        StringBuilder builder = new StringBuilder();
        double shortValue = (double)number/dividers[i];
        builder.append(shortValue);
        builder.append(suffixes[i]);
        return builder.toString();
      }
    }

    return "" + number;
  }
}
