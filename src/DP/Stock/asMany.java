package DP.Stock;

import java.util.Arrays;
import java.util.Comparator;

public class asMany {
    public int maxProfit(int[] prices) {
        int prevBuy = Integer.MIN_VALUE, prevSell = 0;
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int i = 0; i < prices.length; i++){
            int p = prices[i];
            buy = Math.max(buy, prevSell - p);
            sell = Math.max(sell, prevBuy + p);
            prevBuy = buy;
            prevSell = sell;
        }
        return sell;
    }
}
