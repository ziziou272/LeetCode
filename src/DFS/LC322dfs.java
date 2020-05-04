package DFS;

import java.io.BufferedReader;
import java.io.IOException;

public class LC322dfs {
    //如果用另外一种搜索树的话没法memo
    public int coinChange(int[] coins, int amount) {
        if(coins == null) return -1;
        if(amount == 0) return 0;
        int[] memo = new int[amount + 1];
        return dfs(coins, amount, memo);
    }
    private int dfs(int[] coins, int remain, int[] memo){
        if(remain < 0) return -1;
        if(memo[remain] != 0)
            return memo[remain];
        if(remain == 0) return 0;
        int levelCount = Integer.MAX_VALUE;
        for(int i = coins.length - 1; i >= 0; i--){
            int returnCount = dfs(coins, remain - coins[i], memo);
            if(returnCount != -1)
                levelCount = Math.min(levelCount, returnCount);
        }
        if(levelCount == Integer.MAX_VALUE) {
            memo[remain] = -1;
        }
        else
            memo[remain] = levelCount + 1;
        return memo[remain];
    }
    public static class MainClass {

        public static void main(String[] args) throws IOException {
            String line;
                int[] coins = new int[]{1,2,5};
                int amount = 10;

                int ret = new LC322dfs().coinChange(coins, amount);

                String out = String.valueOf(ret);

                System.out.print(out);

        }
    }
}
