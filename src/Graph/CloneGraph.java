package Graph;

import java.util.*;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        copyNode(node, map);
        return map.get(node);
    }
    private void copyNode(Node node, HashMap<Node, Node> map){
        if(map.containsKey(node)) return;
        if(!map.containsKey(node))
            map.put(node, new Node(node.val));
        //add neighbors
        for(Node nei : node.neighbors){
            if(!map.containsKey(nei))
                //if there is no such node clone it
                copyNode(nei, map);
            //add neighbors to node
            map.get(node).neighbors.add(map.get(nei));
        }
    }
}
class solution2020_05_03DFS{
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> oldToNew = new HashMap<>();
        copy(node, oldToNew);
        return oldToNew.get(node);
    }
    private void copy(Node node, HashMap<Node, Node> map){
        if(map.containsKey(node))
            return;
        map.put(node, new Node(node.val));
        for(Node nei : node.neighbors){
            copy(nei, map);
            map.get(node).neighbors.add(map.get(nei));
        }
    }
}

/**
 * BFS dnb /???
 */
class solution2020_05_03BFS{

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        oldToNew.put(node, new Node(node.val));
        queue.offer(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(Node nei : cur.neighbors){
                if (!oldToNew.containsKey(nei)){
                    oldToNew.put(nei, new Node(nei.val));
                    queue.offer(nei);
                }
                oldToNew.get(cur).neighbors.add(oldToNew.get(nei));
            }
        }
        return oldToNew.get(node);
    }
}
























