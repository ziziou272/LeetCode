package AamazonOA2_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class countTeams {
    public static void main(String[] args) {
        System.out.println(countTeams(6, Arrays.asList(12, 4, 6, 13, 5, 10), 3, 4, 10));
    }

    public static int countTeams(int num, List<Integer> skills, int minAssociates, int minLevel, int maxLevel){
        List<Integer> candidates = new ArrayList<>();
        for(Integer level : skills){
            if(level <= maxLevel && level >= minLevel){
                candidates.add(level);
            }
        }
        if(candidates.size() < minAssociates)
            return 0;
        int sum = 0, size = candidates.size();
        for(int i = minAssociates; i <= size; i++){
            //3
            sum += getRes(1, size) / (getRes(1, i) * getRes(1,size - i));
        }
        return sum;
    }

    private static int getRes(int low, int hi){
        int res = 1;
        for(int i = low; i <= hi; i++){
            res *= i;
        }
        return res;
    }
}
