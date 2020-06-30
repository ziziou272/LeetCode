package DP.KnapsackProblem;

public class LC474 {
}
class SolutionLC474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < strs.length; i++){
            int countZero = getZeroCount(strs[i]);
            int countOne = strs[i].length() - countZero;
            for(int j = m; j >= 0; j--){
                for(int k = n; k >= 0; k--){
                    if(j == 0 && k == 0){
                        dp[j][k] = 0;
                    }
                    else{
                        if(countZero <= j && countOne <= k){
                            dp[j][k] = Math.max(dp[j][k], dp[j - countZero][k - countOne] + 1);
                        }
                        else{
                            dp[j][k] = dp[j][k];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }

    private int getZeroCount(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0')
                count++;
        }
        return count;
    }
}
/*
int[][] counts
["10","0001","111001","1","0"], m = 5, n = 3
    [[1,1],[3,1],[4,2],[0,1],[1,0]]
m
0     0     0     0     1      0
1    [0,1,1,1]
2
3
4
5

max(dp[i-1][j][k], dp[i-1][j-countofZero][k-countOfOne])





*/