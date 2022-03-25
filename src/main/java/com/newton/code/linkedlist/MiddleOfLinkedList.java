package com.newton.code.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        listNode.next = new ListNode(11);
        listNode.next.next = new ListNode(12);
        listNode.next.next.next = new ListNode(13);

        ListNode listNode1 = middleNode(listNode);

        System.out.println(listNode1.val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode[] l = new ListNode[100];
        int t = 0;
        while (head != null) {
            l[t++] = head;
            head = head.next;
        }
        return l[t / 2];
    }
}
