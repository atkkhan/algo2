import java.util.HashMap;
import java.util.Map;

class LruNode {
    int key;
    int value;
    LruNode next = null;
    LruNode prev = null;
    public LruNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public LruNode() {}
}

class LruList {
    private LruNode head = new LruNode();
    private LruNode tail = new LruNode();
    
    LruList() {
        head.next = tail;
        tail.prev = head;
    }
    
    void moveToTail(LruNode node) {
        if (node.prev != null) { // Remove first if node exists in list rather than a new node
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        LruNode last = tail.prev;
        node.next = tail;
        node.prev = last;
        last.next = tail.prev = node;
    }
    
    LruNode removeHead() {
        LruNode first = head.next;
        head.next = first.next;
        first.next.prev = head;
        return first;
    }
}

public class LRUCache {
    private Map<Integer, LruNode> cache = new HashMap<>();
    private LruList list = new LruList();
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        LruNode node = cache.get(key);
        list.moveToTail(node);
        return node.value;
    }
    
    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            LruNode node = cache.get(key);
            node.value = val;
            list.moveToTail(node);
        } else {
            LruNode node = new LruNode(key, val);
            list.moveToTail(node);
            cache.put(key, node);
            if (cache.size() > capacity) {
                cache.remove(list.removeHead().key);
            }
        }
    }
    
    public static void main(String args[]){
    	
    	LRUCache cache = new LRUCache( 2 /* capacity */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	System.out.println(cache.get(2));       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	System.out.println(cache.get(1));       // returns -1 (not found)
    	System.out.println(cache.get(3));       // returns 3
    	System.out.println(cache.get(4));       // returns 4
    }
}