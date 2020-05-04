package stringAndArray;

import java.lang.reflect.Array;
import java.util.Arrays;

//更general 不用split 有处理Let's go to 'New York'的能力
public class LC151Reverse2Time {
    public String reverseWords(String s) {
        if(s == null || s.length() ==0) return null;
        char [] chars = s.toCharArray();
        reverseWhole(chars);
        char [] charTrim = removeExtraSpace(chars);
        int slow = 0;
        for(int fast = 0; fast < charTrim.length; fast++){
            if(charTrim[fast] == ' '){
                reverseWord(charTrim, slow,fast - 1);
                slow = fast + 1;
            }
            if(fast == charTrim.length - 1){
                reverseWord(charTrim, slow,fast);
                slow = fast;
            }
        }
        return new String(charTrim, 0 , slow + 1);
    }
    private char [] reverseWhole(char [] chars){
        int left = 0;
        int right = chars.length - 1;
            while( left < right){
                char temp = chars [left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        return chars;
    }

    private char [] removeExtraSpace(char[] chars){//the the space right after the words
        int slow = 0;
        for(int fast = 0; fast < chars.length; fast++){
            if (chars[fast] != ' ' || (fast != 0 && chars[fast - 1]!= ' '))
                chars[slow++] = chars[fast];
        }
        if(slow == 0) return new char[0];
        return chars[slow - 1] ==' ' ? Arrays.copyOf(chars,slow - 1) : Arrays.copyOf(chars,slow);
    }

    private char [] swap(char[] chars, int left, int right){
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] =temp;
        return chars;
    }

    private char [] reverseWord(char [] chars, int left, int right){
        while (left < right)
        {
            swap(chars,left,right);
            left++;
            right--;
        }
        return chars;// do we need return anything?????

    }
}
