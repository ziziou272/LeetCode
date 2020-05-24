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
