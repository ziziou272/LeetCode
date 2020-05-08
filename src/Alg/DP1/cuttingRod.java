package Alg.DP1;

public class cuttingRod {

}
class RodCutting
{
    /* Returns the best obtainable price for a rod of
       length n and price[] as prices of different pieces */
    static int cutRod(int price[],int n)
    {
        int[] dp = new int[n+1];
        dp[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++)
                if(j == i)
                    max_val = Math.max(max_val, price[j - 1]);
                else
                    max_val = Math.max(max_val,
                        price[j - 1] + dp[i-j]);
            dp[i] = max_val;
            System.out.println(i + ": " + dp[i]);
        }
        return dp[n];
    }

    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                cutRod(arr, size));
    }
}
