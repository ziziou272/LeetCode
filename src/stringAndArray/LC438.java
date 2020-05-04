package stringAndArray;

import java.util.ArrayList;
import java.util.List;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null && p == null) return res;
        if(p == null || p.length() == 0){
            for(int i = 0; i < s.length(); i++)
                res.add(i);
            return res;
        }
        int pSize = p.length();
        if(s.length() < pSize) return res;
        char[] key = new char[26];
        for(int i = 0; i < 26; i++) key[i] = '0';
        for(int i = 0; i < pSize; i ++){
            char cur = p.charAt(i);
            key[cur - 'a'] = (char)(key[cur - 'a'] + 1);
        }
        String valueString = String.valueOf(key);
        //reset key array
        for(int i = 0; i < 26; i++) key[i] = '0';
        //traverse string s
        for(int i = 0, start = 0; i < s.length(); i++){
            key[s.charAt(i) - 'a'] = (char)(key[s.charAt(i) - 'a'] + 1);
            if(i - start + 1 < pSize){
                continue;
            }
            String keyString = String.valueOf(key);
            if(keyString.equals(valueString))
                res.add(start);
            key[s.charAt(start) - 'a'] = (char)(key[s.charAt(start) - 'a'] - 1);
            start++;
        }
        return res;
    }
}
