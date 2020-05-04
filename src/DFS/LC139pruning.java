package DFS;

import java.util.HashSet;
import java.util.List;
/*

aaa aab
0                       a                      aa
1                   a           aa aaa aaaa
2      a        aa  aaa aaab
3   a   aa aab
4 a ab
5 b   f

index start from
0 1 2 3 4 5
        f f

can i use HashSet to store the dictionary?

dict:
a
aa
aaa
aaaa
ac
cat
hat
has
that
*/
public class LC139pruning {//from 算法哥
    public boolean wordBreak(String s, List<String> wordDict) {//o(n^2)
        //cc
        HashSet<String> dict = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, 0, dict, memo);

    }
    private boolean dfs(String s, int index, HashSet<String> dict, Boolean[] memo){
        //base case
        if(index == s.length()) {
            return true;
        }
        if(memo[index] != null) return memo[index];
        for(int i = index; i < s.length(); i++){
            String temp = s.substring(index, i + 1);
            if(dict.contains(temp) && dfs(s, i + 1, dict, memo)){
                //memo[index] = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }
}
