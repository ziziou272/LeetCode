package DFS;

import java.util.Arrays;

public class LC1029 {
}
class greedy1029{
    public int twoCitySchedCost(int[][] costs) {
        //sort based on difference
        Arrays.sort(costs,(a, b)-> Math.abs(b[0]-b[1])-Math.abs(a[0]-a[1]));
        int countA = 0, countB = 0;
        int n = costs.length / 2;
        int sum = 0;
        for(int[] cost : costs){
            if(countA >= n){
                sum += cost[1];
            }
            else if(countB >= n)
                sum += cost[0];
            else{
                if(cost[0] < cost[1]){
                    countA++;
                    sum += cost[0];
                }
                else{
                    countB++;
                    sum += cost[1];
                }
            }
        }
        return sum;
    }
}

class Solution1029DFSMemo {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length/2;
        int[][] memo = new int[n+1][n+1];
        return dfs(costs, n, n, memo);
    }
    private int dfs(int[][] costs, int countA, int countB, int[][] memo){
        if(countA < 0 || countB < 0)
            return Integer.MAX_VALUE;
        if(countA == countB && countA == 0){
            memo[0][0]= 0;
            return 0;
        }
        if(memo[countA][countB] > 0)
            return memo[countA][countB];
        int costA = dfs(costs, countA-1,countB,memo);
        costA = costA == Integer.MAX_VALUE ? Integer.MAX_VALUE : costs[countA+countB-1][0] + costA;
        int costB = dfs(costs, countA,countB-1,memo);
        costB = costB == Integer.MAX_VALUE ? Integer.MAX_VALUE : costs[countA+countB-1][1] + costB;
        memo[countA][countB] = Math.min(costA,costB);
        return  memo[countA][countB];
    }

}