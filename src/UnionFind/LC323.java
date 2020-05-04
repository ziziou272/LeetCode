package UnionFind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
// undirected graph 查环
public class LC323 {
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
        HashSet<Integer> count = new HashSet<>();
        for(int i = 0; i < graph.size(); i++){
            if(dfs(count, status, graph, i, -1))
                sum++;

        }
        return count.size() == n ? sum : sum + n - count.size();
    }

    private boolean dfs(HashSet<Integer>count, int[] status, List<List<Integer>> graph, int cur, int parent){
        boolean add = false;
        if(!count.contains(cur)){
            add = true;
            count.add(cur);
        }

        if(cur == parent)
            return add;
        //visited
        if(status[cur] == 1)
            return add;
        //visiting
        if(status[cur] == -1)
            return add;
        status[cur] = -1;
        List<Integer> nexts = graph.get(cur);
        for(int next : nexts){
            dfs(count, status, graph, next, cur);
        }
        status[cur] = 1;
        return add;
    }
}
