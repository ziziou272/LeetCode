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
class Solution309 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[1], -prices[0]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for(int i = 2; i < len; i++){
            buy[i] = Math.max(buy[i -1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i-1] + prices[i]);
        }
        return sell[len - 1];
    }
}