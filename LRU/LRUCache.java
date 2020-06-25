package LRU;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jintao.bai on 2020/5/25 20:29
 */
public class LRUCache {
    private Map<Integer, LRUNode> map;
    private LRUNode recently;//头结点和尾结点，不保存实际数据
    private LRUNode last;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
        count = 0;
        recently = new LRUNode();
        last = new LRUNode();
        recently.next = last;
        last.pre = recently;
    }

    public int get(int key) {
        LRUNode lruNode = map.get(key);
        if (Objects.isNull(lruNode)) {
            return -1;
        }
        moveToFront(lruNode);
        return lruNode.value;
    }

    //将给定的结点移动到头结点(这个结点是原本就存在链表中的)
    private void moveToFront(LRUNode lruNode) {
        if (recently.next == lruNode) {
            return;
        }
        lruNode.pre.next = lruNode.next;
        lruNode.next.pre = lruNode.pre;
        lruNode.pre = recently;
        lruNode.next = recently.next;
        lruNode.next.pre = lruNode;
        recently.next = lruNode;
    }

    public void put(int key, int value) {
        LRUNode node = map.get(key);
        if (Objects.nonNull(node)) {
            node.setValue(value);
            moveToFront(node);
        } else {
            LRUNode aNode = new LRUNode(key, value);
            map.put(key, aNode);
            addToFront(aNode);
            ++count;
            if (count > capacity) {
                LRUNode lastNode = removeLast();
                map.remove(lastNode.key);
                --count;
            }
        }


    }

    //移除最后一个结点并返回
    private LRUNode removeLast() {
        LRUNode node = last.pre;
        node.next = null;
        last.pre = node.pre;
        node.pre = null;
        return node;
    }

    //将一个新的结点加入到头结点
    private void addToFront(LRUNode aNode) {
        aNode.pre = recently;
        aNode.next = recently.next;
        aNode.next.pre = aNode;
        recently.next = aNode;
    }

    private class LRUNode {
        private int value;
        private int key;
        private LRUNode pre;
        private LRUNode next;

        public LRUNode() {
        }

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LRUNode lruNode = (LRUNode) o;
            return value == lruNode.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
