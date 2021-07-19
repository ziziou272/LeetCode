package VMwarePropelOA;

public class BreakPalindrome {
    public static void main(String[] args) {

    }

    public String breakPalindrome(String palindrome) {
        if(palindrome == null || palindrome.length() <= 1) return "";
        int len = palindrome.length();
        for(int i = 0; i < len/2; i++){
            if(palindrome.charAt(i) != 'a'){
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i+1, len);
            }
        }
        return palindrome.substring(0, len-1) + 'b';
    }
    public String breakPalindrome2(String palindrome) {
        if(palindrome == null || palindrome.length() <= 1) return "";
        char[] array = palindrome.toCharArray();
        int len = array.length;

        for (int i = 0; i < len / 2; i++) {
            if (array[i] != 'a') {
                array[i] = 'a';
                return String.valueOf(array);
            }
        }
        array[len - 1] = 'b';
        return String.valueOf(array);
    }

}
