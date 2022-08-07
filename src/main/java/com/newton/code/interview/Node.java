package com.newton.code.interview;

public class Node {
    Node next;
    Node prev;
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
