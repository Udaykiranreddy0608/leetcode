package com.newton.code.linkedlist;

public class ReverseLinkedList {
  static ListNode head;

  public static void main(String[] args) {

    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    head = new ListNode(3);
    head.next = new ListNode(4);
    head.next.next = new ListNode(5);
    head.next.next.next = new ListNode(7);
    head.next.next.next.next = new ListNode(8);
    head.next.next.next.next.next = new ListNode(9);
    System.out.println("Given linked list .....");
    reverseLinkedList.print(head);
    System.out.println("\nReverse a linked list");
    head = reverseLinkedList.reverseLinkedList(head);
    System.out.println("\nPrint reversed linked list");
    reverseLinkedList.print(head);
  }

  /**
   * 3 4 5 7 8 9 9 8 7 5 4 3
   * <p>
   * next           4 current.next   n prev           3 current        4
   * <p>
   * 4 3 5 7 8 9
   * <p>
   * next - 5
   * <p>
   * current 4 3 7 8 9 5 current
   *
   * @param head
   * @return
   */
  public ListNode reverseLinkedList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    ListNode next = null;
//3 4 5 7 8 9
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  public void print(ListNode listNode) {
    while (listNode != null) {
      System.out.print(listNode.data + " ");
      listNode = listNode.next;
    }
  }
}
