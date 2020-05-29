package DP;

public class LC123 {
}
/*
9 1 6 3 3 7 8 9 2
        i


buy[] -> [-9 -1 -1  2  2  2           ]
sell[] -> [0  0  5  5  5  9   ]


1. buy1 ->  max(-price[i], buy[i -1])
2. sell1 -> max(buy[i-1] + price[i], sell[i-1])

you must sell the stock before you buy again

1. buy2 ->  max(sell1[i-1]- price[i], buy2[i -1])
2. sell2 -> max(buy2[i-1] + price[i], sell2[i-1])


return sell[n-1];

Optimization:
we could elminate these 4 arrays and just keep 4 variables

*/
class SolutionLC123noArray {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for(int i = 1; i < len; i++){
            int newBuy1 = Math.max(buy1, -prices[i]);
            int newSell1 = Math.max(sell1, buy1 + prices[i]);

            int newBuy2 = Math.max(buy2, sell1-prices[i]);
            int newSell2 = Math.max(sell2, buy2 + prices[i]);
            buy1 = newBuy1;
            sell1 = newSell1;
            buy2 = newBuy2;
            sell2 = newSell2;
        }
        return sell2;
    }
}
class SolutionLC123Array {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int[] buy1 = new int[len];
        int[] sell1 = new int[len];
        int[] buy2 = new int[len];
        int[] sell2 = new int[len];
        buy1[0] = -prices[0];
        sell1[0] = 0;
        buy2[0] = -prices[0];
        sell2[0] = 0;
        for(int i = 1; i < len; i++){
            buy1[i] = Math.max(buy1[i -1], -prices[i]);
            sell1[i] = Math.max(sell1[i - 1], buy1[i-1] + prices[i]);
            buy2[i] = Math.max(buy2[i -1], sell1[i-1]-prices[i]);
            sell2[i] = Math.max(sell2[i - 1], buy2[i-1] + prices[i]);
        }
        return sell2[len - 1];
    }
}
