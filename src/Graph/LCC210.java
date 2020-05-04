package Graph;

import java.util.*;

public class LCC210 {
    //todo: get rid of global variable
    //todo: change hashMap to list
    //todo: how about set up a vertex class?
    private int count = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] res = new int [numCourses];
        //0 initial 1 visiting 2 visited
        int [] status = new int [numCourses];
        HashMap<Integer, List<Integer>> map = buildGraph(prerequisites,numCourses);
        //res array 要反着放
        count = numCourses - 1;
        for(int i = 0; i < numCourses;i++ ){
            if(ifCycle(map, res, status,i)){
                return new int[0];
            }
        }
        return res;
    }
    private HashMap <Integer,List<Integer>> buildGraph(int[][]prerequisites,int numCourses){
        HashMap <Integer,List<Integer>> map = new HashMap<>();
        //set up n
        for(int i = 0; i <numCourses; i++){
            map.put(i,new ArrayList<>());
        }
        //加value
        for(int i = 0; i < prerequisites.length; i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return map;
    }

    private boolean ifCycle(HashMap<Integer, List<Integer>> map, int []res, int [] status, int index ){
        if(status[index] == 1)
            return true;
        if(status[index] == 2)
            return false;
        status[index] = 1;
        for(int next:map.get(index)){
            if(ifCycle(map,res,status,next))
                return true;
        }
        status[index] = 2;
        res[count--] = index;
        return false;
    }
}
