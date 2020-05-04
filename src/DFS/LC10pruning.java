package DFS;

public class LC10pruning {
    //time complexity: s * p * p : 填表的时间复杂度(s * p * 单个dfs的时间复杂度: while loop: s)
    //具体分析和变种算法加强10/3
    //dp解法
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length()];
        return dfs(s, 0, p, 0, memo);
    }
    private boolean dfs(String s, int indexS, String p, int indexP, Boolean[][] memo){
        //base case
        if(indexP == p.length()) return indexS == s.length();
        if(memo[indexS][indexP] != null) return memo[indexS][indexP];
        //no *
        if(indexP == p.length() - 1 || p.charAt(indexP + 1) != '*'){
            if(indexS < s.length() && checkMatch(s.charAt(indexS), p.charAt(indexP))) {
                memo[indexS][indexP] = dfs(s, indexS + 1, p, indexP + 1, memo);
                return memo[indexS][indexP];
            }
        }
        //*
        else{
            int i = indexS - 1;
            while(i == indexS - 1 || i < s.length() && checkMatch(s.charAt(i), p.charAt(indexP))){
                if(dfs(s, i + 1, p, indexP + 2, memo)){
                    memo[indexS][indexP] = true;
                    return true;
                }
                i++;
            }
        }
        memo[indexS][indexP] = false;
        return false;
    }
    private boolean checkMatch(char a, char b){
        return(a == b || b == '.');
    }
}
