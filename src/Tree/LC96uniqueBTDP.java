package Tree;

public class LC96uniqueBTDP {
    //pruning
    public int numTrees(int n) {
        //dfs
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        return dfs(1, n, dp);
    }
    private int dfs(int start, int end, int[] dp){
        if(start > end) return 1;
        if(dp[end - start + 1] != 0) return dp[end - start + 1];
        int sum = 0;
        for(int i = start; i<= end; i++){
            int leftNum = dfs(start, i - 1, dp);
            int rightNum = dfs(i + 1, end, dp);
            sum = sum + (leftNum * rightNum);
        }
        dp[end - start + 1] = sum;
        return sum;
    }
}
