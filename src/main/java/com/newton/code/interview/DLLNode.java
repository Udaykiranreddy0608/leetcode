package com.newton.code.interview;

public class DLLNode {
  int key;
  int val;
  DLLNode prev;
  DLLNode next;
  int frequency;

  DLLNode(int key, int val) {
    this.frequency = 1;
    this.key = key;
    this.val = val;
  }
}
