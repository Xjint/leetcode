package LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baijintao
 * @date 2021/11/15 11:40 上午
 */
public class LRU<K, V> {

  public static final int DEFAULT_CAPACITY = 16;

  private int size;//当前大小
  private int capacity;//容量
  //head指向第一个元素，tail指向最后一个元素，初始:head=tail=null
  private Node<K, V> head;
  private Node<K, V> tail;
  private Map<K, Node<K, V>> map;

  public LRU() {
    this(DEFAULT_CAPACITY);
  }

  public LRU(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>(capacity);
  }

  public void put(K key, V value) {
    Node<K, V> node = map.get(key);
    if (node == null) {
      Node<K, V> newNode = new Node<>(key, value);
      map.put(key, newNode);
      size++;
      addToHead(newNode);
      if (size > capacity) {
        removeOldest();
        size--;
      }
    } else {
      node.value = value;
      moveToHead(node);
    }
  }

  private void removeOldest() {
    Node<K, V> prev = tail.prev;
    map.remove(prev.k);
    tail = prev;
    tail.next = null;
  }

  private void moveToHead(Node<K, V> node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    addToHead(node);
  }

  private void addToHead(Node<K, V> newHead) {
    if (head == null) {
      head = newHead;
      tail = newHead;
    } else {
      Node<K, V> oldHead = this.head;
      head = newHead;
      newHead.next = oldHead;
      oldHead.prev = newHead;
    }
  }
}


class Node<K, V> {

  K k;
  V value;
  Node<K, V> next;
  Node<K, V> prev;

  Node(K k, V value) {
    this.k = k;
    this.value = value;
  }
}
