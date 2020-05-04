package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<HashSet<Integer>> count = new ArrayList<>();
        for(int i = 0; i < n; i++) count.add(new HashSet<>());
        for(int[] edge : edges){
            count.get(edge[0]).add(edge[1]);
            count.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0;  i < n; i++){
            if(count.get(i).size() == 1)
                leaves.add(i);
        }
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int node: leaves){
                //to be removed
                int index = count.get(node).iterator().next();
                count.get(index).remove(node);
                if(count.get(index).size() == 1)
                    newLeaves.add(index);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
