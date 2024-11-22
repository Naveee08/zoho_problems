class Node {
    int key;
    int val;
    Node prev;
    Node next;
    
    Node() {
    }

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    static void connect(Node first, Node second) {
        first.next = second;
        second.prev = first;
    }
    
}

class LRUCache {
    
    int capacity;
    int size = 0;
    Node[] store = new Node[10001];
    Node head = new Node();
    Node tail = head;
    
    
    LRUCache(int capacity) {
        this.capacity = capacity;
        tail = head;
    }
    
    public int get(int key) {
        Node n = store[key];
        if (n == null)
            return -1;
        if (n != tail) {
            Node.connect(n.prev, n.next);
            Node.connect(tail, n);
            tail = n;
        }
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = store[key];
        if (n != null ) {
            if (n != tail) {
                Node.connect(n.prev, n.next);
                Node.connect(tail, n);
                tail = n;
            }
            n.val = value;
        }
        else {
            n = new Node(key, value);
            store[key] = n;
                
            
            Node.connect(tail, n);
            tail = n;
            if (capacity == 0) {
                Node oldest = head.next;
                Node.connect(head, oldest.next);
                store[oldest.key]=null;
            }
            else
                capacity--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
