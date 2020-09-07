package Cisco;

import java.util.*;

public class DecodeWays {
    public static void decodeWays() {
        // collect the input
        Scanner keyboard = new Scanner(System.in);
        String s = keyboard.nextLine();

        // init the map
        Map<Integer, Integer> map = new HashMap<>();

        // call helper and print the result
        System.out.println(helper(s, 0, map));
    }

    private static int helper(String s, int start, Map<Integer, Integer> map) {
        // base case
        int res = 0;
        // if seen before
        if (map.containsKey(start)) return map.get(start);
        // if reach the end
        if (start == s.length()) res = 1;

        // recursion
        for (int end = start + 1; end <= start + 2 && end <= s.length(); end++) {
            String numS = s.substring(start, end);
            // avoid the number starting with 0
            if (numS.length() > 1 && numS.charAt(0) == '0') continue;
            // check if in 0-25
            int num = Integer.parseInt(numS);
            if (num >= 0 && num <= 25) {
                res += helper(s, end, map);
            }
        }

        // return
        map.put(start, res);
        return res;
    }


    public static void main(String[] args) {
        decodeWays();
    }
}
