package com.newton.code.trees;

public class TestSameTree {

  public static void main(String[] args) {

    TreeNode node1 = new TreeNode(1);
    node1.left = new TreeNode(2);
    node1.right = new TreeNode(3);

    TreeNode node2 = new TreeNode(1);
    node2.left = new TreeNode(2);
    node2.right = new TreeNode(4);

    System.out.println(checkSameTree(node1, node2));
  }

  private static boolean checkSameTree(TreeNode node1, TreeNode node2) {

    if (node1 == null && node2 == null) {
      return true;
    }

    if (node1 == null || node2 == null) {
      return false;
    }

    if (node1.val != node2.val) {
      return false;
    }

    return checkSameTree(node1.left, node2.left) && checkSameTree(node1.right, node2.right);
  }

}
