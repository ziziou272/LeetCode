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
class Solution122 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = -prices[0];
        sell[0] = 0;
        for(int i = 1; i < len; i++){
            buy[i] = Math.max(buy[i -1], sell[i-1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i-1] + prices[i]);
        }
        return sell[len - 1];
    }
}
/*
9 1 6 3 3 7 8 9 2
        i


buy[] -> [-9 -1 -1  2  2  2           ]
sell[] -> [0  0  5  5  5  9   ]


1. buy ->  max(sell[i-1] - price[i], buy[i -1])
2. sell -> max(buy[i-1] + price[i], sell[i-1])
3. do nothing

return sell[n-1];






*/