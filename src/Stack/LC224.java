package Stack;

import java.io.IOException;
import java.util.Stack;
class oneStackSolution{
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int val = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '+'){
                sign = 1;
            }
            else if(cur == '-'){
                sign = -1;
            }
            else if(Character.isDigit(cur)){
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                val += num * sign;
                i--;
            }
            else if(cur == '('){
                stack.push(val);
                stack.push(sign);
                //set default value
                val = 0;
                sign = 1;
            }
            else if(cur == ')'){
                int curSign = stack.pop();
                int curVal = stack.pop();
                val = curVal + val * curSign;
            }
        }
        return val;
    }
}
public class LC224 {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int i = 0;
        addOperator(operatorStack, numberStack,'(');
        while(i < s.length()){
            char cur = s.charAt(i);
            //get rid of space
            if(cur == ' ')
                i++;
            else if(cur == '+' || cur == '-' || cur == '(' || cur == ')'){
                addOperator(operatorStack, numberStack, cur);
                i++;
            }
            else {//number
                int val = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    val = val * 10 + s.charAt(i) - '0';
                    i++;
                }
                numberStack.push(val);
            }
        }
        addOperator(operatorStack, numberStack,')');
        return numberStack.peek();
    }
    private void addOperator(Stack<Character> operatorStack, Stack<Integer> numberStack, char operator){
        if(operator == '('){
            operatorStack.push(operator);
        }
        else if(operator == ')'){
            while (true){
                if(!operatorStack.isEmpty() && operatorStack.peek() == '('){
                    operatorStack.pop();
                    break;
                }
                else if(!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-')) {
                    int res = calc(operatorStack.pop(), numberStack.pop(), numberStack.pop());
                    numberStack.push(res);
                }
            }
        }
        else if(operator == '+' || operator == '-'){
            if(operatorStack.isEmpty()){
                operatorStack.push(operator);
            }
            else if(operatorStack.peek() == '+' || operatorStack.peek() == '-'){
                int res = calc(operatorStack.pop(), numberStack.pop(), numberStack.pop());
                numberStack.push(res);
                operatorStack.push(operator);
            }
            else{
                operatorStack.push(operator);
            }
        }
    }
    private int calc(char operator, int operand2, int operand1){
        int res = 0;
        if(operator == '+'){
            res = operand1 + operand2;
        }
        else if (operator == '-'){
            res = operand1 - operand2;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {

        String s = "(7)-(0)+(4)";

        int ret = new LC224().calculate(s);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}