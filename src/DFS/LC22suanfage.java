package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC22suanfage {
    public List<String> generateParenthesis(int n) {//先写helper
        //对于all possible一般return void
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;
        dfs(res, n, 0, new StringBuilder());
        return res;
    }
    private void dfs(List<String> res, int n, int delta, StringBuilder path){
        //base case
        //correct
        if(path.length() == 2 * n && delta == 0) {
            res.add(path.toString());
            return;
        }
        //fail
        if(delta < 0 || path.length() >= 2 * n)
            return;
        //body 分叉
        //'('
        path.append('(');
        dfs(res, n, delta + 1, path);
        path.setLength(path.length() - 1);
        //')'
        path.append(')');
        dfs(res, n, delta - 1, path);
        path.setLength(path.length() - 1);
    }
}
