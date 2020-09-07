package intuit.VO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class Calculator2 {
    public static void main(String[] args) {
        calculator(" 2 - 8 + 200  ");
        calculator2("20-   (  (  8  +  2   )   -   (   3   -   8   )   )");
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 2);
        calculator3("20-   (  ( a  +  2   )   -   (   b   -   8   ) + c  )", map);
    }

    /*
    q1
               20   -    8    +     2
    * val:  0  20  20   12    12    14
    * sign: 1  1  -1    -1    1     1
    * val = val + (sign*incomingVal)
    * */
    public static int calculator(String input){
        int val = 0, sign  = 1;
        int i = 0, size = input.length();
        while(i < size){
            char cur = input.charAt(i);
            if(cur == '-'){
                sign = -1;
                i++;
            }else if(cur == '+'){
                sign = 1;
                i++;
            }else if(Character.isDigit(cur)){
                int temp = 0;
                while(i < size && Character.isDigit(input.charAt(i))){
                    temp = temp * 10 + input.charAt(i) - '0';
                    i++;
                }
                val += sign * temp;
            }
            //space
            else{
                i++;
            }
        }
        System.out.println("The result of "+ input + " is: " + val);
        return val;
    }
    /*
    *           20  -   (  (  8  +  2   )   -   (   3   -   8   )   )
    * val:   0  20  20  0  0  8  8  10 10  10   0   3   3   -5  15  5
    * sign:  1  1   -1  1  1  1  1  1  1   -1   1   1   -1  -1  x
    * stack: 20 -1
    *
    * val -> 10 + (sign * val) 15
    *       20 +(-1*15) ->5
    *
    * */

    public static int calculator2(String input){
        int val = 0, sign  = 1;
        int i = 0, size = input.length();
        Stack<Integer> stack = new Stack<>();
        while(i < size){
            char cur = input.charAt(i);
            if(cur == '-'){
                sign = -1;
                i++;
            }else if(cur == '+'){
                sign = 1;
                i++;
            }else if(Character.isDigit(cur)){
                int temp = 0;
                while(i < size && Character.isDigit(input.charAt(i))){
                    temp = temp * 10 + input.charAt(i) - '0';
                    i++;
                }
                val += sign * temp;
            }else if(cur == '('){
                stack.push(val);
                stack.push(sign);
                sign = 1;
                val = 0;
                i++;
            }else if(cur == ')'){
                int leftSign = stack.pop();
                int leftVal = stack.pop();
                val = leftVal + (leftSign * val);
                i++;
            }
            else{
                i++;
            }
        }
        System.out.println("The result of "+ input + " is: " + val);
        return val;
    }
    /*
    a=2
    *           20  -   (  (  a  +  2   )   -   (   b   -   8   )  - c )
    *sign       1   -1  1  1  1  1  1  1    -1  1   1   -1      1  -1
     number     +20 - 2   -2    - 8
    *variable       +b +c
    *signStack: 1
    *
    *
    * */
    public static String calculator3(String input, HashMap<Character, Integer> map){
        StringBuilder nums = new StringBuilder();
        StringBuilder variables = new StringBuilder();
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);
        int i = 0, size = input.length();
        while(i < size){
            char cur = input.charAt(i);
            if(cur == '-'){
                sign = -1;
                i++;
            }else if(cur == '+'){
                sign = 1;
                i++;
            }else if(Character.isDigit(cur)){
                int temp = 0;
                while(i < size && Character.isDigit(input.charAt(i))){
                    temp = temp * 10 + input.charAt(i) - '0';
                    i++;
                }
                nums.append(sign * stack.peek() == 1 ? '+' : '-').append(temp);
            }else if(map.containsKey(cur)){
                int temp = map.get(cur);
                nums.append(sign * stack.peek() == 1 ? '+' : '-').append(temp);
                i++;
            }
            else if(cur == '('){
                stack.push(sign*stack.peek());
                sign = 1;
                i++;
            }else if(cur == ')'){
                stack.pop();
                i++;
            }else if(cur == ' '){
                i++;
            }
            //undefined variables
            else{
                variables.append(sign * stack.peek() == 1 ? '+' : '-').append(cur);
                i++;
            }
        }
        String result = "";
        result = calculator(nums.toString()) + variables.toString();
        System.out.println("The result of "+ input + " is: " + result);
        return result;

    }
}
