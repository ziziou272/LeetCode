package Graph;
import java.util.*;
public class LC210enum {
    public static enum Status{
        INITIAL,
        VISITING,
        VISITED;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //cc
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0) {
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                res[i]= i;
            }
        }
        //status map
        Status[] status = new Status[numCourses];
        for(int i = 0; i < numCourses; i++) status[i] = Status.INITIAL;
        //build graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<Integer>());
        for(int[] course : prerequisites){
            int pre = course[1];
            int next = course[0];
            graph.get(pre).add(next);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < graph.size(); i++){
            //can not finish all
            if(!checkExsit(graph, status, res, i))
                return new int[0];
        }
        //todo:
        int[] result = new int[numCourses];
        int size = res.size();
        for(int i = 0; i < size; i++){
            result[i] = res.get(size - i - 1);
        }
        return result;
    }
    private boolean checkExsit(List<List<Integer>> graph, Status[] status, List<Integer> res, int index){
        if(status[index] == Status.VISITED) return true;
        if(status[index] == Status.VISITING) return false;
        //set visiting
        status[index] = Status.VISITING;
        for(int next: graph.get(index)){
            if(!checkExsit(graph, status, res, next))
                return false;
        }
        //status set back
        status[index] = Status.VISITED;
        //add to res
        res.add(index);
        return true;
    }
}
