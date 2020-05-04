package stringAndArray;

public class LC151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";
        char [] chars = s.toCharArray();
        String sTrim = removeExtraSpace(chars);
        String [] sArray = sTrim.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sArray.length; i++){
            sb.append(sArray[sArray.length - i - 1 ]);
            if(i != sArray.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }
    private String removeExtraSpace(char [] chars){//keep first space after words
        int slow = 0;
        for(int fast = 0; fast < chars.length; fast++){
            if(chars[fast] != ' ' || (fast !=0 && chars[fast - 1] != ' ')) {
                chars[slow++] = chars[fast];
            }
        }
        if (slow == 0) return " ";
        return chars[slow - 1] == ' ' ? new String(chars, 0, slow -1): new String(chars, 0, slow);
    }
}
