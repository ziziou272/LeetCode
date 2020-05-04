package DP;

public class LC70SuanFaGe {
    public int climbStairs(int n) {
        if(n <= 1) return n;
        int m1 = 1;
        int m2 = 1;
        for(int i = 2; i <= n; i++){
            int temp = m1 + m2;
            m1 = m2;
            m2 = temp;
        }
        return m2;
    }
}
