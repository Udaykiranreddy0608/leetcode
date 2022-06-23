package com.newton.code.trees;

public class SameNode {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(4);

        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(3);

        boolean sameNode = isSameNode(node, node2);
        System.out.printf("is Same node : " + sameNode);

    }

    private static boolean isSameNode(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameNode(p.left, q.left) && isSameNode(p.right, q.right);
    }
}
