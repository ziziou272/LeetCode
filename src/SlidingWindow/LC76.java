package SlidingWindow;

public class LC76 {
    public String minWindow(String s, String t) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.length() == 0) return "";
        if(t == null || t.length() == 0) return s;
        if(s.length() < t.length()) return "";
        int[] key = new int[256];
        int[] value = new int[256];
        for(int i = 0; i < t.length(); i++) value[t.charAt(i)]++;
        int left = 0, right = 0;
        while(right < s.length()){
            key[s.charAt(right)]++;
            while(checkValid(t, key, value, left, right)){
                if(sb.length() == 0 || sb.length() > right - left + 1){
                    sb.setLength(0);
                    sb.append(s, left, right + 1);
                }
                key[s.charAt(left)]--;
                left++;
            }
            //map[s.charAt(right)]++;
            right++;

        }
        return sb.toString();
    }
    private boolean checkValid(String t, int[] key, int[] value, int left, int right){
        if(right - left + 1 < t.length()) return false;
        for(int i = 0; i< t.length(); i++){
            if(key[t.charAt(i)] < value[t.charAt(i)]) return false;
        }
        return true;
    }
}
