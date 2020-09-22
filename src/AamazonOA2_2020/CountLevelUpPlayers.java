package AamazonOA2_2020;

import java.util.Arrays;
import java.util.List;

public class CountLevelUpPlayers {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(countNum(3, 5, Arrays.asList(100,50,50,50,25)));
        System.out.println(countNum(3, 4, Arrays.asList(100,50,50,25)));
        System.out.println(countNum(4, 5, Arrays.asList(2,2,3,4,5)));
    }

    public static int countNum(int cutOffRank, int num, List<Integer> scores){
        if(scores == null || scores.size() == 0 || num == 0 || cutOffRank == 0) return 0;
        int[] scoresArr = new int[101];
        for(int score : scores){
            scoresArr[score]++;
        }

        int count = 0;
        for(int i = 100; i > 0; i--){
            count += scoresArr[i];
            if(count >= cutOffRank) return count;
        }
        return count;
    }
}
