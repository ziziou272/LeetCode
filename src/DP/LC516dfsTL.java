package DP;
/*
Time limit exceed
             b b a b c
b                            b                                          x
b            bb                           b
a       bba            bb            ba               b
b      bbab      bba      bbb     bb      bab      bb     b
c  bbabc bbab bbac bba bbbc bbb bb bbc babc bab  bbc bb bc b



        b b a b a
     b
     b    1 1 3
     a      1 1 3
     b        1 1
     a          1


*/
public class LC516dfsTL {
    public int longestPalindromeSubseq(String s) {
        return dfs(s, 0, new StringBuilder());
    }
    private int dfs(String s, int index, StringBuilder sb){
        if(index == s.length()){
            if(isPali(sb.toString()))
                return sb.length();
            else
                return 0;
        }
        int add = dfs(s, index + 1, sb);
        sb.append(s.charAt(index));
        int notAdd = dfs(s, index + 1, sb);
        sb.setLength(sb.length() - 1);
        return Math.max(add, notAdd);
    }
    boolean isPali(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
