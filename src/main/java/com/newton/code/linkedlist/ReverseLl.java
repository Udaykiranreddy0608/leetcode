package com.newton.code.linkedlist;

public class ReverseLl {
    public static void main(String[] args) {

        int[] ints = {3, 5, 4, 2, 6, 7, 1, 8};
        ListNode listNode = ListNode.createLinkedList(ints);
        ListNode.printNode(listNode);

        ListNode temp = null;
        ListNode current = listNode;
        while (current != null) {
            current.next = temp;
            temp.next =


            current = current.next;
        }


    }
}
