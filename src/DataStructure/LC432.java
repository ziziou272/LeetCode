/*
package DataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC432 {
    */
/** Initialize your data structure here. *//*

    private class node{
        int count;
        node next;
        node pre ;
        HashSet<String>set;
        public node(){
            next = null;
            pre = null;
            set = new HashSet<>();
            count = 0;
        }
    }

    HashMap<Integer, node> countToNode = new HashMap<>();
    HashMap<String, Integer> keyToCount = new HashMap<>();




    public LC432() {
        node head = new node();
        node tail = new node();
        head.next = tail;
        tail.pre = head;
    }

    */
/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. *//*

    public void inc(String key) {
        if(keyToCount.containsKey(key)){
            //get count of the key before insert
            int count = keyToCount.get(key);
            //get count node
            node cur = countToNode.get(count);
            //remove key from previous node
            cur.set.remove(key);
            if(cur.set.isEmpty()){
                //remove node
                removeNode(cur);
                //remove key pair value from hashMap
                countToNode.remove(count);
            }
            //get new node
            node newNode;
            if(countToNode.containsKey(count + 1)){
                newNode = countToNode.get(count + 1);
                newNode.set.add(key);
            }
            else{
                newNode = insertNode(cur, cur.next);
                //count set to 1?
                //put it new key to node into hashMap
                keyToCount.put(key,newNode.count);
            }
        }
        else{

        }
    }


    private node insertNode(node left, node right){
        node newNode = new node();
        if(left != null && right != null){
            newNode.next = right;
            newNode.pre = left;
            right.pre = newNode;
            left.next = newNode;
        }
        else if(left == null && right ==null){
            return newNode;
        }
        else if(right == null){
            newNode.pre = left;
            left.next = newNode;
        }
        else {
            newNode.next = right;
            right.pre = newNode;
        }
        return newNode;
    }

    private void removeNode(node cur){
        node pre = cur.pre;
        if(cur.pre != null)
            cur.pre.next = cur.next;
        if(cur.next != null)
            cur.next.pre = pre;
        cur.pre = null;
        cur.next = null;
    }

    */
/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. *//*

    public void dec(String key) {
        if(keyToCount.containsKey(key)){
            int count = keyToCount.get(key);

        }


    }

    */
/** Returns one of the keys with maximal value. *//*

    public String getMaxKey() {

    }

    */
/** Returns one of the keys with Minimal value. *//*

    public String getMinKey() {

    }
}

*/
