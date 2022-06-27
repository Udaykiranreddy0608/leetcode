package com.newton.code.trees;

public class SameNode {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(4);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);

        boolean sameNode = isSameNode(treeNode, treeNode2);
        System.out.printf("is Same node : " + sameNode);

    }

    private static boolean isSameNode(TreeNode p, TreeNode q) {
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
