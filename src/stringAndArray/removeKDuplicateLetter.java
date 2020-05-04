package stringAndArray;

public class removeKDuplicateLetter {
    //[0, s) solution so far
    //[s, f) explored and i don't care / will be update or assign
    //[f, length - 1] unknown to explore
    public String remove(String s, int k){
        if(s == null || s.length() <= k) return s;
        char [] chars = s.toCharArray();
        int len = chars.length;
        int slow = k;
        for(int fast = k; fast < len; fast++){
            if(chars [fast] != chars[slow - k])
                chars[slow++] = chars[fast];
        }
        return new String(chars, 0, slow);
    }
}
