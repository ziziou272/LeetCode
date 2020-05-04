package Stack;

import java.util.Stack;

public class LC394SuanFaGe {
    public String decodeString(String s) {
        //cc
        if(s == null || s.length() == 0) return "";
        //String stack
        Stack<StringBuilder> symbol = new Stack<>();
        symbol.push(new StringBuilder());
        //nums stack
        Stack<Integer> nums = new Stack<>();
        int i = 0;
        while (i < s.length()){
            char curChar = s.charAt(i);
            if(curChar >= '0' && curChar <= '9'){
                //numbers
                int val = 0;
                while(true){
                    if(s.charAt(i) >='0' && s.charAt(i) <='9'){
                        val = val * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    else break;
                }
                nums.push(val);
            }
            else if(curChar == '['){
                symbol.push(new StringBuilder());
                i++;
            }
            else if(curChar == ']'){
                int count = nums.pop();
                StringBuilder temp = symbol.pop();
                for(int j = 0; j < count; j++){
                    symbol.peek().append(temp);
                }
                i++;
            }
            else{
                symbol.peek().append(curChar);
                i++;
            }
        }
        return symbol.peek().toString();
    }
}
