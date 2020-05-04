package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC140wordBreakDFS {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //cc
        List<String> res = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordDict);
        dfs(s, new StringBuilder(), res, 0, dict);
        return res;
    }
    private void dfs(String s, StringBuilder path, List<String> res, int index, HashSet<String> dict){//o(2^n) + deep copy 的
        //base case
        if(index == s.length()){
            res.add(path.toString());
            return;
        }
        for(int i = index; i < s.length(); i++){
            String temp = s.substring(index, i + 1);
            if(dict.contains(temp)){
                int len = path.length();
                if(path.length() == 0)
                    path.append(temp);
                else{
                    path.append(" ").append(temp);
                }
                dfs(s, path, res, index + 1, dict);
                path.setLength(len);
            }
        }
    }
}
