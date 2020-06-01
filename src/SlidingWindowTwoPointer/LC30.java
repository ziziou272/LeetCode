package SlidingWindowTwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC30 {
}
class SolutionLC30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0)
            return res;
        int wordLen = words[0].length();
        //num of distinct word
        int num = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(!map.containsKey(word)){
                num++;
                map.put(word,0);
            }
            map.put(word, map.get(word) + 1);
        }
        for(int i = 0; i < wordLen; i++){
            //copy of original map
            HashMap<String, Integer> curMap = new HashMap<>();
            int left = i;
            int right = left + words.length * wordLen;
            int curCount = initialize(left, right, s, map, curMap, wordLen);
            if(curCount == num) res.add(left);
            while(right + wordLen <= s.length()){
                String prev = s.substring(left, left+wordLen);
                left += wordLen;
                String next = s.substring(right, right+wordLen);
                right += wordLen;
                //remove one
                if(map.containsKey(prev)){
                    if(curMap.get(prev) == map.get(prev)){
                        curCount--;
                    }
                    curMap.put(prev, curMap.getOrDefault(prev, 0) - 1);
                    if(curMap.get(prev) == map.get(prev))
                        curCount++;
                }
                //add one
                if(map.containsKey(next)){
                    if(curMap.get(next) == map.get(next)){
                        curCount--;
                    }
                    curMap.put(next, curMap.getOrDefault(next, 0) + 1);
                    if(curMap.get(next) == map.get(next))
                        curCount++;
                }
                if(curCount == num) res.add(left);
            }
        }
        return  res;
    }
    private int initialize(int left, int right, String s, HashMap<String, Integer> map, HashMap<String, Integer> curMap, int len){
        int curCount = 0;
        while(left < right && left + len <= s.length()){
            String sub = s.substring(left, left + len);
            if(map.containsKey(sub)){
                if(curMap.get(sub) == map.get(sub)){
                    curCount--;
                }
                curMap.put(sub, curMap.getOrDefault(sub, 0) + 1);
                if(curMap.get(sub) == map.get(sub))
                    curCount++;
            }
            left += len;
        }
        return curCount;
    }

}
/*
words[] -> words[0].length() * words.length <= s.length
wordLength: words[0].length()
num = words.length

range: num * wordLength
[left,right)

"barfoofoobarthefoobarman" ["bar","foo","the"]
             l
                      r
 p          n

curCount: 1

map<String, Integer>

curMap<String, Integer>
bar: 1
foo: 1
the: 1

count == num -> add res
bar: 1
foo: 1
the: 1

*/