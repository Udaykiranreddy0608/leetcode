package com.newton.code;

public class LinkedList {
  static ListNode head;

  static class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
      this.data = data;
      next = null;
    }

  }

  public static void main(String[] args) {

    LinkedList linkedList = new LinkedList();
    linkedList.head = new ListNode(12);
    linkedList.head.next = new ListNode(21);
    linkedList.head.next.next = new ListNode(43);
    linkedList.head.next.next.next = new ListNode(64);
    System.out.println("Given linked list .....");
    linkedList.print(head);
    System.out.println("\nReverse a linked list");
    head = linkedList.reverseLinkedList(head);
    System.out.println("\nPrint reversed linked list");
    linkedList.print(head);

  }

  public ListNode reverseLinkedList(ListNode listNode) {
    ListNode prev = null;
    ListNode current = listNode;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    listNode = prev;
    return listNode;
  }

  public void print(ListNode listNode) {
    while (listNode != null) {
      System.out.print(listNode.data + " ");
      listNode = listNode.next;
    }
  }

}
