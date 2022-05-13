package com.newton.code.linkedlist;

public class RemoveNumber {
  public static void main(String[] args) {

    removeElements(ListNode.createLinkedList(new int[]{6, 6, 6, 6, 6, 6, 6, 1}), 6);
  }

  public static ListNode removeElements(ListNode head, int val) {

    ListNode temp = head;

    while (temp != null && temp.val == val) {
      temp = temp.next;
    }
    if (temp == null) {
      return null;
    }

    ListNode p1 = temp;
    ListNode p2 = temp.next;

    //{1, 3, 4,7, 8, 6}
    while (p2 != null) {

      if (p2.val == val) {
        p1.next = p2.next;
        p2 = p2.next;
      } else {
        p2 = p2.next;
        p1 = p1.next;
      }
    }

    ListNode.printNode(temp);
    return temp;
  }
}
