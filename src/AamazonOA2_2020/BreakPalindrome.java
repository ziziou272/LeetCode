package AamazonOA2_2020;

public class BreakPalindrome {
    public static void main(String[] args) {

    }
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1) return "";
        for(int i = 0; i < palindrome.length() / 2; i++){
            if(palindrome.charAt(i) != 'a'){
                String res = palindrome.substring(0, i) + 'a' + palindrome.substring(i+1);
                if(res.compareTo(palindrome) < 0)
                    return res;
                else
                    return "";
            }
        }
        return "";
    }

    public String breakPalindrome2(String s) {
        if(s == null || s.length() <= 1) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur != 'a'){
                sb.append('a').append(s.substring(i+1));
                break;
            }else{
                sb.append('a');
            }
        }
        if(isPalindrome(sb.toString())){
            return "";
        }
        return sb.toString();
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
