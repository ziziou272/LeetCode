package Special1;

import java.util.HashMap;

public class LRUCache {
    private int cap;
    private HashMap<Integer, ListNode> myMap;
    private ListNode dummyHead;
    private ListNode dummyTail;

    private class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode prev;
        ListNode(){

        }
        ListNode(int key, int value){
            this.key = key;
            this.val = value;
        }
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.myMap = new HashMap<>();
        dummyHead = new ListNode();
        dummyTail = new ListNode();
        dummyTail.prev = dummyHead;
        dummyHead.next = dummyTail;
    }
    private void removeNode(ListNode cur){
        //not necessary去区分头尾中间
        //remove head
        /*if(cur.prev == dummyHead){
            dummyHead.next = dummyHead.next.next;
            dummyHead.next.prev = dummyHead;
            cur.next = null;
            cur.prev = null;
        }
        //remove tail
        else if(cur.next == dummyTail){
            cur.prev.next = dummyTail;
            dummyTail.prev = cur.prev;
        }*/
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            cur.next = null;
            cur.prev = null;
           // System.gc();
    }

    private void addNode(ListNode cur){//always add to tail
        cur.next = dummyTail;
        cur.prev =dummyTail.prev;
        dummyTail.prev.next = cur;
        dummyTail.prev = cur;
    }

    public int get(int key) {
        if(myMap.containsKey(key)){
            //update order
            ListNode cur = myMap.get(key);
            //remove cur
            removeNode(cur);
            //add to tail
            addNode(cur);
            //update hashMap no need to
            //myMap.remove(key);
            //myMap.put(key,cur);
            return cur.val;
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        //if in the cache
        if(get(key) != -1){
            dummyTail.prev.val = value;
        }
        else{
            //if it is full
            if(myMap.size() == cap){
                //remove head
                myMap.remove(dummyHead.next.key);
                removeNode(dummyHead.next);
            }
            //add to tail
            ListNode cur = new ListNode(key, value);
            addNode(cur);
            //update HashMap
            myMap.put(key,cur);
        }
    }
}