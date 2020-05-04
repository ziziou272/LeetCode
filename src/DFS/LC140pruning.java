package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC140pruning {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //cc
        List<String> res = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordDict);
        dfs(s, new StringBuilder(), res, 0, dict, new Boolean[s.length()]);
        return res;
    }
    private void dfs(String s, StringBuilder path, List<String> res, int index, HashSet<String> dict, Boolean[] memo){//o(2^n) + deep copy 的
        //base case
        if(index == s.length()){
            res.add(path.toString());
            return;
        }
        //剪枝
        //cat sand 1M长的失败string
        //cats and 1M长的失败string 这个就不用往后走了
        if(memo[index] != null && !memo[index]) return;
        int count= res.size();
        for(int i = index; i < s.length(); i++){
            String temp = s.substring(index, i + 1);
            if(dict.contains(temp)){
                int len = path.length();
                if(len == 0)
                    path.append(temp);
                else{
                    path.append(" ").append(temp);
                }
                dfs(s, path, res, i + 1, dict, memo);
                path.setLength(len);
            }
        }
        if(res.size() == count) memo[index] = false;
    }
}
