package Stack;

import java.util.HashMap;
import java.util.Stack;

public class LC227 {
}
class stackSolution{
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int res = 0, i = 0;
        Stack<Character> operators = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        //operator precedence map
        HashMap<Character, Integer> operatorMap = new HashMap<>();
        operatorMap.put('+',1);
        operatorMap.put('-', 1);
        operatorMap.put('*', 2);
        operatorMap.put('/', 2);
        while(i < s.length()){
            char cur = s.charAt(i);
            if(cur == ' '){
                i++;
            }
            //num
            else if(Character.isDigit(cur)){
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                numbers.push(num);
            }
            //operator
            else{
                //higher precendence
                while(!operators.isEmpty() && operatorMap.get(operators.peek()) >= operatorMap.get(cur)){
                    char op = operators.pop();
                    int num = numbers.pop();
                    int prev = numbers.pop();
                    if(op == '*'){
                        numbers.push(prev * num);
                    }else if(op == '+')
                        numbers.push(prev + num);
                    else if(op == '-')
                        numbers.push(prev - num);
                    else{
                        numbers.push(prev / num);
                    }
                }
                operators.push(cur);
                i++;
            }
        }
        //post precess
        while(!operators.isEmpty()){
            int num2 = numbers.pop();
            int num1 = numbers.pop();
            char op = operators.pop();
            if(op == '*'){
                numbers.push(num1 * num2);
            }else if(op == '+')
                numbers.push(num1 + num2);
            else if(op == '-')
                numbers.push(num1 - num2);
            else{
                numbers.push(num1 / num2);
            }
        }
        return numbers.peek();
    }
}
class SolutionNonStack {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        char operator = '+';
        int res = 0, prev = 0, i = 0;
        while(i < s.length()){
            int num = 0;
            //number
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                if(operator == '+'){
                    res += num;
                    prev = num;
                }
                else if(operator == '-'){
                    res -= num;
                    prev = -num;
                }
                else if(operator == '*'){
                    res = (res - prev) + prev * num;
                    prev = prev * num;
                }
                else if(operator == '/'){
                    res = res - prev + prev / num;
                    prev = prev / num;
                }
            }
            //operator
            else if(s.charAt(i) != ' '){
                operator = s.charAt(i++);
            }else{
                i++;
            }
        }
        return res;
    }
}
/*
res 0
prev 0
operator: +
* and / higher precendence

8 -> res - prev -> 3 + 5 * 3
res 18 -> 3
prev    15 * 2 or prev num

+ 3 + 5 * 3 * 2 - 6 / 2
                   i








*/