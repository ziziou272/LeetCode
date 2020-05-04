package DFS;

public class LC10dfs {
    public boolean isMatch(String s, String p) {
        //cc
        return dfs(s, 0, p, 0);
    }
    private boolean dfs(String s, int idxS, String p, int idxP){
        //base case
        if(idxP == p.length()) return idxS == s.length();
        //not *
        if(idxP == p.length() - 1 || p.charAt(idxP + 1) != '*'){
            //match
            if(idxS < s.length() && isMatch(s.charAt(idxS), p.charAt(idxP)))
                return dfs(s, idxS + 1, p, idxP + 1);
        }
        //*
        //s: aaaaaaaaaaa
        //p: a*a*a*a*a*a*b
        //o(n!)
        else{
            int i = idxS - 1;
            while(i == idxS - 1 || (i < s.length() && isMatch(s.charAt(i), p.charAt(idxP)))){
                if(dfs(s, i + 1, p, idxP + 2))
                    return true;
                i++;
            }
        }
        return false;
    }
    private boolean isMatch(char a, char b){
        return (a == b || b == '.');
    }
}
