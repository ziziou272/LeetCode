package stringAndArray;

public class LC91Pruning {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        Integer[] dp = new Integer[s.length()];
        return numDecoding(s, 0, dp);
    }
    private int numDecoding(String s, int start, Integer[] dp){
        if(start > s.length() - 1){
            return 1;
        }
        if(dp[start] != null) return dp[start];
        if(s.charAt(start) == '0') {
            dp[start] = 0;
            return 0;
        }
        char cur = s.charAt(start);
        int next = 0, nextNext = 0;
        next = numDecoding(s, start + 1, dp);
        if((cur == '2' && (start + 1 < s.length() && s.charAt(start + 1) <= '6')) || cur=='1' && start != s.length() - 1)
            nextNext = numDecoding(s, start + 2, dp);
        dp[start] = next + nextNext;
        return dp[start];
    }
}
