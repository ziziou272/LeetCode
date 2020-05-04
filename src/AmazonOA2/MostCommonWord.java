package AmazonOA2;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        //cc
        if(paragraph == null || paragraph.length() == 0) return paragraph;
        //build bannedSet
        HashSet<String> bannedSet = new HashSet<>();
        for(String word : banned) bannedSet.add(word);
        //split string
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            if(!bannedSet.contains(word)){
                if(map.containsKey(word)){
                    map.put(word, map.get(word) + 1);
                }
                else
                    map.put(word, 1);
            }
        }
        String res = null;
        for(String key : map.keySet()){
            if(res == null || map.get(res) < map.get(key))
                res = key;
        }
        return res;
    }
}
