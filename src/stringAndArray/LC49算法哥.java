package stringAndArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC49算法哥 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        char[] key = new char[26];

        for(int i = 0; i < strs.length; i++){
            for(int k = 0; k < 26; k++) key[k] = '0';
            for(int j = 0; j < strs[i].length(); j++){
                char cur = strs[i].charAt(j);
                key[cur - 'a'] = (char) (key[cur - 'a'] + 1);
            }
            String keyString = String.valueOf(key);
            if(map.containsKey(keyString)){
                map.get(keyString).add(strs[i]);
            }
            else{
                map.put(keyString, new ArrayList<String>());
                map.get(keyString).add(strs[i]);
            }
        }
        for(String curKey : map.keySet()){
            res.add(map.get(curKey));
        }
        return res;
    }
}
