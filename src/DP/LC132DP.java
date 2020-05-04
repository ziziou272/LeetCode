package DP;

import java.util.Arrays;

/* 可以按palindrome的个数减1
 * 每当dp[][]填值的时候遇到一个true，我们就去看true的index右边有几个palindrome(通过res[j+1])
 * check到当前位置的最小值就是 右边palindrome的个数+1
 *最后结果是res[0] - 1
 * */
public class LC132DP {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] res = new int[s.length() + 1];
        int len = s.length();
        for(int i = len - 1; i >= 0; i--){
            res[i] = len - i;
            for(int j = i; j < len; j++){
                int size = j - i + 1;
                if(s.charAt(i) == s.charAt(j) && (size <= 2 || dp[i + 1][j - 1])){
                    res[i] = Math.min(res[j + 1] + 1, res[i]);
                    dp[i][j] = true;
                }
            }
        }
        return res[0] - 1;
    }

/*
*
*        2 2 2 1 1 0
*        0 1 2 3 4
         a b a b b
     0 a t f t f f
     1 b   t f t f
     2 a     t f f
     3 b       t t
     4 b         t
* */

}
