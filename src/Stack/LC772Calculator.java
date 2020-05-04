package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class LC772Calculator {
    public int calculate(String s) {
        if(s == null || s.length() == 0) throw new IllegalArgumentException();
        //operator precedence map
        HashMap<Character, Integer> operatorMap = new HashMap<>();
        operatorMap.put('+',1);
        operatorMap.put('-', 1);
        operatorMap.put('*', 2);
        operatorMap.put('/', 2);
        //nums stack
        Stack<Integer> numsStack = new Stack<>();
        //operator stack
        Stack<Character> operatorStack = new Stack<>();
        //to avoid 5+(1+5)+(2+7)+(3+5) bug add '(' at beginning
        addOperator('(', numsStack, operatorStack, operatorMap, 0, s);
        int i = 0;
        while (i < s.length()){
            char curChar = s.charAt(i);
            if(curChar == ' ')
                i++;
            else if(curChar == '(' || curChar == ')' || operatorMap.containsKey(curChar)){//() or * - + /
                addOperator(curChar, numsStack, operatorStack, operatorMap, i + 1, s);
                i++;
            }
            else if(curChar >= '0' && curChar <= '9'){
                int val = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    val = val * 10 + s.charAt(i) - '0';
                    i++;
                }
                numsStack.push(val);
            }
            else throw new IllegalArgumentException();
        }
        addOperator(')', numsStack, operatorStack, operatorMap, s.length(), s);
        return numsStack.pop();
    }
    private void addOperator(char operator, Stack<Integer> numsStack, Stack<Character> operatorStack, HashMap<Character, Integer> operatorMap, int i, String s){
        if(operator == '('){
            operatorStack.push(operator);
            //check negative
            //get rid of space
            while (i < s.length() && s.charAt(i) == ' '){
                i++;
            }
            if(s.charAt(i) == '-'){
                //0 - num
                numsStack.push(0);
            }
        }
        else if(operator == ')'){
            while(true){
                if(operatorStack.peek() == '('){
                    operatorStack.pop();
                    break;
                }
                //calculate
                int num2 = numsStack.pop();
                int num1 = numsStack.pop();
                char op = operatorStack.pop();
                int res = calc(num1, num2, op);
                numsStack.push(res);
            }
        }
        else{// * / + -
            while(!operatorStack.isEmpty()){
                //"0 - 2 * 3 + 8"   must be while otherwise will fail
                char topOperator = operatorStack.peek();
                if(operatorMap.containsKey(topOperator) && operatorMap.get(topOperator) >= operatorMap.get(operator)){
                    int num2 = numsStack.pop();
                    int num1 = numsStack.pop();
                    char op = operatorStack.pop();
                    int res = calc(num1, num2, op);
                    numsStack.push(res);
                }
                else break;
            }
            //push the coming operator
            operatorStack.push(operator);
        }
    }
    private int calc(int num1, int num2, char operator){
        switch (operator){
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            case '+': return num1 + num2;
            case '-': return num1 - num2;
        }
        return -1;
    }


        public static void main(String[] args) throws IOException {

                String s = "(7)-(0)+(4)";

                int ret = new LC772Calculator().calculate(s);

                String out = String.valueOf(ret);

                System.out.print(out);
        }

}
