package stringAndArray;

import java.util.HashMap;
import java.util.Map;

public class LC13RomanToInteger {
    private static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public int romanToInt(String s) {
        int sum = 0, i = 0;
        while(i < s.length()){
            int val = values.get(s.substring(i, i+1));
            if(i + 1 < s.length()){
                int nextVal = values.get(s.substring(i+1, i+2));
                if(nextVal > val){
                    sum += (nextVal - val);
                    i += 2;
                    continue;
                }
            }
            sum += val;
            i++;
        }
        return sum;
    }
}
