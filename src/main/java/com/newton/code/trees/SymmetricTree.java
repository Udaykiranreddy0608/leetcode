package com.newton.code.trees;

public class SymmetricTree {
  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(2);
    treeNode.right = new TreeNode(2);

    treeNode.left.left = new TreeNode(3);
    treeNode.left.right = new TreeNode(4);

    treeNode.right.left = new TreeNode(3);
    treeNode.right.right = new TreeNode(4);

    isSymmetric(treeNode);
  }

  public static boolean isSymmetric(TreeNode root) {
    return compare(root.left, root.right);
  }

  public static boolean compare(TreeNode p, TreeNode q) {

    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }
    return compare(p.left, q.right) && compare(p.right, q.left);
  }


}
