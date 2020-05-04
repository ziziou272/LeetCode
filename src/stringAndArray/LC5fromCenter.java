package stringAndArray;
/*

      b a b a b c b a a
          l   r
      b
       ba
       b a b
         ab
           b a  b
            ab
               b
*/
//中间往两边走  for loop 每次以i为中点或者以i和i+1为中点(奇数偶数)
public class LC5fromCenter {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        String res = "";
        for(int i = 0; i < s.length(); i++){
            String temp = "";
            temp = search(i, i, s);
            if(temp.length() > res.length())
                res = temp;
            temp = search(i, i + 1, s);
            if(temp.length() > res.length())
                res = temp;
        }
        return res;
    }
    private String search(int left, int right, String s){
        //base case
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            right++;
            left--;
        }
        return s.substring(left + 1, right);
    }

}
