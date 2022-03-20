package com.newton.code.linkedlist;

public class IntersectionPoint {
    public static void main(String[] args) {
        //listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(8);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(1);
        listNode2.next.next.next = listNode.next.next;


//    listNode2.next.next.next = new ListNode(8);
//    listNode2.next.next.next.next = new ListNode(4);
//    listNode2.next.next.next.next.next = new ListNode(5);

        printListNode(listNode);
        System.out.println();
        printListNode(listNode2);

        final ListNode intersectionNode = getIntersectionNode(listNode, listNode2);
        System.out.println("intersectionNode : " + intersectionNode.data);

    }

    private static void printListNode(ListNode listNode) {

        while (listNode != null) {
            System.out.printf("\t " + listNode.data);
            listNode = listNode.next;
        }
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int len1 = getCount(headA);
        int len2 = getCount(headB);


        System.out.println("Len1 : " + len1 + "\t len2 : " + len2);
        int diff = 0;
        if (len1 > len2) {
            diff = len1 - len2;
            return getINode(diff, headA, headB);
        } else {
            diff = len2 - len1;
            return getINode(diff, headB, headA);
        }
    }

    private static ListNode getINode(int diff, ListNode headA, ListNode headB) {
        ListNode current1 = headA;
        ListNode current2 = headB;
        for (int i = 0; i < diff; i++) {
            if (current1 == null) {
                return null;
            }
            current1 = current1.next;
        }

        while (current1 != null && current2 != null) {
            if (current1 == current2) {
                return current1;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return null;
    }

    public static int getCount(ListNode node) {
        int cnt = 0;
        ListNode curr = node;
        while (curr != null) {
            cnt++;
            curr = curr.next;
        }

        return cnt;
    }

}
