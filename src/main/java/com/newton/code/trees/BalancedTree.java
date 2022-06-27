package com.newton.code.trees;

public class BalancedTree {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        // treeNode.left.right = new TreeNode(2);
        // treeNode.left.left = new TreeNode(2);

        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        treeNode.right.left.left = new TreeNode(4);
        treeNode.right.left.right = new TreeNode(5);
        System.out.printf("isBalanced : " + isBalanced(treeNode));

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int lheight = height(root.left);
        int rheight = height(root.right);
        if (Math.abs(lheight - rheight) > 1) return false;
        System.out.println("Max depth :" + root.val + "\t L height" + lheight + "\t R height" + rheight);
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
