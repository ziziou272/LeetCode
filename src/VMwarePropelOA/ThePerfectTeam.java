package VMwarePropelOA;

import java.util.HashMap;

public class ThePerfectTeam {
    public static void main(String[] args) {
        System.out.println(differentTeams("pcmbzpcmbz"));
    }

    public static int differentTeams(String skills){
        if(skills.length() < 5) return 0;
        int count = skills.length();
        HashMap<Character, Integer>map = new HashMap<>();
        for(int i = 0; i < skills.length(); i++) {
            char cur = skills.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for(int val : map.values()){
            count = Math.min(count, val);
        }
        return count;
    }


}
/*
* pcppccmbzbbzbzbz
* detaermined by the smallest count of letter
*
*
* */
