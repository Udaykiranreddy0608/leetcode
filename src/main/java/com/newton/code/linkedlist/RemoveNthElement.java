package com.newton.code.linkedlist;

public class RemoveNthElement {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        listNode.next = new ListNode(11);
        listNode.next.next = new ListNode(12);
        listNode.next.next.next = new ListNode(13);
        listNode.next.next.next.next = new ListNode(14);
        listNode.next.next.next.next.next = new ListNode(15);
        int removeElement = 4;
        ListNode remove = remove(listNode, removeElement);


        while (remove != null) {
            System.out.print("\t" + remove.val);
            remove = remove.next;
        }


    }

    private static ListNode remove(ListNode head, int n) {
        ListNode tempNode = head;
        ListNode first = tempNode;
        ListNode second = tempNode;

        int cnt = 1;
        int cnt2 = 1;
        while (second.next != null && (second.next.next != null)) {
            first = first.next;
            second = second.next.next;
            cnt2++;
            cnt = cnt + 2;
        }

        if (second.next != null) {
            cnt++;
        }

        //null check
        if (tempNode == null) {
            return tempNode;
        }
        // 3 - 3
        if (cnt == n) {
            return tempNode.next;
        }

        // 5      10-3 7
        int ck = cnt - n;
        if (cnt2 <= ck) {
            while (first.next != null) {
                if (cnt2 == ck - 1) {
                    if (cnt - cnt2 == 1) {
                        first.next = null;
                    } else if (first.next.next != null) {
                        first.next = first.next.next;
                    }
                    break;
                }
                cnt2++;
            }
        } else {
            // 5 1
            int x = 1;
            while (x <= cnt2) {
                if (x == ck) {
                    if (tempNode.next.next != null) {
                        tempNode.next = tempNode.next.next;
                    }
                    break;
                }
                tempNode = tempNode.next;
                x++;
            }
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLen(head);
        if (len == n) {
            return head.next;
        }
        ListNode temp = head;
        int i = 0;
        while (temp != null) {
            if (len - i - 1 == n) {
                if (temp.next.next != null) {
                    temp.next = temp.next.next;
                } else {
                    temp.next = null;
                }
            }
            temp = temp.next;
            i++;
        }
        return head;
    }

    public int getLen(ListNode head) {
        int t = 0;
        while (head != null) {
            t++;
            head = head.next;
        }
        return t;
    }
}

