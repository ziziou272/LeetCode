package SlidingWindowTwoPointer;

public class LC424 {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0)
            return 0;
        if(k > s.length())
            return s.length();

        int start = 0, res = 0;
        char maxCount = '\0';
        int [] count = new int [26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            count[ch - 'A']++;
            if (maxCount == '\0' || count[ch - 'A'] > count[maxCount - 'A'])
                maxCount = ch;
            while(i - start + 1 - count[maxCount - 'A'] > k){
                count[s.charAt(start) - 'A']--;
                start++;
                for(int j = 0; j < 26; j++){
                    if(count[j] > count[maxCount -'A'])
                        maxCount = (char)(j + 'A');
                }
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
class Solution424 {
    public int characterReplacement(String s, int k) {
        if(s == null) return 0;
        if(s.length() <= k) return s.length();
        int i = 0, j = 0;
        int n = 0, max = 0;
        int[] map = new int[26];
        while(j < s.length()){
            char cur = s.charAt(j);
            n = Math.max(n, ++map[cur - 'A']);
            if(j - i + 1 - n > k){
                map[s.charAt(i++) - 'A']--;
            }
            j++;
            max = Math.max(max, j - i);
        }
        return max;
    }
}
/*
len:  repeat chars + others
           n            k

[i,j)-> j - i
k=2

int[]map 1 0 5 2...
ABBAACCACCDCD
      i
            j

n: 4 -> A
others: j - i - n > k?

update max
1. findMax(int[] map) -> travese map find max -> o(26) -> o(1)
2. when not valid, our target is changed to find a repeate number that has n+1 count in range i to j
there may in some scenerio is not valid during find n+1, but does not matter



AAAXX -> n +k
AAXXAA

*/