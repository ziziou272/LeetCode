package stringAndArray;

import java.util.HashSet;
import java.util.Stack;

public class LC1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int differ = 0, open = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == ')'){
                if(differ >= 1){
                    open++;
                    differ--;
                    sb.append(cur);
                }
            }
            else{
                if(cur == '(')
                    differ++;
                sb.append(cur);
            }
        }
        //second round
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < sb.length(); i++){
            char cur = sb.charAt(i);
            if(cur == ')'){
                res.append(cur);
            }
            else if(cur == '('){
                if(open > 0){
                    res.append(cur);
                    open--;
                }

            }else
                res.append(cur);
        }
        return res.toString();
    }
}
class Solution1249{
    public String minRemoveToMakeValid(String s) {
        HashSet<Integer> set = new HashSet();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                continue;
            }else{
                if(s.charAt(i) == '(')
                    stack.push(i);
                else{
                    if(stack.isEmpty())
                        set.add(i);
                    else
                        stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }
        //rebuild the string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!set.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
