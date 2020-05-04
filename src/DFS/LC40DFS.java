package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC40DFS {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, 0, res, new ArrayList<>());
        return res;
    }

    private void combinationSum2(int [] candidates, int target, int sum, int index, List<List<Integer>> res, List<Integer> level){
        if(sum > target)
            return;
        if(sum == target)
            res.add(new ArrayList<>(level));
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            level.add(candidates[i]);
            sum += candidates[i];
            combinationSum2(candidates, target, sum, i + 1, res, level);
            sum -= candidates[i];
            level.remove(level.size() - 1);
        }
    }
}
