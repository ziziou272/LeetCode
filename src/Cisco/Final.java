public class Final {
    public static int maxQuality(String s) {
        // base
        int n = s.length();
        if (n < 2) return 0;
        int[] dp = new int[n];
        dp[0] = 0;

        dp[1] = groupScore(s, 0, 1);
        if (n < 3) return dp[1];
        dp[2] = groupScore(s, 0, 2);

        // traverse
        int maxScore = Math.max(dp[1], dp[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 3] + groupScore(s, i - 2, i), dp[i - 2] + groupScore(s, i - 1, i));
            maxScore = Math.max(maxScore, dp[i]);
        }

        return dp[n - 1];
    }

    private static int groupScore(String s, int start, int end) {
        int len = end - start + 1;
        if (len == 3) {
            if (s.charAt(start) == s.charAt(start + 1) &&  s.charAt(start + 1) == s.charAt(start + 2)) return 2;
            else if (s.charAt(start) == s.charAt(start + 1) || s.charAt(start + 1) == s.charAt(start + 2)
            || s.charAt(start) == s.charAt(start + 2)) return 1;
            else return 0;
        }
        else {
            if (s.charAt(start) == s.charAt(end)) return 2;
            else return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxQuality("000222"));
    }
}
