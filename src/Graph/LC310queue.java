package Graph;

import java.util.*;

public class LC310queue {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1) {
            res.add(0);
            return res;
        }
        List<HashSet<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new HashSet<>());
        //build the graph
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int nodeCount = n;
        //add all leaves to queue
        for(int i = 0; i < n; i++){
            if(graph.get(i).size() == 1){
                queue.offer(i);
                nodeCount--;
            }
        }
        while(nodeCount > 0){
            int nodeNumber = queue.poll();
            for(int neighbor : graph.get(nodeNumber)){
                graph.get(neighbor).remove(nodeNumber);
                if(graph.get(neighbor).size() == 1) {
                    queue.offer(neighbor);
                    nodeCount--;
                }
            }
        }
        res.addAll(queue);
        return res;
    }
}
