package Stack;

import java.util.Stack;

public class LC394 {
    public String decodeString(String s) {
        //cc
        if(s == null || s.length() == 0) return "";
        //num stack
        Stack<Integer> nums = new Stack<>();
        //symbol stack
        Stack<Character> symbol = new Stack<>();
        StringBuilder res = new StringBuilder();
        int i =0;
        while(i < s.length()){
            char curChar = s.charAt(i);
            if(curChar >= '0' && curChar <= '9'){
                int val = 0;
                while(true){
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                        val = val * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    else break;
                }
                nums.push(val);
            }
            else if(curChar == '['){
                symbol.push('[');
                i++;
            }

            else if(curChar == ']'){
                buildString(nums, symbol);
                i++;
            }
            else {
                symbol.push(curChar);
                i++;
            }
        }
        while(!symbol.isEmpty()){
            res.append(symbol.pop());
        }
        return res.reverse().toString();
    }
    private void buildString(Stack<Integer> nums, Stack<Character> symbol){
        StringBuilder path = new StringBuilder();
        int times = nums.pop();
        while(!symbol.isEmpty()){
            char curChar = symbol.pop();
            if(curChar == '[') break;
            path.append(curChar);
        }
        for(int j = 0; j < times; j++){
            for(int i = path.length() - 1; i >= 0; i--){
                symbol.push(path.charAt(i));
            }
        }
    }


        public static void main(String[] args){

                String s = "3[a]2[bc]";

                String ret = new LC394().decodeString(s);

                String out = (ret);

                System.out.print(out);
            }

}
