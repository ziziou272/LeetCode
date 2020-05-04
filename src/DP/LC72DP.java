package DP;
/*
dp填值的时候如果现在的i,j字母相同，要取dp[i - 1][j - 1]， 而不是三者中取小的，不然相同的character会被用多次
而且必须要设置额外的初始第一行和第一列

             0 1 2
             z o o
         0 z 0 1 2
         1 o 1 0
         2 o 2
         3 g 3
         4 e 4
         5 o 5

          0 s e a
       0  0 1 2 3
       e  1 1 1 2
       a  2 2 2 1
       t  3

0 1 2 3 4
h o r s e
r o s

p

           h o r s e
memo       0 1 2 3 4
    h   0  0 2 2 3 4
    o   1   1 2 3 4
    s   2  3 2 2 2 3


    insert      delete   replace
    i, j+1      i+1, j     i+1, j+1

*/
public class LC72DP {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        //first row
        for(int i = 0; i <= word1.length(); i++){
            memo[i][0] = i;
        }
        //first col
        for(int j = 1; j <= word2.length(); j++){
            memo[0][j] = j;
        }
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i - 1) == word2.charAt(j -1))
                    memo[i][j] = memo[i - 1][j - 1];
                else
                    memo[i][j] = Math.min(Math.min(memo[i - 1][j - 1], memo[i - 1][j]), memo[i][j - 1]) + 1;
            }
        }
        return memo[word1.length()][word2.length()];
    }
}
