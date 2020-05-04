package Special1;

import com.main.Node;

import java.util.ArrayList;
import java.util.List;

public class LC138NoHashMap {
    public Node copyRandomList(Node head) {
        //corner case
        if(head == null) return null;
        Node cur = head;
        Node newHead = null;
        Node curCopy = null;
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
