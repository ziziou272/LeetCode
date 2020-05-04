package stringAndArray;

import java.math.BigInteger;
import java.util.Random;

public class LC28robinKarp {
    public int strStr(String haystack, String needle) {
        //rabin karp
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) return -1;
        int len1 = haystack.length(), len2 = needle.length();
        long q = longRandomPrime();
        long needleHash = hash(needle, needle.length(), q);
        long highRadix = 1;
        for(int i = 0; i < len2 - 1; i++){
            highRadix = (256 * highRadix) % q;
        }
        //check first needle length
        long hayHash = hash(haystack, needle.length(), q);
        if(hayHash == needleHash && check(haystack, 0, needle)) return 0;
        int j = 0;
        for(int i = len2; i < len1; i++){
            j++;
            hayHash = (hayHash + q - (haystack.charAt(j - 1) * highRadix) % q) % q;
            hayHash = (hayHash * 256 + haystack.charAt(i)) % q;
            if(hayHash == needleHash && check(haystack, j, needle)) return j;
        }
        return -1;
    }
    private long hash(String str, int len, long q){
        long val = 0;
        for(int i = 0; i < len; i++){
            val = (val * 256 + str.charAt(i)) % q;
        }
        return val;
    }

    private boolean check(String str1, int offset, String str2){
        for(int i = 0; i < str2.length(); i++){
            if(str1.charAt(i + offset) != str2.charAt(i))
                return false;
        }
        return true;
    }
    private long longRandomPrime(){
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
}
