package com.sanchi.java.datastructure.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 */
public class AddTwoNumbers {

  public static void main(String[] args) {

    /**
     * Solution:
     * Keep track of the carry using a variable and simulate digits-by-digits sum starting from the head of list, which contains the least-significant digit.
     * Time complexity = O(max(n, m))
     * Space complexity = O(max(n, m))
     */

    Node node11 = new Node(1);
    Node node12 = new Node(6, node11);
    Node node13 = new Node(4, node12);
    Node node14 = new Node(7, node13);
    Node node15 = new Node(9, node14);
    Node node16 = new Node(0, node15);

    Node node21 = new Node(5);
    Node node22 = new Node(3, node21);
    Node node23 = new Node(3, node22);
    Node node24 = new Node(6, node23);
    Node node25 = new Node(9, node24);
    Node node26 = new Node(9, node25);

    Node sum = sum(node16, node26);

    while(sum != null){
      System.out.print(sum.value + "->");
      sum = sum.next;
    }
  }

  public static Node sum(Node number1, Node number2) {

    Node dummyHead = new Node(0);
    Node curr = dummyHead;
    int carry = 0;

    while (number1 != null || number2 != null) {

      int digit1 = number1 != null ? number1.value : 0;
      int digit2 = number2 != null ? number2.value : 0;

      int sum = digit1 + digit2 + carry;
      carry = sum / 10;
      sum = sum % 10;

      curr.next = new Node(sum);
      curr = curr.next;

      if (number1 != null) {
        number1 = number1.next;
      }
      if (number2 != null) {
        number2 = number2.next;
      }
    }

    if(carry > 0 ){
      curr.next = new Node(carry);
    }

    return dummyHead.next;
  }

  static class Node {

    private int value;
    private Node next;

    Node(int value) {
      this.value = value;
    }

    Node(int value, Node next){
      this.value = value;
      this.next = next;
    }
  }
}
