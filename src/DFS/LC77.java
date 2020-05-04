package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(path, res, k, 1, n);
        return res;
    }

    private void dfs(List<Integer> path, List<List<Integer>> res, int k, int start, int n){
        if(k == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= n; i++){
            path.add(i);
            dfs(path, res, k - 1, i + 1, n);
            path.remove(path.size() - 1);
        }
    }
}
