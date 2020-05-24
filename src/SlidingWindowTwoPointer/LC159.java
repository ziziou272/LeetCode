package SlidingWindowTwoPointer;
//todo:两个关键点：1.更新max是更新的有效window的最大值而不是在变化的时候更新 2.index1和2初始值为-1，这样可以保证在两个ch为空初始化的时候start为0
public class LC159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null||s.length() == 0)
            return 0;
        int start = -1, right = 0, idx1 = -1, idx2 = -1;
        char ch1 = '\0', ch2 = '\0';
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ch1){
                idx1 = i;
            }
            else if(s.charAt(i) == ch2){
                idx2 = i;
            }
            else {
                if(idx1 < idx2){
                    start = idx1 + 1;
                    ch1 = s.charAt(i);
                    idx1 = i;
                }
                else{
                    start = idx2 + 1;
                    ch2 = s.charAt(i);
                    idx2 = i;
                }
            }
            max = Math.max(i - start + 1, max);
        }
        return max;
    }
}
