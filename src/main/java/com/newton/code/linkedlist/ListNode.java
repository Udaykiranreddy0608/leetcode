package com.newton.code.linkedlist;

public class ListNode {
  int val;
  ListNode next;

  ListNode(int data) {
    this.val = data;
    next = null;
  }

  public static ListNode createLinkedList(int[] ints) {
    ListNode listNode = new ListNode(ints[0]);
    ListNode temp = listNode;
    for (int i = 1; i < ints.length; i++) {
      listNode.next = new ListNode(ints[i]);
      listNode = listNode.next;
    }

    return temp;
  }

  public static void printNode(ListNode listNode) {
    while (listNode != null) {
      System.out.printf("\t" + listNode.val);
      listNode = listNode.next;
    }
    System.out.println();
  }
}
