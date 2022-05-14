package com.newton.code.trees;

public class BalancedTree {
    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(4);
        node.right.right = new Node(5);
        System.out.printf("isBalanced : " + isBalanced(node));

    }

    public static boolean isBalanced(Node root) {

        if (root != null) {
            if (root.left != null && root.right == null) {
                return false;
            }
            if (root.left == null && root.right != null) {
                return false;
            }
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
