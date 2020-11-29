package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC386LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 9; i++){
            dfs(n, res, i);
        }
        return res;
    }

    private void dfs(int n, List<Integer> res, int val){
        if(val > n) return;
        res.add(val);
        for(int i = 0; i <= 9; i++){
            int temp = val * 10 + i;
            //tree的高度减1
            if(temp > n) return;
            dfs(n, res, temp);
        }
    }
}
/*
    1                   2 3 4 5 6 7 8 9
1 2 3 4 5 6 7 8 9




99999
*/
