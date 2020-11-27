package DFS.LC1155;

import java.util.Arrays;

public class NumberofDiceRollsWithTargetSum {
    private static final int MOD = (int) Math.pow(10, 9) + 7;
    public int numRollsToTarget(int d, int f, int target) {
        int total = (int) Math.pow(f, d) % MOD;
        int[][] memo = new int[d+1][target + 1];
        for(int i = 0; i <= d; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(d, f, target, memo) % MOD;
    }

    private int dfs(int d, int f, int target, int[][] memo){
        if(d == 0) return target == 0 ? 1 : 0;
        if(target <= 0) return 0;
        if(memo[d][target] != -1) return memo[d][target];
        int count = 0;
        for(int i = 1; i <= f; i++){
            count = (count + (dfs(d - 1, f, target - i, memo))) % MOD;
        }
        memo[d][target] = count % MOD;
        return count;
    }
}
/*
6  6  target  6
1  5
2  4
3  3
4  2
5  1
----
6 6      target 3
1 2
2 1
------
3 3 3 3 3 3 3   target 11

7dices:
1:      1       2 3
2    1 2 3
3:
*/