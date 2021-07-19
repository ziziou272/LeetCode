package VMwarePropelOA;

import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class FewestCoins {
    public static void main(String[] args) {
        System.out.println(fewestCoins("dabbcabcd"));
    }

    public static int fewestCoins(String coins){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char cur : coins.toCharArray()) map.putIfAbsent(cur, 0);
        int min = coins.length();
        for(int i = 0, j = 0; j < coins.length(); j++){
            char coin = coins.charAt(j);
            map.put(coin, map.get(coin) + 1);
            //if contains all elements
            while(valid(map)){
                min = Math.min(min, j - i + 1);
                char removedCoin = coins.charAt(i);
                map.put(removedCoin, map.get(removedCoin) - 1);
                i++;
            }
        }
        return min;
    }

    private static boolean valid(HashMap<Character, Integer> map){
        for(int val : map.values()){
            if(val == 0) return false;
        }
        return true;
    }
}
/*
[a:1
b:1
c:1
d:1

* abaabdccad
*     i
           j
*
* */
