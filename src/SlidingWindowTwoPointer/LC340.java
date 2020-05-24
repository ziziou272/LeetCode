package SlidingWindowTwoPointer;

public class LC340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //cc
        if(s == null || s.length() == 0 || k == 0)
            return 0;
        if(k > s.length())
            return s.length();
        int maxLength = 0;
        int [] count = new int[256];
        int start = 0;
        int length = 0;
        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            if (count[s.charAt(i)]++ == 0)
                counter++;
            while(counter > k){
                count[s.charAt(start)]--;
                if(count[s.charAt(start)] == 0){
                    counter--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
