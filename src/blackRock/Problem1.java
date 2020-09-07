package blackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Problem1 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

    }

    public static void calculateChange(double purchasePrice, double cash) {
        // Access your code here. Feel free to create other classes as required
        double totalAmount = cash - purchasePrice;

        // corner: if change is 0
        if (totalAmount == 0) {
            System.out.println("Zero");
            return;
        }

        // corner: if change < 0
        if (totalAmount < 0) {
            System.out.println("ERROR");
            return;
        }

        // get the pound amount and the pence amount
        int poundAmount = (int) totalAmount;
        int penceAmount = (int) ((totalAmount - poundAmount) * 100);

        // init the pound and pence arrays
        Map<Integer, String> map = new HashMap<>();
        int[] changeArr = new int[] {1, 2, 5, 10, 20, 50};
        map.put(1, "One");
        map.put(2, "Two");
        map.put(5, "Five");
        map.put(10, "Ten");
        map.put(20, "Twenty");
        map.put(50, "Fifty");

        // get the change for pound and pence
        String poundChange = helper(true, poundAmount,changeArr, map);
        String penceChange = helper(false, penceAmount, changeArr, map);

        System.out.println(poundChange + ", " + penceChange);

    }

    private static String helper(boolean isPound, int amount, int[] coins, Map<Integer, String> map) {
        // init dp array
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // init the from array
        int[] from = new int[amount + 1];

        // traverse and fill
        for (int i = 1; i <= amount; i++) {
            // try each coin
            for (int coin: coins) {
                if (i - coin >= 0 && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    from[i] = coin;
                }
            }
        }

        String res = "";
        List<Integer> changes = new ArrayList<>();

        // add res to changes
        while (amount > 0) {
            changes.add(from[amount]);
            amount = amount - from[amount];
        }

        // sort the changes
        Collections.sort(changes);

        // add to result
        for (int i = changes.size() - 1; i >= 0; i--) {
            res = res + map.get(changes.get(i)) + " ";
            if (isPound && changes.get(i) == 1) res += "Pound";
            else if (isPound) res += "Pounds";
            else res += "Pence";
            if (i != 0) res = res + ", ";
        }
        return res;
    }

}