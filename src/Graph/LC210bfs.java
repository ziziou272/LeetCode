package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC210bfs {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //todo: corner case
        //build graph
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[numCourses];
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        //add all node with degree == 0
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offer(i);
                res[count++] = i;
            }

        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor: graph.get(node)){
                degree[neighbor]--;
                if(degree[neighbor] == 0){
                    queue.offer(neighbor);
                    res[count++] = neighbor;
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }
}
