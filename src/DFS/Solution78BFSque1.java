package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution78BFSque1 {
    public List<List<Integer>> subsets(int [] nums){
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> que = new LinkedList<>();

        if (nums == null) return res;

        int index = 0;
        List<Integer> empty = new ArrayList<>();
        List<Integer>indexList = new ArrayList<>();
        //res.add(empty);
        que.add(empty);

        while (! que.isEmpty()){
            indexList = que.poll();
            int size = indexList.size();
            if(size ==0)
                index = -1;
            else
                index = indexList.get(size - 1);
            List<Integer> resList = new ArrayList<>();
            for(int j = 0; j < indexList.size();j++){
                resList.add(nums[indexList.get(j)]);
            }
            res.add(new ArrayList<>(resList));

            for(int i = index + 1; i < nums.length; i++){
                indexList.add(i);
                que.add(new ArrayList<>(indexList));
                indexList.remove(indexList.size() - 1);
            }
        }
        return res;
    }
}
