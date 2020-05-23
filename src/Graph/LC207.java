package Graph;

import java.util.ArrayList;
import java.util.List;

public class LC207 {

    enum status{
        INITIAL,
        VISITING,
        VISITED
    }

    private class vertex{
        int id;
        List<Integer> next;
        status status;
        vertex(int i){
            this.id = i;
            this.next = new ArrayList<Integer>();
            this.status = status.INITIAL;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //todo:cc
        //initialize a array to store all vertex
        vertex[] array = new vertex[numCourses];
        for(int i = 0; i < numCourses; i++){
            array[i] = new vertex(i);
        }
        int row = prerequisites.length;
        //build up the graph
        for(int i = 0; i < row; i++){
            int v = prerequisites[i][1];
            int next = prerequisites[i][0];
            array[v].next.add(next);
        }

        //check
        for(vertex vertex:array){
            if (ifCycle(vertex,array))
                return false;
        }
        return true;
    }
    private boolean ifCycle(vertex vertex, vertex [] array){
        if(vertex.status == status.VISITING)
            return true;
        if(vertex.status == status.VISITED)
            return false;
        vertex.status = status.VISITING;
        for(int i : vertex.next){
            if(ifCycle(array[i],array))
                return true;
        }
        vertex.status = status.VISITED;
        return false;
    }
}
class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1) return true;
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0)
            return true;
        //build graph
        List<List<Integer>> nexts = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            nexts.add(new ArrayList<>());
        }
        for(int[] pair: prerequisites ){
            int pre = pair[1];
            int next = pair[0];
            nexts.get(pre).add(next);
        }
        //check if any cycle
        Boolean[] status = new Boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(checkCycle(prerequisites, status, nexts.get(i), nexts))
                return false;
        }
        return true;
    }
    private boolean checkCycle(int[][] prerequisites, Boolean[] status, List<Integer> next, List<List<Integer>> nexts){
        for(int course : next){
            if(status[course] != null){
                //found cycle, visiting
                if(status[course])
                    return true;
            }
            else{
                status[course] = true;
                if(checkCycle(prerequisites, status, nexts.get(course), nexts))
                    return true;
            }
            status[course] = false;
        }
        return false;
    }
}
/*
5

0 1 2 3    4
   pre
[1,0]
[2,0]
[2,1]
[3,2]

--------->
0 -> 1 -> 2 -> 3
4
build graph:
index
0   1,2
1   2
2   3
List<List<Integer>> nexts;

*/