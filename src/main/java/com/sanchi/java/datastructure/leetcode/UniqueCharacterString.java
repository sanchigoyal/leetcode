package com.sanchi.java.datastructure.leetcode;

import java.util.HashSet;

public class UniqueCharacterString {

  /*
   * Ways to solve this problem.
   * 1. Have a set and upload and compare the char in set with the char in string.
   * 		Time complexity - O(N)
   * 		Space complexity - O(1), because it cannot grow more than 256 ASCII characters
   * 2. Have a boolean array of size 256, compare and alter the value
   * 		Time complexity - O(N)
   * 		Space complexity - O(1), because it cannot grow more than 256 ASCII characters
   * 3. Brute-Force method - iterate over every element and compare with every element.
   * 		Time complexity - O(n2)
   * 		Space complexity - O(1)
   */

  public static void main(String[] args) {
    System.out.println(
        "Sanchi has unique character - " + hasUniqueCharacters("Sanchi"));
    System.out.println(
        "Rajat has unique character - " + hasUniqueCharacters("Rajat"));
  }

  public static boolean hasUniqueCharacters(String value) {

    if(value == null || value.isEmpty()){
      return false;
    }

    /*
     * no need to compare because there will be at least one
     * duplicate character.
     */
    if(value.length() > 256){
      return false;
    }

    HashSet<Character> charSet = new HashSet<>();

    // case - ignore case if required
    String valueIgnoredCase = value.toLowerCase();

    for(int i = 0 ; i<valueIgnoredCase.length(); i++){

      char c = valueIgnoredCase.charAt(i);

      if(charSet.contains(c)){
        return false;
      }
      else
      {
        charSet.add(c);
      }
    }

    return true;
  }
}
