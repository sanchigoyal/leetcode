package com.sanchi.java.datastructure.leetcode;

public class StringCompressor {

  /*
   * Solutions:
   * 1. String concatenation Time Complexity = N + K2,
   * where N is number of sequence and K is number of character.
   * 2. Builder usage  - Time Complexity = N Space Complexity = 2N (worst case)
   */
  public static void main(String[] args) {
    System.out
        .println("aabccceeeedd compressed to " + compress("aabccceeeedd"));
    System.out
        .println("abcde compressed to " + compress("abcde"));
  }

  public static String compress(String orignal) {

    // case - when null or empty
    if (orignal == null || orignal.isEmpty()) {
      return orignal;
    }

    char prev = orignal.charAt(0);
    int count = 1;
    StringBuilder builder = new StringBuilder();
    for (int i = 1; i < orignal.length(); i++) {

      if (orignal.charAt(i) == prev) {
        count++;
      } else {
        builder.append(prev)
            .append(count);
        // reset
        prev = orignal.charAt(i);
        count = 1;
      }
    }

    String compressed = builder.toString();

    return orignal.length() > compressed.length() ? compressed : orignal;
  }

}
