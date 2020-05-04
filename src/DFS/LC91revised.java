package DFS;

import java.util.Arrays;

public class LC91revised {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0, memo);
    }
    private int dfs(String s, int index, int[] memo){
        if(index >= s.length()) return 1;
        if(memo[index] != -1) return memo[index];
        if(s.charAt(index) == '0') return 0;
        int oneDigit = dfs(s, index + 1, memo);
        int twoDigit = 0;
        if(index + 1 < s.length() && (s.charAt(index) - '0') * 10 + s.charAt(index + 1) - '0' <= 26)
            twoDigit = dfs(s, index + 2, memo);
        memo[index] = oneDigit + twoDigit;
        return memo[index];
    }
}
