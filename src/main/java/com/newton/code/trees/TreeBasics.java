package com.newton.code.trees;

public class TreeBasics {

  public static void main(String[] args) {
/**
 *          10
 *     5         9
 *   1   2     6  8
 */
    Node node = new Node(10);
    node.left = new Node(5);
    node.right = new Node(15);
    node.right.left = new Node(11);
    node.right.right = new Node(13);
    node.left.right = new Node(8);
    node.left.left = new Node(4);
      /*  node.left.left = new Node(1);
        node.left.right = new Node(2);
        node.right = new Node(9);
        node.right.left = new Node(6);
        node.right.right = new Node(8);*/
    System.out.println("In-Order");
    printNodeInOrder(node);
    System.out.println("\nPre-Order");
    printNodePreOrder(node);
    System.out.println("\nPost-Order");
    printNodePostOrder(node);
  }

  /**
   * in-order : left node right
   *
   * @param node
   */
  public static void printNodeInOrder(Node node) {
    if (node.left != null) {
      printNodeInOrder(node.left);
    }
    System.out.printf("\t" + node.val);
    if (node.right != null) {
      printNodeInOrder(node.right);
    }
  }

  /**
   * pre-order : Node left right
   *
   * @param node
   */
  public static void printNodePreOrder(Node node) {
    System.out.printf("\t" + node.val);
    if (node.left != null) {
      printNodePreOrder(node.left);
    }
    if (node.right != null) {
      printNodePreOrder(node.right);
    }
  }

  /**
   * post-order : left right node
   *
   * @param node
   */
  public static void printNodePostOrder(Node node) {
    if (node.left != null) {
      printNodePostOrder(node.left);
    }
    if (node.right != null) {
      printNodePostOrder(node.right);
    }
    System.out.printf("\t" + node.val);
  }


}
