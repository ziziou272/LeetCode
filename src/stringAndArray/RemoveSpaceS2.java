package stringAndArray;

public class RemoveSpaceS2 {
    public String removeSpace(String s){
        char [] chars = s.toCharArray();
        int slow = 0;
        for(int fast = 0; fast < chars.length; fast++){
            if(chars[fast] != ' '|| ( fast != chars.length - 1 && chars[fast + 1] != ' '))
                chars[slow++] = chars[fast];
        }
        if(slow == 0) return "";
        //切记new String最后一个是size
        return chars[0] == ' ' ? new String(chars, 1, slow - 1) : new String(chars,0, slow);
    }
}
