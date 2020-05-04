package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graphToplogical {
    //  dfs:
//  ArrayList<Integer>[] 的解法，不用对每个course 进行class wrapper

    public class L207_Course_Schedule {

        public boolean canFinish (int numCourses, int[][] prerequisites) {
            //cc
            if(numCourses <= 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0) return true;  //throw new IllegalArgumentException();

            ArrayList<Integer>[] graph = new ArrayList[numCourses];  //重要，记得这里用这个数据解结构
            for(int i = 0; i < numCourses; i++){  //更重要，要记得new出ArrayList，如果是ArrayList[] 的话
                graph[i] = new ArrayList<>();
            }
            int[] status = new int[numCourses]; //1:visiting   2:visited


            //build graph
            for(int[] pair : prerequisites){
                graph[pair[0]].add(pair[1]);
            }

            for(int i = 0; i < numCourses; i++){
                if(dfs(graph, status, i)) return false;  //有环
            }

            return true;
        }

        private boolean dfs(ArrayList<Integer>[] graph, int[] status, Integer course){
            //bc
            if(status[course] == 1) return true;
            if(status[course] == 2) return false;

            status[course] = 1;
            for(Integer next : graph[course]){
                if(dfs(graph, status, next)) return true;
            }

            status[course] = 2;
            return false;
        }

    }


    //bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //cc
        if(numCourses <= 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0) return true;  //throw new IllegalArgumentException();

        ArrayList<Integer>[] graph = new ArrayList[numCourses];  //graph

        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }

        //build graph   degree graph
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            degree[prerequisites[i][1]]++;
        }


        // add degree == 0 的 course into queue
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }


        while(! queue.isEmpty()){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++) {
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                }
            }
            count++;
        }


        if(count == numCourses)
            return true;
        else
            return false;
    }
}
