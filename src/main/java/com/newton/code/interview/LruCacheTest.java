package com.newton.code.interview;

import java.util.HashMap;

public class LruCacheTest {


  int capacity = 10;
  Node head = new Node(0, 0);
  Node tail = new Node(0, 0);
  HashMap<Integer, Node> mem = new HashMap<>();


  LruCacheTest(int capacity) {
    this.capacity = capacity;
    this.head.next = tail;
    this.tail.prev = head;
  }

  public static void main(String[] args) {


    LruCacheTest cache = new LruCacheTest(5);
    cache.put(1, 1001);
    cache.print();
    cache.put(2, 2001);
    cache.put(3, 3001);
    cache.put(4, 4001);
    cache.put(5, 5001);
    cache.put(5, 5002);
    cache.print();
    cache.get(3);
    cache.print();
    cache.get(6);
    cache.print();
    cache.put(7, 7001);
    cache.print();
  }


  Integer get(Integer key) {
    if (mem.containsKey(key)) {
      Node node = mem.get(key);
      remove(node);
      insert(node);
      return node.value;
    }
    return -1;
  }

  void put(Integer key, Integer val) {

    if (mem.containsKey(key)) {
      Node node = mem.get(key);
      remove(node);
    }
    insert(new Node(key, val));
  }

  void insert(Node node) {
    mem.put(node.key, node);

    Node headNext = head.next;

    node.next = headNext;
    headNext.prev = node;
    node.prev = head;
    head.next = node;
  }

  void remove(Node node) {
    mem.remove(node.key);
    Node nodeNext = node.next;
    node.prev.next = nodeNext;
    nodeNext.prev = node.prev;
  }

  void print() {

    Node current = head;
    System.out.println("********************************");
    while (current != null) {
      System.out.println(current.key + "\t" + current.value);
      current = current.next;
    }
    System.out.println("********************************");
  }


}
