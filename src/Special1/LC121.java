package Special1;
//brutal force
public class LC121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices == null)
            return maxProfit;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                maxProfit = Math.max(maxProfit, prices[j]- prices[i]);
            }
        }
        return maxProfit;
    }
}
