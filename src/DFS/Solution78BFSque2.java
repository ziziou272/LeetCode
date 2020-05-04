package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution78BFSque2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList());

        for(int i = 0; i < nums.length; i++){

            List<List<Integer>> temp = new ArrayList<>();

            for(int j = 0; j < res.size(); j++){
                List<Integer> inside = new ArrayList<>(res.get(j));
                temp.add(new ArrayList<>(inside));
                inside.add(nums[i]);
                temp.add(new ArrayList<>(inside));
            }
            res.clear();
            res.addAll(temp);
        }
        return res;
    }
}
