package stringAndArray;

public class LC28KMP {
    public int strStr(String haystack, String needle) {
        //kmp
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0) return -1;
        int len1 = haystack.length(), len2 = needle.length();
        int[][] dfa = new int[256][len2];
        dfa[needle.charAt(0)][0] = 1;
        setDfa(dfa, needle);
        return search(dfa, haystack, needle);
    }

    private void setDfa(int[][] dfa, String needle){
        for(int i = 0, j = 1; j < needle.length(); j++){
            for(int k = 0; k < 256; k++){
                dfa[k][j] = dfa[k][i];
            }
            dfa[needle.charAt(j)][j]= j + 1;
            i = dfa[needle.charAt(j)][i];
        }
    }

    private int search(int[][] dfa, String haystack, String needle){
        int i, j;
        for(i = 0, j = 0; i < haystack.length() && j < needle.length(); i++){
            j = dfa[haystack.charAt(i)][j];
        }
        if(j == needle.length()) return i - needle.length();
        return -1;
    }
}
