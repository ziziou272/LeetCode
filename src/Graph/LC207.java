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
