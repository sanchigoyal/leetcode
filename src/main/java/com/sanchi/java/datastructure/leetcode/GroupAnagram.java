package com.sanchi.java.datastructure.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 *
 * Output: [["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 */
public class GroupAnagram {

  /*
   * Solutions:
   * 1. Count characters in each element and treat that as a hash. O(n) => O(m*n)
   * 2. Sort characters in each element and treat that as a hash. O(nlog(n)) => O(m*nlog(n))
   *
   */
  public static void main(String[] args) {
    String[] values = {"are", "bat", "ear", "code", "tab", "era"};

    Collection<List<String>> groups = groupAnagrams(values);
    groups
        .stream()
        .forEach(strings -> System.out.println(Arrays.asList(strings)));
  }

  public static Collection<List<String>> groupAnagrams(String[] values) {
    Map<String, List<String>> group = new HashMap<>();

    if (values == null || values.length == 0) {
      return group.values();
    }

    for (String value : values) {

      String hash = getHash(value);

      // when its a first element in the group.
      if (!group.containsKey(hash)) {
        group.put(hash, new ArrayList<>());
      }

      group.get(hash).add(value);
    }

    return group.values();
  }

  /**
   * Method returns a hash representation of the count of characters in the
   * input value delimited by #.
   *
   * For example - abbccc will be #1#2#3#0#0#0#0#0....#0
   */
  public static String getHash(String value) {

    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException(
          "Cannot generate hash for value - " + value);
    }

    int[] count = new int[26];
    Arrays.fill(count, 0);

    for (char c : value.toCharArray()) {
      count[c - 'a']++;
    }

    StringBuilder hashBuilder = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      hashBuilder.append("#");
      hashBuilder.append(count[i]);
    }
    return hashBuilder.toString();
  }
}

