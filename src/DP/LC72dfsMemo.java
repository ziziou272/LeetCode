package DP;
/*
h orse
r os

p

memo      0 1 2 3 4 5
       0
       1
       2
       3

    insert      delete   replace
    i, j+1      i+1, j     i+1, j+1

*/
public class LC72dfsMemo {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int i = 0; i < word1.length(); i++){
            for(int j = 0; j < word2.length(); j++){
                memo[i][j] = -1;
            }
        }
        return dfs(word1, word2, 0, 0, memo);

    }
    private int dfs(String word1, String word2, int i, int j, int[][] memo){
        if(j == word2.length())
            return word1.length() - i;
        if(i == word1.length())
            return word2.length() - j;
        if(memo[i][j] != -1) return memo[i][j];
        if(word1.charAt(i) == word2.charAt(j)){

            memo[i][j] = dfs(word1, word2,i+1, j+1, memo);
        }
        else{
            memo[i][j] = Math.min(Math.min(dfs(word1, word2,i+1, j+1, memo),dfs(word1, word2,i, j+1,memo)), dfs(word1, word2,i+1, j,memo)) + 1;
        }
        return memo[i][j];
    }
}
