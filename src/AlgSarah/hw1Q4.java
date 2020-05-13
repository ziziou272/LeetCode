package AlgSarah;

public class hw1Q4 {
    public static void main(String[] args) {
        int[] m = new int[]{1,2,6,9,15,16,17,28,39};
        int[] p = new int[]{9,1,6,3,3,7,1,52,9};
        findMaxProfit test = new findMaxProfit();
        System.out.println(test.findMax1(m, p, 20));
        System.out.println(test.findMax2(m, p, 20));
    }
}
class findMaxProfit{
    public int findMax1(int[] m, int[] p, int k){
        int[] dp = new int[p.length];
        int max = 0;
        for(int i = 0; i < p.length; i++){
            int curMax = 0;
            for(int j = 0; j <= i; j++){
                if(m[i] - m[j] >= k)
                    curMax = p[i] + dp[j];
                else
                    curMax = p[i];
                dp[i] = Math.max(curMax, dp[i]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public int findMax2(int[] m, int[] p, int k){
        int[] location = findLocation(m , k);
        int[] dp = new int[p.length + 1];
        for(int i = 1; i <= p.length; i++){
            int build = dp[location[i]] + p[i - 1];
            int noBuild = dp[i - 1];
            dp[i] = Math.max(build, noBuild);
        }
        return dp[m.length];
    }

    private int[] findLocation(int[] m, int k){
        int[] location = new int[m.length + 1];
        for(int i = 1; i <= m.length; i++){
            int j = location[i - 1];
            while(m[i - 1] - m[j] >= k){
                j++;
            }
            location[i] = j;
        }
        return location;
    }
}
