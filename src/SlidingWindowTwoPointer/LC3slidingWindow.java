package SlidingWindowTwoPointer;

import java.util.Arrays;

public class LC3slidingWindow {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        if(s.length() <= 1) return s.length();
        int[] arr = new int [256];
        Arrays.fill(arr, -1);
        int left = 0, right = 0, ans = 0;
        while(right < s.length()){
            char cur = s.charAt(right);
            if(arr[cur] != -1){
                left = Math.max(arr[cur] + 1, left);
            }
            arr[cur] = right;
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
class solution{
    //2020/02/24
    public int lengthOfLongestSubstring(String s) {
        //corner case
        if(s == null || s.length() == 0) return 0;
        int max = 0, slow = 0, fast = 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        while(fast < s.length()){
            char cur = s.charAt(fast);
            if(slow > map[cur])
                map[cur] = fast;
            else{
                slow = map[cur] + 1;
                map[cur] = fast;
            }
            fast++;
            max = Math.max(max, fast - slow);
        }
        return max;
    }
}
