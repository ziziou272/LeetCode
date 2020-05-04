package stringAndArray;

public class LC409 {
    public int longestPalindrome(String s) {
        int[] counts = new int[256];
        if(s == null) return 0;
        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            counts[curChar]++;
        }
        int count = 0;
        for(int curCount : counts){
            if(curCount % 2 == 0)
                count += curCount;
            else
                count += curCount - 1;
        }
        return s.length() == count ? count : count + 1;

    }
}
