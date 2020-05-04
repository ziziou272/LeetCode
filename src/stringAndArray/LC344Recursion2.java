package stringAndArray;

public class LC344Recursion2 {

    private void swap(char [] chars, int left, int right){
        char temp = chars [left];
        chars [left] = chars[right];
        chars[right] = temp;
    }

    private void recursion(char [] chars, int left, int right){
        if(left >= right) return;
        recursion(chars, left+1, right-1);
        swap(chars,left,right);
    }

    public void reverseString(char [] s){
        int left = 0;
        int right = s.length - 1;
        recursion(s, left, right);
    }
}
