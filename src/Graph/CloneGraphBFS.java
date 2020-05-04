package Graph;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraphBFS {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        queue.offer(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            //add neighbors
            for(Node nei : cur.neighbors){
                //have not copied the node
                if(!map.containsKey(nei)){
                    map.put(nei, new Node(nei.val));
                    queue.offer(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }

}
