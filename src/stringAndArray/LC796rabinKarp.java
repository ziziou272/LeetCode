package stringAndArray;

import java.math.BigInteger;
import java.util.Random;

public class LC796rabinKarp {
    public boolean rotateString(String a, String b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.length() == 0 && b.length() == 0) return true;
        if(a.length() != b.length()) return false;
        String newA = a + a;
        //big prime to prevent overflow
        long p = longRandomPrime();
        long target = hash(b, b.length(), p);
        long cur = hash(newA, b.length(), p);
        long factor = 1;
        for(int i = 1; i < b.length(); i++){
            factor = (factor * 256) % p;
        }
        int left = 0;
        for(int i = b.length(); i < newA.length(); i++){
            if(cur == target) return true;
            cur = (cur + p - (newA.charAt(left) * factor) % p) % p;
            cur = (cur * 256 + newA.charAt(i)) % p;
            left++;
        }
        return false;

    }
    private long hash(String str, int len, long q){
        long val = 0;
        for(int i = 0; i < len; i++){
            val = (val * 256 + str.charAt(i)) % q;
        }
        return val;
    }
    private long longRandomPrime(){
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
}
