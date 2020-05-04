package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC47suanfage {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        for(int num : nums){
            numsList.add(num);
        }
        dfs(numsList, path, res);
        return res;
    }
    private void dfs(List<Integer> numsList, List<Integer> path, List<List<Integer>> res){
        if(numsList.size() == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < numsList.size(); i++){
            if(i > 0 && numsList.get(i) == numsList.get(i - 1))
                continue;
            path.add(numsList.get(i));
            List<Integer> newNumsList = new LinkedList<>(numsList);
            newNumsList.remove(i);
            dfs(newNumsList, path, res);
            path.remove(path.size() - 1);
        }
    }
}
