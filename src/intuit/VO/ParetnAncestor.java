package intuit.VO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ParetnAncestor {
    public static void main(String[] args) {

/*
         14   13
          \    \
  2   1    4   12
   \ /   / | \ /
    3   5  8  9
     \ / \     \
      6   7    11
*/
        int[][] inputs= {
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {9, 11},
                {14, 4},
                {13, 12},
                {12, 9}
        };
        SolutionParent sol = new SolutionParent();
        HashMap<Integer, List<Integer>> map = sol.buildGraph(inputs);
        //q1
        List<Integer> res = sol.findZeroAndOneParent(inputs);
        System.out.println(res);
        //q2
        boolean res1=sol.hasCommonAncestor(inputs,3,8);
        boolean res2=sol.hasCommonAncestor(inputs,5,8);
        boolean res3=sol.hasCommonAncestor(inputs,6,1);
        boolean res4=sol.hasCommonAncestor(inputs,6,9);
        boolean res5=sol.hasCommonAncestor(inputs,1,3);
        boolean res6=sol.hasCommonAncestor(inputs,7,11);
        boolean res7=sol.hasCommonAncestor(inputs,6,5);
        int[] farestAncestor = new int[1];
        sol.getFarAncestor(map, 1, farestAncestor, new int[1], 0);
        System.out.println();
        System.out.println();
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
        System.out.println(res7);
        System.out.println(farestAncestor[0]);
    }
}
class SolutionParent{
    /*
         14   13
          \    \
  2   1    4   12
   \ /   / | \ /
    3   5  8  9
     \ / \     \
      6   7    11
*/
    /**  q1:
     * 1. clarify output input
     * 2. build up the graph using hash map, key: child,
     * value: a list to store parents
     * 3. traverse the graph to find the children who have 1 or 0 parents
     */
    public List<Integer> findZeroAndOneParent(int[][] input){
        //how many edges o(edges)
        HashMap<Integer, List<Integer>> map = buildGraph(input);
        List<Integer> res = new ArrayList<>();
        for(Integer child : map.keySet()){
            if(map.get(child).size() == 0){
                res.add(child);
            }
            else if(map.get(child).size() == 1)
                res.add(child);
        }
        return res;
    }
    //sub function of q1
    public HashMap<Integer, List<Integer>> buildGraph(int[][] input){
        //child - parent HashMap
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pair : input){
            int child = pair[1];
            int parent = pair[0];
            if(!map.containsKey(child))
                map.put(child, new ArrayList<>());
            map.get(child).add(parent);
            //make sure all the nodes will be add to hashMap
            if(!map.containsKey(parent))
                map.put(parent, new ArrayList<>());
        }
        return map;
    }
  /*
         14   13
          \    \
  2   1    4   12
   \ /   / | \ /
    3   5  8  9
     \ / \     \
      6   7    11
*/
    /**  q2:
     * 1. build the graph, same as before can use hashSet
     * to store the parents
     * 2. traverse node1 to check if in the parents list of node2
     *
     */
    public boolean hasCommonAncestor(int[][] input, int node1, int node2){
        //o(edges)
        HashMap<Integer, List<Integer>> map  = buildGraph(input);
        //if either node don't have ancestor return false
        if(!map.containsKey(node1) || !map.containsKey(node2) || map.get(node1).size() == 0 || map.get(node2).size() == 0)
            return false;
        HashSet<Integer> ancestorsOfNode1 = new HashSet<>();
        HashSet<Integer> ancestorsOfNode2 = new HashSet<>();
        //get ancestors Of Node1 and node2
        getAncestor(map, ancestorsOfNode1, node1);
        getAncestor(map, ancestorsOfNode2, node2);
        for(Integer ancestor : ancestorsOfNode1){
            if(ancestorsOfNode2.contains(ancestor))
                return true;
        }
        return false;
    }
    //sub function of q2
    private void getAncestor(HashMap<Integer, List<Integer>> map, HashSet<Integer> set, int cur){
        if (map.get(cur).size() == 0){
            set.add(cur);
            return;
        }
        for(Integer parent : map.get(cur)){
            set.add(parent);
            getAncestor(map, set, parent);
        }
    }

    /**    q3:
     *  1. build the graph/ re-use previous graph
     *  2. keep a distance to current, is get further distance,
     *  update the result
     */
    public int get(int[][] input, int node){
        int[] res = new int[1];
        getFarAncestor(buildGraph(input), node, res, new int[1], 0);
        return res[0];
    }
    public void getFarAncestor(HashMap<Integer, List<Integer>> map, int node, int[] res, int[] count, int curCount){
        //o(edges)
        if (map.get(node).size() == 0){
            if(curCount > count[0]){
                count[0] = curCount;
                res[0] = node;
            }
        }
        for(Integer parent : map.get(node)){
            getFarAncestor(map, parent, res, count, curCount + 1);
        }
    }
}
