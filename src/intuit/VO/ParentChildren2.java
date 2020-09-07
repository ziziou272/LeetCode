package intuit.VO;

import java.util.*;

public class ParentChildren2 {
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
        int[][] input= {
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
        System.out.println("Q1----------------");
        find0AndOneParent(input);
        System.out.println("Q2----------------");
        findCommonAncestor(input, 6, 11);
        System.out.println("Q3----------------");
        System.out.println("6");
        findFarthestAncestor(input, 6);
        System.out.println("7");
        findFarthestAncestor(input, 7);
        System.out.println("11");
        findFarthestAncestor(input, 11);
        System.out.println("14");
        findFarthestAncestor(input, 14);
        System.out.println("3");
        findFarthestAncestor(input, 3);




    }

    public static HashMap<Integer, List<Integer>> find0AndOneParent(int[][] input){

        //child -> parents
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] arr : input){
            int parent = arr[0];
            int child = arr[1];
            if(!map.containsKey(child)){
                map.put(child, new ArrayList<>());
            }
            if(!map.containsKey(parent)){
                map.put(parent, new ArrayList<>());
            }
            map.get(child).add(parent);
        }
        List<Integer> res = new ArrayList<>();
        for(Integer id : map.keySet()){
            if(map.get(id).size() <= 1){
                res.add(id);
            }
        }
        //System.out.println(res);
        return map;
    }

    //q2
    public static void findCommonAncestor(int[][] input, int id1, int id2){
        HashMap<Integer, List<Integer>> map = find0AndOneParent(input);
        HashSet<Integer> ancestors1 = new HashSet<>();
        HashSet<Integer> ancestors2 = new HashSet<>();
        //add first
        dfs(id1, ancestors1, map);
        //add second
        dfs(id2, ancestors2, map);
        for(int parent : ancestors1){
            if(ancestors2.contains(parent)){
                System.out.println(parent);
            }
        }
    }

    private static void dfs(int cur, HashSet<Integer> ancestors, HashMap<Integer, List<Integer>> map){
        if(map.get(cur).size() == 0) return;
        List<Integer> parents = map.get(cur);
        for(int parent : parents){
            ancestors.add(parent);
            dfs(parent, ancestors, map);
        }
    }
    public static void findFarthestAncestor(int[][] input, int id){
        HashMap<Integer, List<Integer>> map = find0AndOneParent(input);
        List<Integer> farthestAncestor = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(id);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int cur = queue.poll();
                farthestAncestor.add(cur);
                for(int parent : map.get(cur)){
                    if(!visited.contains(parent)){
                        queue.offer(parent);
                        visited.add(parent);
                    }
                }
            }
            if(!queue.isEmpty()){
                farthestAncestor.clear();
            }
        }
        if(farthestAncestor.size() == 1 && farthestAncestor.get(0) == id)
            System.out.println("None");
        else
            System.out.println(farthestAncestor);
    }
}
