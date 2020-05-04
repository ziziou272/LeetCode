package stringAndArray;

public class LC796brutal {
    //n^2
    public boolean rotateString(String a, String b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.length() == 0 && b.length() == 0) return true;
        if(a.length() != b.length()) return false;
        String newA = a + a;
        for(int i = 0; i < newA.length(); i++){
            if(check(newA, i, b)) return true;
        }
        return false;
    }
    private boolean check(String newA, int start, String b){
        for(int i = 0; i < b.length(); i++){
            if(newA.charAt(i + start) != b.charAt(i)) return false;
        }
        return true;
    }
}
