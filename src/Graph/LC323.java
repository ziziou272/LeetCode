package Graph;

import java.util.ArrayList;
import java.util.List;

public class LC323 {
}
class Solution323{
    public int countComponents(int n, int[][] edges) {
        //build graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int v1 = edge[0];
            int v2 = edge[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        int count = 0;
        //show status: t:visited f:visiting null: not visited
        Boolean[] visited = new Boolean[n];
        //start from each nodes
        for(int i = 0; i < n; i++){
            if(visited[i] == null)
                count++;
            mark(i, visited, graph);
        }
        return count;
    }
    private void mark(int vertix, Boolean[] visited, List<List<Integer>> graph){
        if(visited[vertix] != null)
            return;
        //visiting
        visited[vertix] = true;
        for(int next : graph.get(vertix)){
            mark(next, visited, graph);
        }
        //visted
        visited[vertix] = false;
    }
}