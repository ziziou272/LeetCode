package DP.KnapsackProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LC518dfs {//超时
    public int change(int amount, int[] coins) {
        int[] count = new int[1];
        if(coins == null) return 0;
        dfs(coins, count, 0, amount);
        return count[0];
    }
    private void dfs(int[] coins, int[] count, int level, int balance){
        if(balance == 0){
            count[0]++;
            return;
        }
        if(balance < 0 || level == coins.length) return;
        int times = balance / coins[level] + 1;
        for(int i = 0; i < times; i++){
            int newBalance = balance - i * coins[level];
            dfs(coins, count, level + 1, newBalance);
        }
    }
    public static class MainClass {
        public static int[] stringToIntegerArray(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return new int[0];
            }

            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for(int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int amount = Integer.parseInt(line);
                line = in.readLine();
                int[] coins = stringToIntegerArray(line);

                int ret = new LC518dfs().change(amount, coins);

                String out = String.valueOf(ret);

                System.out.print(out);
            }
        }
    }
}
