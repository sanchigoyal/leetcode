package com.sanchi.java.datastructure.leetcode;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
 */
public class PalindromeLinkedList {

  public static void main(String[] args) {

    Node oNode1 = new Node(1, null);// last
    Node oNode2 = new Node(2, oNode1);
    Node oNode3 = new Node(3, oNode2);
    Node oNode4 = new Node(3, oNode3);
    Node oNode5 = new Node(1, oNode4);//first

    Node node1 = new Node(1, null);// last
    Node node2 = new Node(2, node1);
    Node node3 = new Node(3, node2);
    Node node4 = new Node(3, node3);
    Node node5 = new Node(2, node4);
    Node node6 = new Node(1, node5);//first

    System.out.println("Even test - [palindrome=" + isPalindrome(node6)+"]");
    System.out.println("Odd test - [palindrome=" + isPalindrome(oNode5)+"]");
  }

  public static boolean isPalindrome(Node list){

    if(list == null){
      return false;
    }

    Stack<Integer> stack = new Stack<>();
    Node current = list;
    Node runner = list;

    /*
     * Reach to the center.
     * if even then runner = null
     * if odd then runner.next = null
     */
    while(runner != null && runner.next != null){
      stack.push(current.value);
      current = current.next;
      runner = runner.next.next;
    }

    // for odd case, move to the other side first.
    if(runner != null && runner.next == null){
      current = current.next;
    }

    while(current != null){
      int stackValue = stack.pop();
      if(current.value != stackValue){
        return false;
      }
      current = current.next;
    }

    return true;
  }

  static class Node{
    private int value;
    private Node next;

    public Node(int value){
      this.value = value;
    }

    public Node(int value, Node next){
      this.value = value;
      this.next = next;
    }
  }
}
