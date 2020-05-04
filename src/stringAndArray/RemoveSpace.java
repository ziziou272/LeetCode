package stringAndArray;

public class RemoveSpace {
    //s1: 只保留字幕后的空格，最后一个单词后的空格要最后check
    public String removeSpace(String s){
        char [] chars = s.toCharArray();
        int slow = 0;
        for(int fast = 0; fast < chars.length; fast++){
            if(chars[fast] != ' '|| (chars[fast] == ' ' && (fast != 0 || chars[fast - 1] != ' ')))
                chars[slow++] = chars[fast];
        }
        //这个没有写出来
        if(slow == 0) return "";
        //check最后一个字母的后边的空格有没有
        return chars[slow - 1] == ' ' ? new String(chars,0, slow - 1) : new String(chars, 0, slow);
    }
}
