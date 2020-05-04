package Special1;

import com.main.Node;

import java.util.HashMap;

public class LC1380Jan31 {
    public Node copyRandomList(Node head) {
        //corner case
        if(head == null) return null;
        Node cur = head;
        Node newHead = null;
        Node curCopy = null;
        //old node   new node
        HashMap<Node, Node> map = new HashMap<>();
        //copy next
        while(cur != null){
            if(curCopy == null){
                curCopy = new Node(cur.val);
                newHead = curCopy;
                map.put(cur, curCopy);
                cur = cur.next;
            }
            else{
                curCopy.next = new Node(cur.val);
                map.put(cur, curCopy.next);
                curCopy = curCopy.next;
                cur = cur.next;
            }
        }
        //copy random
        cur = head;
        curCopy = newHead;
        while(cur != null){
            if(cur.random != null)
                curCopy.random = map.get(cur.random);
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return newHead;
    }

}
