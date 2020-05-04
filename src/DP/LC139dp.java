package DP;

import java.util.HashSet;
import java.util.List;

public class LC139dp {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> mySet = new HashSet<>();
        for(String word : wordDict){
            mySet.add(word);
        }
        boolean[] dp = new boolean [s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j<= i; j++){
                if(dp[j] && mySet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
