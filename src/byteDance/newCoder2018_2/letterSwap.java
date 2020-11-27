package byteDance.newCoder2018_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class letterSwap {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split("\\s+");
        String input = arr[0];
        int val = Integer.parseInt(arr[1]);
        System.out.println(getMaxLength(input, val));
    }
    private static int getMaxLength(String s, int m){
        List<List<Integer>> positions = new ArrayList<>();
        for(int i = 0; i < 26; i++) positions.add(new ArrayList<>());
        for(int i = 0; i < s.length(); i++){
            positions.get(s.charAt(i) - 'a').add(i);
        }
        int max = 0;
        for(int i = 0; i < 26; i++){
            //dp for each letter
            List<Integer> position = positions.get(i);
            int size = positions.get(i).size();
            if( size != 0){
                int[][] dp = new int[size][size];
                for(int j = size - 1; j >= 0; j--){
                    //j == k ==> 0
                    for(int k = j + 1; k < size; k++){
                        if(k - j == 1){
                            dp[j][k] = position.get(k) - position.get(j) - 1;
                        }else{
                            /////
                            dp[j][k] = dp[j + 1][k - 1] + position.get(k) - position.get(j) - 1 - (k - j -1);
                        }
                        if(dp[j][k] <= m) max = Math.max(max, k - j + 1);
                    }
                }
            }
        }
        return max;
    }
}
