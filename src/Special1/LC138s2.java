package Special1;

import java.util.HashMap;

public class LC138s2 {

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
        Node cur1 = head;
        Node cur2 = new Node();
        //one pass
        while(cur1 != null){
            if(!map.containsKey(cur1)){
                map.put(cur1,new Node(cur1.val,null,null));
            }
            cur2.next = map.get(cur1);
            if(cur1.random != null){
                if(!map.containsKey(cur1.random)){
                    map.put(cur1.random, new Node(cur1.random.val,null,null));
                }
                cur2.next.random = map.get(cur1.random);
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return map.get(head);
    }
}
