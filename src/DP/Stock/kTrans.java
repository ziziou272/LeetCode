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
class SolutionKTrans {
    public int maxProfit(int k, int[] prices) {
        if(k <= 0) return 0;
        if(prices == null || prices.length <= 1)
            return 0;
        if(k >= prices.length / 2){
            int buy = Integer.MIN_VALUE, prevBuy = Integer.MIN_VALUE;
            int sell = 0, prevSell = 0;
            for(int p : prices){
                buy = Math.max(buy, prevSell-p);
                sell = Math.max(sell, prevBuy + p);
                prevBuy = buy;
                prevSell = sell;
            }
            return sell;
        }
        int len = prices.length;
        int[] buys = new int[k+1];
        int[] sells = new int[k+1];
        for(int i = 0; i <= k; i++){
            buys[i] = Integer.MIN_VALUE;
        }
        for(int i = 0; i < len; i++){
            for(int j = 1; j <= k; j++){
                int newBuy = Math.max(sells[j-1]-prices[i], buys[j]);
                int newSell = Math.max(buys[j]+prices[i], sells[j]);
                buys[j] = newBuy;
                sells[j] = newSell;
            }
        }
        return sells[k];
    }
}
/*
9 1 6 3 3 7 8 9 2
        i


buy -> [    ]
sell -> [ ]


1. new buy[k-1] ->  max(sell[k-2]-price[i], buy[k-1])
2. sell[k-1] -> max(buy[k-1] + price[i], sell[k -1])
                    not updated
*/