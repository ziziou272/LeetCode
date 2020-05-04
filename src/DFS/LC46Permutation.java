package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC46Permutation {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> toBeAdd = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            toBeAdd.add(nums[i]);
        }
        permute(nums, res, path, toBeAdd);
        return res;
    }
    private void permute(int[] nums,List<List<Integer>> res, List<Integer> path, List<Integer> toBeAdd){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < toBeAdd.size(); i++){
                Integer temp = toBeAdd.get(i);
                path.add(temp);
                toBeAdd.remove(temp);
                permute(nums, res, path, toBeAdd);
                toBeAdd.add(i,temp);
                path.remove(temp);
        }
    }
}
