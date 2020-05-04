package DP;

public class LC1143LongestCommonSubSeq {
    public int longestCommonSubsequence(String text1, String text2) {
        //clarify q1.what character set we gonna use? are lower and upper case same?
        //q2. len if one of the len is much bigger than another one
        //corner case
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        for(int i = 0; i< len1; i++){
            if(text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
            }
            else
                dp[i][0] = i - 1 < 0 ? 0 : dp[i - 1][0];
        }
        for(int j = 0; j< len2; j++){
            if(text1.charAt(0) == text2.charAt(j)){
                dp[0][j] = 1;
            }
            else
                dp[0][j] = j - 1 < 0 ? 0 : dp[0][j - 1];
        }
        for(int k = 1; k < len1; k++){
            for(int l = 1; l < len2; l++){
                if(text1.charAt(k) == text2.charAt(l)){
                    dp[k][l] = dp[k - 1][l - 1] + 1;
                }
                else{
                    dp[k][l] = Math.max(dp[k - 1][l], dp[k][l - 1]);
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

}
