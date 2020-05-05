package Special1;

import java.util.HashMap;
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
public class LC138 {

// Definition for a Node.


public Node copyRandomList(Node head) {
    HashMap<Node,Node> map = new HashMap<>();
    Node cur = head;
    //first pass
    while(cur != null){
        if(!map.containsKey(cur)){
            Node curPrime = new Node(cur.val,null,null);
            map.put(cur,curPrime);
        }
        cur = cur.next;
    }
    //second pass deep coy next
    cur = head;
    while (cur != null){
        map.get(cur).next = map.get(cur.next);
        map.get(cur).random = map.get(cur.random);
        cur = cur.next;
    }
    return map.get(head);
}
}
/*
   ------|
9- 1- 6- 3- 7
|     |
------|
1. regular single linkedlist, copy during traverse, keep prev
2. the node random pointer point to may not exsit or copied yet -> 2 traverse first copy next pointer then copy random pointer
3. if  I used a hashMap<old, copied> I could locate each nodes, if the copied nodes is null, creat a new instance of node
otherewise point to it.
*/
class solutionMoreClean{
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> oldToNew = new HashMap<>();
        Node cur = head, prev = null;
        while(cur != null){
            //no old - new mapping
            if(!oldToNew.containsKey(cur)){
                oldToNew.put(cur, new Node(cur.val));
            }
            //copy next pointer
            Node newNode = oldToNew.get(cur);
            if(prev != null){
                oldToNew.get(prev).next = newNode;
            }
            //copy random pointer
            Node oldRandom = cur.random;
            if(oldRandom != null){
                if(!oldToNew.containsKey(oldRandom)){
                    oldToNew.put(oldRandom, new Node(oldRandom.val));
                }
                newNode.random = oldToNew.get(oldRandom);
            }
            prev = cur;
            cur = cur.next;
        }
        return oldToNew.get(head);
    }
}

/**
 * 4. if we don't use hashMap, we could let the new copied node next to the original node, so that we could locate the new node
 * after the clone is done, we recover the list
 *
 * 9 9' 1 1' 6 6' 3 3' 7 7'
 * first copy next
 * second copy random
 * third recover the list
 */
class noHashMapSolutionLC138{
    public Node copyRandomList(Node head) {
        //corner case
        if(head == null) return null;
        Node cur = head;
        Node newHead;
        Node curCopy;
        //pass one build the relative relations
        while(cur != null){
            curCopy = new Node(cur.val);
            //1 1' 2 insert 1' to 1 and 2
            Node temp = cur.next;
            cur.next = curCopy;
            curCopy.next = temp;
            cur = cur.next.next;
        }
        //pass 2 copy random
        //If we restore the pointers to original, when we deal with random, we can't have the relative positions
        //1 1' 2 2' 3 3' 4 4'
        cur = head;
        while(cur != null){
            if(cur.random != null){
                //copy random
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //pass 3 restore
        cur = head;
        newHead = cur.next;
        while(cur != null){
            Node temp = cur.next;
            cur.next = cur.next.next;
            if(temp.next != null)
                temp.next = cur.next.next;
            cur = cur.next;
        }
        return newHead;
    }
}
