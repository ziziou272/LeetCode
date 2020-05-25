package SlidingWindowTwoPointer;

public class LC243 {
}
class Solution243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0) return -1;
        int len = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            if(cur.equals(word1)){
                index1 = i;
            }
            else if(cur.equals(word2)){
                index2 = i;
            }
            if(index1 != -1 && index2 != -1)
                len = Math.min(len, Math.abs(index1 - index2));
        }
        return len;
    }
}
/*
word1 = a, word 2 = b
index1  8
index2 7
1

0 1 2 3 4 5 6 7 8 9 10
a c d a e a b c b e a


*/
