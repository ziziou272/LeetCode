package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC46Revised {

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        permute(nums, res, path, 0);
        return res;
    }
    private void permute(int[] nums,List<List<Integer>> res, List<Integer> path, int index){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < nums.length; i++){
            Integer temp = nums[i];
            swap(index, i, nums);
            path.add(temp);
            permute(nums, res, path, path.size());
            swap(index, i, nums);
            path.remove(temp);
        }
    }
    private void swap(int i, int j, int [] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
