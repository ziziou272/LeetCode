package DP;

public class LC516dp {
    /*
     0 1 2 3 4 5 6
     b b a b a e b
  b  1 2 2 3 3 3 5
  b    1 1 3 3 3 5
  a      1 1 3 3 3
  b        1 1 1 3
  a          1 1 1
  e            1 1
  b              1
if ==
 len <= 3
     len
 else 可以只保留这个
     2 + [i + 1][j - 1]

else
 max([i + 1][j], [i] [j - 1])
 */
    public int longestPalindromeSubseq(String s) {
        //corner case
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i + 1 <= 3){
                        dp[i][j] = j - i + 1;
                    }
                    else//可以删除上边只保留这个
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else{
                    if(j - 1 < 0 || i + 1 >= len)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
    public static void main(String[] args){
        LC516dp dp = new LC516dp();
        dp.longestPalindromeSubseq("bbabaeb");
        System.out.print("");
    }
}
