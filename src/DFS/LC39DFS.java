package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC39DFS {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return res;
        combinationSum(candidates, target, 0, 0, res,new ArrayList<>());
        return res;

    }

    private void combinationSum(int [] candidates, int target, int sum, int index, List<List<Integer>> res, List<Integer> level){
        if(sum > target)
            return;
        if(sum == target)
            res.add(new ArrayList<>(level));
        for(int i = index; i < candidates.length; i++){
            level.add(candidates[i]);
            sum += candidates[i];
            combinationSum(candidates, target, sum, i, res, level);
            sum -= candidates[i];
            level.remove(level.size() - 1);
        }
    }
}
