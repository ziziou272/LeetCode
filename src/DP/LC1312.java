package DP;
/*   len - longest palindrome substring length

(res + 1) /2
                                     ab   1
                                     abc  2
                                     abcd
insert
   res        0 1 0
        0 1 2 3 4 5
        m b a e m e
     m  0 1 2 3 2 3
     b    0 1 2 3 2
     a      0 1 2 1
     e        0 1 0
     m          0 1
     e            0


     equal     [i + 1][j -1]
     not equal [i][j - 1] + 1    [i + 1][j] + 1
*/
public class LC1312 {
    public int minInsertions(String s) {
        //corner case
        if(s == null || s.length() <= 1) return 0;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        int size = s.length();
        for(int i = size - 1; i >= 0; i--){
            for(int j = i; j < size; j++){
                int subLen = j - i + 1;
                if(s.charAt(i) == s.charAt(j)){
                    if(j - 1 < 0)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                else
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
            }
        }
        return dp[0][s.length() - 1];
    }
}
