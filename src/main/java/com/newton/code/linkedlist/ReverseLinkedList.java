package com.newton.code.linkedlist;

public class ReverseLinkedList {
    static ListNode head;

    public static void main(String[] args) {

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.head = new ListNode(12);
        reverseLinkedList.head.next = new ListNode(21);
        reverseLinkedList.head.next.next = new ListNode(43);
        reverseLinkedList.head.next.next.next = new ListNode(64);
        System.out.println("Given linked list .....");
        reverseLinkedList.print(head);
        System.out.println("\nReverse a linked list");
        head = reverseLinkedList.reverseLinkedList(head);
        System.out.println("\nPrint reversed linked list");
        reverseLinkedList.print(head);
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
        return prev;
    }

    public void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.data + " ");
            listNode = listNode.next;
        }
    }
}
