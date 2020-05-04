package DP;

public class LC647 {
    public int countSubstrings(String s) {
        //corner case
        if(s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int res = 0;
        for(int i = 0; i < len; i++){
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
}
