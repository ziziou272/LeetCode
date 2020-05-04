package UnionFind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC323checkCyclere {
    public int countComponents(int n, int[][] edges) {
        //cc
        if(n == 0 || edges == null || edges.length == 0)
            return n;
        int[] status = new int[n];
        //build graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        //traverse
        //int[] count = new int[1];
        int sum = 0;
        for(int i = 0; i < graph.size(); i++){
            if(status[i] == 0)
            {
                sum++;
                dfs(status, graph, i, -1);
            }
        }
        return sum;
    }

    private void dfs(int[] status, List<List<Integer>> graph, int cur, int parent){
        if(cur == parent)
            return;
        //visited
        if(status[cur] == 1)
            return;
        //visiting
        if(status[cur] == -1)
            return;
        status[cur] = -1;
        List<Integer> nexts = graph.get(cur);
        for(int next : nexts){
            dfs(status, graph, next, cur);
        }
        status[cur] = 1;
    }
}
