package com.newton.code.trees;

public class BalancedTree {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        System.out.printf("isBalanced : " + isBalanced(treeNode));

    }

    public static boolean isBalanced(TreeNode root) {

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
