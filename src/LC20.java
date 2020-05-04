import java.util.HashMap;
import java.util.Stack;

//stack
public class LC20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        if(s.length()% 2 != 0)
            return false;
        Stack<Character> myStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                myStack.push(ch);
            }
            else if(ch == ')')
            {
                if(myStack.isEmpty() || myStack.pop() != '(')
                    return false;
            }
            else if(ch == ']')
            {
                if(myStack.isEmpty() || myStack.pop() != '[')
                    return false;
            }
            else
            {
                if(myStack.isEmpty() || myStack.pop() != '{')
                    return false;
            }
        }
        // make sure stack is empty
        return myStack.isEmpty();
    }
}