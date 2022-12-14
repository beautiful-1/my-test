package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LZN
 * @Title LRU
 * @ProjectName pattern
 * @Description
 * @date 2022-10-17 15:52
 **/
public class LRU {
    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    int size;
    int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }
}
