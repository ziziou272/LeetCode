package DFS;

public class LC639DecodeWaysII {
    private static int MOD = (int) Math.pow(10, 9) + 7;
    public int numDecodings(String s) {
        return dfs(s, new Integer[s.length()], 0);
    }

    private int dfs(String s, Integer[] memo, int i){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(memo[i] != null) return memo[i];
        //single digit
        int val1 = dfs(s, memo, i + 1) % MOD;
        //if current is *
        if(s.charAt(i) == '*')
            val1 *= 9;
        //two digit
        int val2 = 0;
        if(i + 1 < s.length()){
            //next not start
            char curChar = s.charAt(i);
            char nextChar = s.charAt(i + 1);
            if(nextChar != '*'){
                //cur is start
                if(curChar == '*'){
                    if(nextChar <= '6'){
                        val2 = 2 * dfs(s, memo, i + 2) % MOD;
                    }else{
                        val2 = dfs(s, memo, i + 2) % MOD;
                    }
                }else{
                    if(Integer.parseInt(s.substring(i, i + 2)) <= 26)
                        val2 = dfs(s, memo, i + 2) % MOD;
                }
            }
            //next is *
            else{
                if(curChar == '*'){
                    val2 = 15 * dfs(s, memo, i + 2) % MOD;
                }else{
                    if(curChar == '1'){
                        val2 = 9 * dfs(s, memo, i + 2) % MOD;
                    }else if(curChar == '2'){
                        val2 = 6  * dfs(s, memo, i + 2) % MOD;
                    }
                }
            }
        }
        memo[i] = (val1 + val2) % MOD;
        return memo[i];
    }
}
