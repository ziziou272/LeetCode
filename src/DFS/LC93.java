package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC93 {
    //砍与不砍相对好写
    //255.1.05.2 invalid
    //255.0.1.3  valid
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        dfs(s, res, new StringBuilder(), 0, 0);
        return res;
    }
    private void dfs(String s, List<String> res, StringBuilder path, int index, int count){
        //success
        if(index == s.length() && count == 4) {
            path.setLength(path.length() - 1);
            res.add(path.toString());
            return;
        }
        //fail
        if(index >= s.length() || count >= 4) return;
        for(int i = index; i < index + 3 && i < s.length(); i++){
            //分了3个叉
            int val = Integer.valueOf(s.substring(index, i + 1));
            if(val <= 255){
                int curLength = path.length();
                path.append(val).append(".");
                dfs(s, res, path, i + 1, count + 1);
                path.setLength(curLength);
            }
            //0开头的话不可以再继续下去了，.012是不valid的
            if(val == 0) break;
        }
    }
}
