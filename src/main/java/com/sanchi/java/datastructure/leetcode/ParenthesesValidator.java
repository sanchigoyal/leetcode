package com.sanchi.java.datastructure.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ParenthesesValidator {

  public static void main(String[] args) {
    String[] parenthesesStrings = {"}[{([]{})}]", "[{([]{})}]", "[{([]{})}]{",
        ""};

    for (String string : parenthesesStrings) {
      System.out.println(
          "Parentheses input - " + string + " is valid " + isValidParentheses(
              string));
    }
  }

  public static boolean isValidParentheses(String parenthesesString) {

    /*
     * case : when null, return false;
     */
    if (parenthesesString == null) {
      return false;
    }

    /*
     * case : when empty, return true;
     */
    if (parenthesesString.isEmpty()) {
      return true;
    }

    HashMap<Character, Character> parenthesesSet = new HashMap<>();
    parenthesesSet.put('{', '}');
    parenthesesSet.put('[', ']');
    parenthesesSet.put('(', ')');

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < parenthesesString.length(); i++) {
      char c = parenthesesString.charAt(i);
      if (parenthesesSet.keySet().contains(c)) {
        // which means its a opening bracket
        stack.push(c);
      } else {
        // which means its a closing bracket
        if (!stack.isEmpty() && parenthesesSet.get(stack.peek()) == c) {
          stack.pop();
        } else {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
