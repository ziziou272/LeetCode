package DFS;

import java.util.ArrayList;
import java.util.List;

/*

                  abac
      a             ab      aba     abac
  b     ba  bac    a ac      c
a ac    c          c
c
int height = n

*/
public class LC131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(String s, int index, List<String> path, List<List<String>> res){
        //base case
        if(index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                String curStr = s.substring(index, i + 1);
                path.add(curStr);
                dfs(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end){
        if(start == end) return true;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

}
