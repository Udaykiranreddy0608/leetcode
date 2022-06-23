package com.newton.code.linkedlist;

public class ReverseALinkedList {

    public static void main(String[] args) {
        int[] ints = {3, 5, 7, 8, 9};

        reverseLinkedList(createLinkedList(ints));

    }

    private static void reverseLinkedList(ListNode linkedList) {
        ListNode current = linkedList;
        ListNode prev = null;
        ListNode next = null;
// 3 5 7 8 9
        while (linkedList != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }


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

}
