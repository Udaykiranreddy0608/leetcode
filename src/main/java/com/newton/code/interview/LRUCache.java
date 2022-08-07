package com.newton.code.interview;

import java.util.HashMap;

public class LRUCache {
    int capacity;

    HashMap<Integer, Node> mem = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put(1, 101);
        cache.put(2, 201);
        cache.print();
        cache.put(3, 301);
        cache.put(4, 401);
        cache.put(5, 501);
        cache.put(6, 601);
        cache.print();
        cache.get(6);
        cache.get(5);
        cache.print();
        cache.get(1);
        cache.put(3, 302);
        cache.print();

    }

    public int put(int key, int value) {
        Node node = new Node(key, value);

        if (mem.containsKey(key)) {
            remove(mem.get(key));
        }
        if (mem.size() >= capacity) {
            remove(tail.prev);
        }
        insert(node);
        return value;
    }

    public int get(int key) {
        if (mem.containsKey(key)) {
            Node node = mem.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void remove(Node node) {
        mem.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        mem.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void print() {
        System.out.println("******************************");
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.key + "\t" + curr.value);
            curr = curr.next;
        }
        System.out.println("******************************");
    }

}
