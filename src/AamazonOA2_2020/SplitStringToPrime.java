package AamazonOA2_2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SplitStringToPrime {
    public static void main(String[] args) {
        System.out.println(countPrimeStrings("11373"));
        System.out.println(countPrimeStrings("2147483642"));
        System.out.println(countPrimeStrings("1335753715357"));
        System.out.println(countPrimeStrings("570033"));
        System.out.println(countPrimeStrings("173501"));

    }
    /*
    * 1 1 3 7 3
    * 0 1
    *
    * */
    public static int countPrimeStrings(String inputString){
        if(inputString == null || inputString.length() == 0) return 0;
        //HashSet<Integer> primeSet = getPrimeSet(1000000);
        int[] dp = new int[inputString.length() + 1];
        dp[0] = 1;
        for(int i = 0; i < inputString.length(); i++){
            if (inputString.charAt(i) == '0') continue;
            for(int j = 0; j < 6; j++){
                if(i - j >= 0 && inputString.charAt(i - j) != '0'){
                    int num = Integer.parseInt(inputString.substring(i - j, i + 1));
                    if(num < 2) continue;
                    if(isPrime(num)){
                        dp[i + 1] = (dp[i - j] + dp[i + 1]) % 1000000007;
                    }
                }
            }
        }
        return dp[inputString.length()];
    }

    private static boolean isPrime(int n){
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
    private static HashSet<Integer> getPrimeSet(int num){
        List<Integer> primeSet = new ArrayList<>();
        for(int i = 2; i <= num; i++){
            boolean isPrime = true;
            for(Integer prime : primeSet){
                if(i % prime == 0){
                    isPrime = false;
                    break;
                }
                if (prime * prime > i) break;
            }
            if(isPrime)
                primeSet.add(i);
        }
        return new HashSet<>(primeSet);
    }
}
class primeTest{
    public static int findPrimeNum (String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j <= len; j++) {
                if (dp[j] != 0 && isPrime(Integer.valueOf(s.substring(i, j)))) {
                    dp[i] += dp[j];
                }
            }
        }
        return dp[0];
    }

    public static boolean isPrime (int n){
        if(n < 2) return false;
        if(n == 2) return true;
        if(n % 2==0) return false;

        for(int i = 3; i * i <= n; i += 2) {
            if(n % i == 0) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "11373";
        System.out.println(findPrimeNum(s));
    }
}