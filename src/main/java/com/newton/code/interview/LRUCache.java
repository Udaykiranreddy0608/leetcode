package com.newton.code.interview;

import java.util.HashMap;

public class LRUCache {
  int capacity;

  HashMap<Integer, Node> cache = new HashMap<>();
  Node head = new Node(0, 0);
  Node tail = new Node(0, 0);

  LRUCache(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int put(int key, int value) {
    Node node = new Node(key, value);

    if (cache.containsKey(key)) {
      remove(cache.get(key));
    }
    if (cache.size() >= capacity) {
      remove(tail.prev);
    }
    insert(node);
    return value;
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      remove(node);
      insert(node);
      return node.value;
    } else {
      return -1;
    }
  }

  public void remove(Node node) {
    cache.remove(node.key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public void insert(Node node) {
    cache.put(node.key, node);
    Node headNext = head.next;
    head.next = node;
    node.prev = head;
    node.next = headNext;
    headNext.prev = node;
  }

  public static void main(String[] args) {


    LRUCache lruCache = new LRUCache(5);
    lruCache.put(1, 101);
    lruCache.put(2, 201);
    lruCache.print();
    lruCache.put(3, 301);
    lruCache.put(4, 401);
    lruCache.put(5, 501);
    lruCache.put(6, 601);
    lruCache.print();
    lruCache.get(6);
    lruCache.get(5);
    lruCache.print();
    lruCache.get(1);
    lruCache.put(3, 302);
    lruCache.print();

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
