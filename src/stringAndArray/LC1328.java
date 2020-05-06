package stringAndArray;

public class LC1328 {
}
//char array 或者stringbuilder要快些
class SolutionfromOther1328 {
    public String breakPalindrome(String palindrome) {
        char[] s = palindrome.toCharArray();
        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return String.valueOf(s);
            }
        }
        s[n - 1] = 'b'; //if all 'a'
        return n < 2 ? "" : String.valueOf(s);
    }
}
class SolutionIntuitive1328{
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1) return "";
        for(int i = 0; i < palindrome.length() / 2; i++){
            if(palindrome.charAt(i) != 'a'){
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i+1);
            }
        }
        return palindrome.substring(0, palindrome.length() - 1) + 'b';
    }
}
