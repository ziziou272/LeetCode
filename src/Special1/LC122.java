package Special1;

public class LC122 {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] - buyPrice > 0){
                profit += prices[i] - buyPrice;
                buyPrice = Integer.MAX_VALUE;
            }
            buyPrice = Math.min(buyPrice, prices[i]);
        }
        return profit;
    }
}
