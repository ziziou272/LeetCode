package VMwarePropelOA;

import java.util.Arrays;

public class BuyBooks {
    public static void main(String[] args) {
        System.out.println();
    }
    public int buyBooks(int[] books, int[] price, int budget){
        int[][] dp = new int[books.length][budget+1];
        for(int j = 0; j <= budget; j++){
            if(j >= price[0]){
                dp[0][j] = books[0];
            }
        }
        int max = 0;
        for(int i = 1; i < books.length; i++){
            for(int j = 0; j <= budget; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= price[i]){
                    dp[i][j] = Math.max(dp[i][j], books[i] + dp[i-1][j-price[i]]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
/*
   budget: 8
*  books: 2 3 2 1 5 6 2
*  prices:5 3 2 1 1 9 6
*
 cost
   0 1 2 3 4 5 6 7 8
0  0 0 0 0 0 2 2 2 2
1  0 0 0 3 3 3 3 3 5
2  0 0 2 3 3
3
4
5
6



   [0][5] = 2
   [1][5] = 2
   [1][8] = 5

* */