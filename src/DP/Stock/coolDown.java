package DP.Stock;
//LC309
public class coolDown {
    public int maxProfit(int[] prices) {
        int prevPrevBuy = Integer.MIN_VALUE, prevPrevSell = 0;
        int prevBuy = Integer.MIN_VALUE, prevSell = 0;
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int i = 0; i < prices.length; i++){
            int p = prices[i];
            buy = Math.max(buy, prevPrevSell - p);
            sell = Math.max(sell, prevBuy + p);
            prevPrevBuy = prevBuy;
            prevPrevSell = prevSell;
            prevBuy = buy;
            prevSell = sell;
        }
        return sell;
    }
}
