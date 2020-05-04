package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//use graph to check cycle
public class LC261re {
    public boolean validTree(int n, int[][] edges) {
        if(edges == null)
            return false;
        if(n - edges.length != 1)
            return false;
        Node[] array = new Node[n];
        for(int i = 0; i < n; i++){
            array[i] = new Node(i);
        }
        int row = edges.length;
        //build up the graph
        for(int i = 0; i < row; i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            array[parent].nexts.add(child);
            array[child].nexts.add(parent);
        }

        for(Node node : array){
            if(dfs(node, array, new Node(-1)))
                return false;
        }
        return true;
    }

    private boolean dfs(Node cur, Node[] array, Node parent){
        if(cur.sta == status.VISITING)
            return true;
        if(cur.sta == status.VISITED)
            return false;
        cur.sta = status.VISITING;
        for(int next : cur.nexts){
            if(array[next] == parent)
                continue;
            if(dfs(array[next],array,cur))
                return true;
        }
        cur.sta = status.VISITED;
        return false;
    }

    private class Node{
        int val;
        status sta;
        List<Integer> nexts;
        Node(int val){
            sta = status.INITIAL;
            this.val = val;
            nexts = new ArrayList<>();
        }
    }

    enum status{
        INITIAL,
        VISITING,
        VISITED
    }
}
