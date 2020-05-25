package SlidingWindowTwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC244 {
}
class WordDistance {
    String[] words;
    HashMap<String, List<Integer>> map;

    public WordDistance(String[] words) {
        this.words = words;
        this.map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])){
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        if(!map.containsKey(word1) || !map.containsKey(word2)) return -1;
        List<Integer> a = map.get(word1);
        List<Integer> b = map.get(word2);
        int i = 0, j = 0;
        int len = Integer.MAX_VALUE;
        while(i < a.size() && j < b.size()){
            len = Math.min(len, Math.abs(a.get(i) - b.get(j)));
            if(a.get(i) < b.get(j)){
                i++;
            }else
                j++;
        }
        return len;
    }

}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);

 len = 1
 a (6,8,12)
 s

 b(2,7,9)
 f
 */