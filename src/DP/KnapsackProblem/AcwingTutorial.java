package DP.KnapsackProblem;

public class AcwingTutorial {
    public static void main(String[] args) {
        System.out.println(knapsack01_2d(6, new int[]{2,1,2,3,3}, new int[]{3,3,2,5,1}));
        System.out.println(knapsack01_1d(6, new int[]{2,1,2,3,3}, new int[]{3,3,2,5,1}));
        System.out.println(knapsack_unBounded_revised(6, new int[]{2,1,2,3,3}, new int[]{3,3,2,5,1}));
    }

    /**
     *
     * @param v
     * @param volumes
     * @param values
     * @return
     *
     * v: 6
     * volume[2,1,2,3,3]
     * value [3,3,2,5,1]
     *     0
     *     1    3
     *     2  3   3 5
     *     3    6
     *     4
     *     5      9
     *     6        11
     *
     */
    public static int knapsack01_2d(int v, int[] volumes, int[] values){
        //2d
        int n = values.length;
        int[][] dp = new int[n][v + 1];
        for(int i = 0; i < n; i++){
            if(i == 0){
                dp[i][volumes[i]] = values[i];
                continue;
            }
            for(int j = 0; j <= v; j++){
                if(j - volumes[i] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - volumes[i]] + values[i]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][v];
    }
    public static int knapsack01_1d(int v, int[] volumes, int[] values){
        //2d
        int n = values.length;
        int[] dp = new int[v + 1];
        for(int i = 0; i < n; i++){
            if(i == 0){
                dp[volumes[i]] = values[i];
                continue;
            }
            for(int j = v; j >= 0; j--){
                if(j - volumes[i] >= 0){
                    dp[j] = Math.max(dp[j], dp[j - volumes[i]] + values[i]);
                }
            }
        }
        int res = 0;
        for(int value : dp) res = Math.max(res, value);
        return res;
    }

    /**
     * 完全背包,物品无限次
     * @return 最大价值
     *      * volume[2,1,2,3,3]
     *      * value [3,3,2,5,1]
     *      *     0
     *      *     1    3
     *      *     2    6
     *      *     3  3
     *      *     4
     *      *     5
     *      *     6  6
     *
     */
    public static int knapsack_unBounded(int v, int[] volumes, int[] values){
        int n = values.length;
        int[] dp = new int[v + 1];
        for(int i = 0; i < n; i++){
            if(i == 0){
                dp[volumes[i]] = values[i];
                continue;
            }
            for(int k = 1; k * volumes[i] <= v; k++){
                for(int j = v; j >= 0; j--){
                    if(j - k * volumes[i] >= 0){
                        dp[j] = Math.max(dp[j], dp[j - volumes[i] * k] + k * values[i]);
                    }
                }
            }
        }
        int res = 0;
        for(int value : dp) res = Math.max(res, value);
        return res;
    }

    //revised 1维0 1 背包问题按正常顺序
    public static int knapsack_unBounded_revised(int v, int[] volumes, int[] values){
        int n = values.length;
        int[] dp = new int[v + 1];
        for(int i = 0; i < n; i++){
            if(i == 0){
                dp[volumes[i]] = values[i];
                continue;
            }
            for(int j = 0; j <= v; j++){
                if(j - volumes[i] >= 0){
                    dp[j] = Math.max(dp[j], dp[j - volumes[i]] + values[i]);
                }
            }

        }
        int res = 0;
        for(int value : dp) res = Math.max(res, value);
        return res;
    }
}
