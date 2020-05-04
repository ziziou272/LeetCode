package stringAndArray;

public class LC5DP {
    public String longestPalindrome(String s) {
        if(s == null || s.length()<= 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] position = new int[]{0, 0};
        int len = s.length();
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                int size = j - i + 1;
                if(s.charAt(i) == s.charAt(j) && (size <= 2 || dp[i + 1][j - 1])){
                    if(size > position[1] - position[0] + 1){
                        position[0] = i;
                        position[1] = j;
                    }
                    dp[i][j] = true;
                }
                else
                    dp[i][j] = false;
            }
        }
        return s.substring(position[0], position[1] + 1);
    }
    /*
       0 1 2 3
       c b b d
   0 c t f f f
   1 b   t t f
   2 b     t f
   3 d       t





0-1
1-2
2-3
3-4
4-5

0-2
1-3

        0 1 2 3 4
        a b a b a
    0 a t f t f t
    1 b   t f t f
    2 a     t f t
    3 b       t f
    4 a         t




*/
}
