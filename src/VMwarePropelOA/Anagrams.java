package VMwarePropelOA;

import java.lang.reflect.Array;
import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println(funWithAnagrams(new String[]{"code", "doce", "ecod", "framer", "frame"}));
    }
    public static List<String> funWithAnagrams(String[] text){
        //[a-z] -> int[26] --> arr to string
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(String str : text){
            int[] arr = new int[26];
            for(int i = 0; i < str.length(); i++){
                arr[str.charAt(i) - 'a']++;
            }
            String code = Arrays.toString(arr);
            if(!set.contains(code)){
                set.add(code);
                res.add(str);
            }
        }
        return res;
    }
}
