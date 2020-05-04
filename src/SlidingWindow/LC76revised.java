package SlidingWindow;

public class LC76revised {
    public String minWindow(String s, String t) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.length() == 0) return "";
        if(t == null || t.length() == 0) return s;
        if(s.length() < t.length()) return "";
        int[] key = new int[256];
        int[] value = new int[256];
        for(int i = 0; i < t.length(); i++) value[t.charAt(i)]++;
        int left = 0, right = 0, count = 0;
        while(right < s.length()){
            char curRight = s.charAt(right);
            if(key[curRight] < value[curRight])
                count++;
            key[curRight]++;
            while(count == t.length() && left <= right){
                if(sb.length() == 0 || sb.length() > right - left + 1){
                    sb.setLength(0);
                    sb.append(s, left, right + 1);
                }
                char curLeft = s.charAt(left);
                key[curLeft]--;
                if(key[curLeft] < value[curLeft])
                    count--;
                left++;
            }
            right++;
        }
        return sb.toString();
    }
}
class Solution2{
    //02/24/2020
    /*
    *
    ADOBECODEBANC   ABC
         s
                 f
    */
    public String minWindow(String s, String t) {
        //corner case
        if(s == null || s.length() < t.length()) return "";
        int slow = 0, fast = 0, min = Integer.MAX_VALUE, num = 0;
        int lenT = t.length(), lenS = s.length();
        int[] count = new int[256];
        int[] key = new int[256];
        for(int i = 0; i < t.length(); i++){
            if(key[t.charAt(i)]++ == 0)
                num++;
        }
        int[] res = new int[2];
        int counter = 0;
        while(fast < lenS){
            if(counter < num){
                char cur = s.charAt(fast);
                if(++count[cur] == key[cur]){
                    counter++;
                }
                fast++;
            }
            while(slow < fast && counter >= num){
                if(fast - slow < min){
                    res[0] = slow;
                    res[1] = fast;
                    min = fast - slow;
                }
                char slowChar = s.charAt(slow);
                if(--count[slowChar] < key[slowChar])
                    counter--;
                slow++;
            }
        }
        return s.substring(res[0], res[1]);
    }

}
