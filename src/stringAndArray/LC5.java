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
class DPSolutionLC5{
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int max = 0;
        int start = -1, end = -1;
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i + 1 <= 3){
                        dp[i][j] = j - i + 1;
                    }
                    else{
                        //这里i+1 和j-1不会越界，因为越界的情况都在j-i+1<=3的情况里边了
                        if(dp[i + 1][j - 1] != 0)
                            dp[i][j] = dp[i+1][j-1] + 2;
                    }
                    if(max < dp[i][j]){
                        max = dp[i][j];
                        start = i;
                        end = j;
                    }
                }
            }
        }
        //system
        return s.substring(start, end + 1);
    }
}
