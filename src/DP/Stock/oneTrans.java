package DP.Stock;
//121
public class oneTrans {
    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for(int p : prices){
            max = Math.max(max, p - min);
            min = Math.min(min, p);
        }
        return max;
    }
}
