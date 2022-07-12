package com.newton.code.linkedlist;

public class FindInterSection {

    public static void main(String[] args) {

        int[] ints = {3, 2, 4, 5, 7, 9, 1, 0};
        ListNode listNode1 = ListNode.createLinkedList(ints);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(0);
        listNode2.next.next.next = new ListNode(10);

        System.out.println(isInterSected(listNode1, listNode2));
    }

    static boolean isInterSected(ListNode listNode1, ListNode listNode2) {

        // find length for both nodes
        // find diff of length and traverse other node till diff
        // from these if node.next address is equals return true

        int len1 = findLength(listNode1);
        int len2 = findLength(listNode2);

        System.out.println("len1 : " + len1);
        System.out.println("len2 : " + len2);

        int diff = Math.abs(len1 - len2);
        System.out.println("diff : " + diff);

        ListNode l1 = listNode1;
        ListNode l2 = listNode2;


        if (len1 > len2) {
            while (diff != 0) {
                l1 = l1.next;
                diff--;
            }
        } else if (len2 > len1) {
            while (diff != 0) {
                l2 = l2.next;
                diff--;
            }
        }

        System.out.println(l1.val + "\t" + l2.val);

        while (l1.next != null && l2.next != null) {
            if (l1.next == l2.next)
                return true;
            l1 = l1.next;
            l2 = l2.next;
        }


        return false;
    }

    private static int findLength(ListNode listNode1) {
        int cnt = 0;
        ListNode current = listNode1;
        while (current.next != null) {
            cnt++;
            current = current.next;
        }

        return cnt;
    }
}
