package stringAndArray;

import java.util.Arrays;

public class LC395 {
}
class Solution1 {
    /*
        k = 2
        1 char
        [s,f)
        [0,0)
        s = 0
        f = 0
                 a b b b a a
                 s
                     f
        f - s

        a 2
        b 2
*/
    public int longestSubstring(String s, int k) {
        //cc
        if(s == null || s.length() < k) return 0;
        int[] count = new int[26];
        int maxLen = 0;
        for(int i = 1; i <= 26; i++){
            Arrays.fill(count, 0);
            int slow = 0, fast = 0, distinct = 0, repeatK = 0;
            while(fast < s.length()){
                if(distinct <= i){
                    int index = s.charAt(fast) - 'a';
                    if(count[index]++ == 0) distinct++;
                    if(count[index] == k) repeatK++;
                    fast++;
                }
                else{
                    int index = s.charAt(slow) - 'a';
                    if(count[index] == k) repeatK--;
                    if(--count[index] == 0) distinct--;
                    slow++;
                }
                if(distinct == repeatK && i == distinct)
                    maxLen = Math.max(maxLen, fast - slow);
            }
        }
        return maxLen;
    }
}
class Solution2{

}


