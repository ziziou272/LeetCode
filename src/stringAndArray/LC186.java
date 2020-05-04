package stringAndArray;

public class LC186 {
    public void reverseWords(char[] s) {
        reverseWhole(s, 0, s.length - 1);
        int slow = 0;
        for(int fast = 0; fast < s.length; fast++){
            if(s[fast] == ' '){
                reverseWhole(s, slow, fast - 1);
                slow = fast + 1;
            }
            if(fast == s.length - 1){
                reverseWhole(s,slow, fast);
            }
        }
    }
    private void reverseWhole(char [] s, int left, int right){
        while (left < right){
            swap(s, left, right);
            left++;
            right--;
        }
    }
    private void swap(char [] chars,int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
