package stringAndArray;
//brutal force 还有额外空间 超时 垃圾
import java.util.ArrayList;
import java.util.List;

public class LC5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return s;
        List<String> myList = new ArrayList<>();
        char [] charArray = s.toCharArray();
        int curSize = 0, preSize = 0;
        for(int i = 0; i < charArray.length; i++){
            curSize = myList.size();
            myList.add(new String(charArray, i, 1));
            for(int j = preSize; j < curSize; j++){
                myList.add(new String(myList.get(j) + charArray[i]));
            }
            preSize = curSize;
        }
        int max = 0, maxIndex = 0;
        for(int k = 0; k < myList.size(); k++){
            String temp = myList.get(k);
            if(checkPalindrome(temp) && temp.length()> max){
                maxIndex = k;
                max = temp.length();
            }
        }
        return myList.get(maxIndex);
    }

    private boolean checkPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
