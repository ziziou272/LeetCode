package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC320suanFage {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if(word == null || word.length() == 0) return res;
        dfs(word, res, new StringBuilder(), 0, 0);
        return res;
    }
    private void dfs(String word, List<String> res, StringBuilder path, int count, int index){
        //base case
        //keep length for set back
        int len = path.length();
        if(index == word.length()){
            //need to backtrack
            if(count > 0){
                path.append(count);
                res.add(path.toString());
                path.setLength(len);
            }
            else
                res.add(path.toString());
            return;
        }
        //digit
        dfs(word, res, path, count + 1, index + 1);
        //non digit
        if(count > 0){
            path.append(count);
            //count = 0;
        }
        path.append(word.charAt(index));
        dfs(word, res, path, 0, index + 1);
        path.setLength(len);
    }
}