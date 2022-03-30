package com.newton.code.trees;

public class SymmetricTree {
  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(2);

    node.left.left = new Node(3);
    node.left.right = new Node(4);

    node.right.left = new Node(3);
    node.right.right = new Node(4);

    isSymmetric(node);
  }

  public static boolean isSymmetric(Node root) {
    return compare(root.left, root.right);
  }

  public static boolean compare(Node p, Node q) {

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
