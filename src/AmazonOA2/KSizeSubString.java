package AmazonOA2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KSizeSubString {
    public static List<String> kSubstring(String s, int k) {
        List<String> res = new ArrayList<>();
        //size of s smaller than k
        if(s == null || s.length() < k) return res;
        if(s.length() == k){
            res.add(s);
            return res;
        }
        HashSet<String> preRes = new HashSet<>();
        //check duplicate
        int[] count = new int[256];
        for(int left = 0, right = 0; right < s.length(); right++){
            count[s.charAt(right)]++;
            while(left < right && count[s.charAt(right)] > 1)
                count[s.charAt(left++)]--;
            //valid result
            if(right - left == k - 1){
                preRes.add(s.substring(left, right + 1));
                count[s.charAt(left++)]--;
            }
        }
        return new ArrayList<>(preRes);
    }
    public static void main(String[] args) {
        System.out.println(kSubstring("awaglknagawunagwkwagl", 6));
        System.out.println(kSubstring("abcabc", 3));
        System.out.println(kSubstring("abacab", 2));
    }
    //Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
}
