package Special1;
//keep最小买入值和最大利润
public class LC121Revised {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices == null)
            return maxProfit;
        int minPurchase = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minPurchase);
            minPurchase = Math.min(minPurchase,prices[i]);
        }
        return maxProfit;
    }
}
