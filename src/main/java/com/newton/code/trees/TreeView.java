package com.newton.code.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeView {
    static List<Integer> res = new LinkedList<>();

    public static void main(String[] args) {

        /**
         *          5
         *       4      3
         *     2   1  8   9
         */


        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
//        treeNode.left.left = new TreeNode();
//        treeNode.left.right = new TreeNode(1);
        // treeNode.right.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        rightSideView(treeNode);

        System.out.println("*********");
        for (Integer re : res) {
            System.out.println(re);
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return res;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            for (int i = 0; i < queue.size(); i++) {

                if (res.size() < level) {
                    res.add(node.val);
                }
                queue.add(node.right);
                queue.add(node.left);
            }
            level++;
        }

        return res;
    }

    public static List<Integer> leftSideView(TreeNode root) {
        if (root == null) return res;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            for (int i = 0; i < queue.size(); i++) {

                if (res.size() < level) {
                    res.add(node.val);
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            level++;
        }

        return res;
    }
}
