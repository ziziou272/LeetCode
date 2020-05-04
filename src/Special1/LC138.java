package Special1;

import java.util.HashMap;

public class LC138 {

// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

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
