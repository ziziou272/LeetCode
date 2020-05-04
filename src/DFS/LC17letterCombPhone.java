package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC17letterCombPhone {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        //dfs
        //cc
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        dfs(res, digits, 0, KEYS, new StringBuilder());
        return res;
    }
    private void dfs(List<String> res, String digits, int index, String[] KEYS, StringBuilder path){
        //base case
        if(index == digits.length()){
            res.add(path.toString());
            return;
        }
        int idx = digits.charAt(index);
        char[] charArr = KEYS[idx].toCharArray();
        for(char charFromBoard : charArr){
            path.append(charFromBoard);
            dfs(res, digits, index + 1, KEYS, path);
            path.setLength(path.length() - 1);
        }
    }
}
