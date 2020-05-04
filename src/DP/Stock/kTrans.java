package DP.Stock;

public class kTrans {
    // 1 3 5 2 4 6 1 2 3
    /*
    // day i:
    1st
    buy1: max(buy, -p)
    sell1: max (sell, prevBuy + p)
    2nd
    buy: max(buy, sell1-p)
    sell: max(sell, prevBuy2 + p)
    3rd
    //
    */
    public int maxProfit(int k, int[] prices) {
        int[] buys = new int[k + 1];
        int[] sells = new int[k + 1];
        for(int times = 1; times < k; times++){
            for(int i = 0; i < prices.length; i++){
                sells[times] = Math.max(sells[times], buys[times] + prices[i]);
                buys[times] = Math.max(buys[times - 1], -prices[i]);
            }
        }
        return sells[k];
    }
}
