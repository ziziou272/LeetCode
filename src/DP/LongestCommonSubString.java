package DP;

public class LongestCommonSubString {
    public static void main(String[] args){
        sol test = new sol();
        System.out.println(test.longestCommonString("abcdfg","acdefsdsbcdff"));

    }
    /*

    "b s b i n i m k"
   j 0 0 0 0 0 0 0 0
   m 0 0 0 0 0 0 1
   j 0
   k 0
   b 1
   k 1
   j 1
   k 1
   v 1

   abace

   ace


  0 a b a c e
0 0 0 0 0 0 0
a 0 1 0 1 0 0
c 0 0 0 0 2 0
e 0
not equal find max from left/up/
equal     max + 1

*/
}
class sol{
    public int longestCommonString(String text1, String text2) {
        //corner case
        //corner case
        if(text1 == null || text2 == null) return 0;
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = 0;
        for(int k = 0; k <= len1; k++){
            for(int l = 0; l <= len2; l++){
                if(k == 0 || l == 0)
                    dp[k][l] = 0;
                else if(text1.charAt(k - 1) == text2.charAt(l - 1)){
                    dp[k][l] = dp[k - 1][l - 1] + 1;
                }
                else{
                    dp[k][l] = 0;
                }
                max = Math.max(dp[k][l], max);
            }
        }
        return max;
    }
}
