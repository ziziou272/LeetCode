package Graph;

import java.util.ArrayList;
import java.util.List;

public class LC210dfsRevised {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build graph
        List<List<Integer>> neighbors = new ArrayList<>();
        List<int[]> status = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            neighbors.add(new ArrayList<>());
            //0 initial, 1 visiting , 2 visited
            status.add(new int[1]);
        }
        //build the graph
        for(int[] pre : prerequisites){
            neighbors.get(pre[1]).add(pre[0]);
        }
        //check
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(checkCycle(i, status, neighbors, res))
                return new int[0];
        }
        int[] result = new int[numCourses];
        for(int i = res.size() - 1; i >= 0; i--){
            result[numCourses - i - 1] = res.get(i);
        }
        return result;
    }

    private boolean checkCycle(int course, List<int[]> status, List<List<Integer>> neighbors, List<Integer> res){
        if(status.get(course)[0] == 2) return false;
        if(status.get(course)[0] == 1) return true;
        status.get(course)[0] = 1;
        for(int neighbor : neighbors.get(course)){
            if(checkCycle(neighbor, status, neighbors, res))
                return true;
        }
        status.get(course)[0] = 2;
        res.add(course);
        return false;
    }
}
