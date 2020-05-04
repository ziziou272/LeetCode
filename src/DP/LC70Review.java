package DP;
//dfs brutal force
public class LC70Review {
    public int climbStairs(int n) {
        if(n == 0)
            return 0;
        int [] count = new int[]{0};
        climbStairs(n, 0, count);
        return count[0];
    }

    private void climbStairs(int n, int cur, int[] count){
        if(cur > n)
            return;
        if(cur == n)
            count[0]++;
        for(int i = 1; i <= 2; i++){
            cur = cur + i;
            climbStairs(n, cur, count);
            cur = cur - i;
        }
    }
}
