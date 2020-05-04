package DP.Stock;
//lc123
public class twoTrans {
    public int maxProfit(int k, int[] prices) {
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
        int[] buys = new int[k + 1];
        int[] sells = new int[k + 1];
        for(int times = 0; times <= k; times++){
            buys[times] = Integer.MIN_VALUE;
        }
        for(int i = 0; i < prices.length; i++){
            for(int times = 1; times <= k; times++){
                sells[times] = Math.max(sells[times], buys[times] + prices[i]);
                buys[times] = Math.max(buys[times], sells[times - 1] - prices[i]);
            }
        }
        return sells[k];
    }
}
