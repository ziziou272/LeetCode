package Design;

import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
        LRU cache = new LRU( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

         class ListNode{
            ListNode next;
            ListNode prev;
            int key;
            int val;
            public ListNode(int key, int val){
                this.next = null;
                this.prev = null;
                this.val = val;
                this.key = key;
            }
            public void set(int v) {
                this.val = v;
            }
        }
        private HashMap<Integer,ListNode> map;
        private ListNode head;
        private ListNode tail;
        private int capacity;
        private int size;

        public LRUCache(int capacity) {
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
            size = 0;
            this.map = new HashMap<Integer, ListNode>();
        }

        public int get(int key) {
            //update position
            if(!map.containsKey(key)) return -1;
            int value = map.get(key).val;
            moveToHead(map.get(key));
            return value;
        }
        private void remove(ListNode cur){
            cur.prev.next = tail;
            tail.prev = cur.prev;
            cur.next = null;
            cur.prev = null;
        }
        //insert to behind the head
        private void moveToHead(ListNode cur){
            //has nexts and prevs
            ListNode prev = cur.prev;
            ListNode next = cur.next;
            if(prev != null) prev.next = next;
            if(next != null) next.prev = prev;
            cur.next = head.next;
            head.next = cur;
            cur.prev = head;
            cur.next.prev =cur;
        }

        public void put(int key, int value) {
            //if already in, update position
            if(map.containsKey(key)){
                ListNode curNode = map.get(key);
                //insert
                curNode.set(value);
                moveToHead(curNode);
            }
            //not in checksize
            else{
                //if not full
                if(size < capacity){
                    size++;
                    ListNode newNode = new ListNode(key, value);
                    map.put(key, newNode);
                    moveToHead(newNode);
                }
                else{
                    //full
                    //remove tail
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                    size--;
                    //recall the function
                    put(key, value);
                }
            }
        }
}
class LRU{
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int size;
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRU(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //not in
        if(!map.containsKey(key))
            return -1;
        //in
        Node curNode = map.get(key);
        int val = curNode.val;
        //move to head
        moveToHead(curNode);
        return val;
    }

    public void put(int key, int value) {
        //node not in cache
        if(!map.containsKey(key)){
            size++;
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            //check size
            if(size > capacity){
                //delete least
                map.remove(tail.prev.key);
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
                size--;
            }
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
        }
        //already in cache, move to head
        else{
            Node curNode = map.get(key);
            curNode.val = value;
            moveToHead(curNode);
        }
    }

    private void moveToHead(Node curNode){
        if(curNode.prev != null)
            curNode.prev.next = curNode.next;
        if(curNode.next != null)
            curNode.next.prev = curNode.prev;
        curNode.next = head.next;
        head.next.prev = curNode;
        head.next = curNode;
        curNode.prev = head;
    }
}
