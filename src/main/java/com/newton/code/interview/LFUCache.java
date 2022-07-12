package com.newton.code.interview;

import java.util.HashMap;


/**
 * LFU cache
 * <p>
 * 1. DLL - key , value , head , tail 2. DLL - size , head , tail
 * <p>
 * <p>
 * Class - capacity , head tail (DLL) , Map <key,refNode> , Map <frequency,DLL>
 */
public class LFUCache {
  HashMap<Integer, DLLNode> cache;
  HashMap<Integer, DoubleLinkedList> freqMem;
  int minFrequency;
  int capacity;

  LFUCache(int capacity) {
    this.capacity = capacity;
    this.minFrequency = 0;

    this.cache = new HashMap<>();
    this.freqMem = new HashMap<>();
  }

  public static void main(String[] args) {

    LFUCache lfuCache = new LFUCache(5);

    lfuCache.print();
    lfuCache.put(1, 101);
    lfuCache.put(2, 201);
    lfuCache.print();
    lfuCache.put(3, 301);
    lfuCache.put(4, 401);
    lfuCache.put(5, 501);
    lfuCache.print();
    lfuCache.get(3);
    lfuCache.print();
    lfuCache.get(4);
    lfuCache.print();
    lfuCache.get(5);
    lfuCache.print();
    lfuCache.put(1, 102);
    lfuCache.get(2);
    lfuCache.print();
    lfuCache.get(2);
    lfuCache.get(2);
    lfuCache.get(2);
    lfuCache.print();

    lfuCache.put(7, 701);

    lfuCache.print();

  }

  private void print() {

    System.out.println("*******************************************");

    freqMem.forEach((k, v) -> {
      int freq = k;

      DLLNode current = v.head.next;
      while (current.next != null) {
        System.out.println(freq + "\t" + current.key + "\t" + current.val + "\t" + current.frequency);
        current = current.next;
      }
    });
    System.out.println("*******************************************");
  }

  private int get(int key) {
    if (cache.containsKey(key)) {
      DLLNode node = cache.get(key);
      updateCache(node);
      return node.val;
    }
    return -1;
  }


  private void put(int key, int val) {

    if (capacity == 0) {
      return;
    }
    if (cache.containsKey(key)) {
      DLLNode node = cache.get(key);
      //remove(node);
      node.val = val;
      updateCache(node);
    } else {
      if (cache.size() >= capacity) {
        DoubleLinkedList doubleLinkedList = freqMem.get(minFrequency);
        cache.remove(doubleLinkedList.tail.prev.key);
        doubleLinkedList.remove(doubleLinkedList.tail.prev);
      }
      this.minFrequency = 1;
      DLLNode node = new DLLNode(key, val);
      DoubleLinkedList doubleLinkedList = freqMem.getOrDefault(1, new DoubleLinkedList());
      doubleLinkedList.insert(node);
      freqMem.put(1, doubleLinkedList);
      cache.put(key, node);
    }
  }

  private void updateCache(DLLNode node) {
    int freq = node.frequency;

    DoubleLinkedList currentList = freqMem.get(freq);
    currentList.remove(node);


    if (freq == minFrequency && currentList.size == 0) {
      minFrequency++;
    }

    node.frequency++;

    DoubleLinkedList doubleLinkedList = freqMem.getOrDefault(node.frequency, new DoubleLinkedList());
    doubleLinkedList.insert(node);

    freqMem.put(node.frequency, doubleLinkedList);


    // r
    // remove if exists in cache
    // remove from freqMem
    // insert into cache
    // insert into DLL
    // update frequency

  }

  private class DoubleLinkedList {
    int size = 0;
    DLLNode head;
    DLLNode tail;

    public DoubleLinkedList() {
      this.head = new DLLNode(0, 0);
      this.tail = new DLLNode(0, 0);

      head.next = tail;
      tail.prev = head;
    }

    void remove(DLLNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      size--;
    }

    void insert(DLLNode node) {
      DLLNode headNext = head.next;
      node.next = headNext;
      headNext.prev = node;
      head.next = node;
      node.prev = head;
      size++;
    }
  }

}




