package com.newton.code.trees;

public class TreeBasics {

  public static void main(String[] args) {
/**
 *          10
 *     5         9
 *   1   2     6  8
 */
    TreeNode treeNode = new TreeNode(10);
    treeNode.left = new TreeNode(5);
    treeNode.right = new TreeNode(15);
    treeNode.right.left = new TreeNode(11);
    treeNode.right.right = new TreeNode(13);
    treeNode.left.right = new TreeNode(8);
    treeNode.left.left = new TreeNode(4);
      /*  node.left.left = new Node(1);
        node.left.right = new Node(2);
        node.right = new Node(9);
        node.right.left = new Node(6);
        node.right.right = new Node(8);*/
    System.out.println("In-Order");
    printNodeInOrder(treeNode);
    System.out.println("\nPre-Order");
    printNodePreOrder(treeNode);
    System.out.println("\nPost-Order");
    printNodePostOrder(treeNode);
  }

  /**
   * in-order : left node right
   *
   * @param treeNode
   */
  public static void printNodeInOrder(TreeNode treeNode) {
    if (treeNode.left != null) {
      printNodeInOrder(treeNode.left);
    }
    System.out.printf("\t" + treeNode.val);
    if (treeNode.right != null) {
      printNodeInOrder(treeNode.right);
    }
  }

  /**
   * pre-order : Node left right
   *
   * @param treeNode
   */
  public static void printNodePreOrder(TreeNode treeNode) {
    System.out.printf("\t" + treeNode.val);
    if (treeNode.left != null) {
      printNodePreOrder(treeNode.left);
    }
    if (treeNode.right != null) {
      printNodePreOrder(treeNode.right);
    }
  }

  /**
   * post-order : left right node
   *
   * @param treeNode
   */
  public static void printNodePostOrder(TreeNode treeNode) {
    if (treeNode.left != null) {
      printNodePostOrder(treeNode.left);
    }
    if (treeNode.right != null) {
      printNodePostOrder(treeNode.right);
    }
    System.out.printf("\t" + treeNode.val);
  }


}
