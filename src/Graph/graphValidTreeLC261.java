package Graph;

import java.util.ArrayList;
import java.util.List;

public class graphValidTreeLC261 {
}
class Solution261DFS {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length + 1 != n) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        //build graph
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        //from 0 traverse
        int[] count = new int[1];
        //mark visited, if visited's number == n then true
        dfs(graph, visited, 0, count);
        return count[0] == n;
    }
    //return true if there is cycle
    private void dfs(List<List<Integer>> graph, boolean[] visited, int cur, int[] count){
        if(visited[cur]) return;
        //visiting
        visited[cur] = true;
        count[0]++;
        for(int next : graph.get(cur)){
            dfs(graph, visited, next, count);
        }
    }
}