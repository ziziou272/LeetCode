package intuit.VO;

import java.util.*;

public class Calculator {
    public static void main(String[]args){
        System.out.println(calculatorNoStack("1+2+3 +4 + 5 + 6 -1     + 2 "));
        System.out.println(calculator("1+ 2 + 3 - 3 -2 -1 + 1222 + 1222 - 2000 - 333- 111"));
        System.out.println(calculator("1+       1222+3 +4 + 5 + 6 -1     + 2 "));
        System.out.println(calculatorWithParenthesis("1 - ((3 - 2) - (1 + 2)) + 3 "));
        Map<String, Integer> map = new HashMap<>();
        map.put("e", 1);
        map.put("y", 2);
        String resWords=calculatorWords("(e+8) - (a + 3 - (z + 8) + y) +x", map);
        System.out.println(resWords);
        HashMap<Character, Integer> map2 = new HashMap<>();
        map2.put('e', 1);
        map2.put('y', 2);
        String resWords2=calculatorWithUnknown("(e+8) - (a + 3 - (z + 8) + y) +x", map2);
        System.out.println(resWords2);
    }

    /**  q1:
     *  if operator is plus set the sign as 1 otherwise -1
     *  val = val + operator * curVal
     *  111 + 2 - 3
     *            p
     */
    public static int calculator(String s){
        int operator = 1;
        int val = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '+'){
                operator = 1;
            }
            else if(cur == '-'){
                operator = -1;
            }
            else if(Character.isDigit(cur)){//number
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                val += operator * num;
            }
            //else is the case of space do nothing
        }
        return val;
    }
    /** q2:
     *
     * the parenthesis is tricky, the calculations inside the parenthesis need be performed first
     * so i need store the result before the parenthesis
      1 - ((2 + 3) - (3 - 1))
                            p
    * val -2
    * sign -1   curSign -1
    * stack:
    * */
    public static int calculatorWithParenthesis(String s){
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
                int prevVal = stack.pop();
                val = prevVal + val * curSign;
            }
        }
        return val;
    }

    /**  q3:
     *   separate the unknown wor with number
     *   calculate separately and combine
     *   2 - ((1 + b) - (a + 3)) + c
     *              p
     *   list: b
     *   res: 2 -1
     *   val 0
     *   sign -1  tempSign
     *   stack 1
     */
    public static String calculatorWithUnknown(String s, HashMap<Character, Integer> map){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        StringBuilder sb = new StringBuilder();
        //int val = 0;
        int sign = 1;
        String res = "";
        List<String> notMappedVariables = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '+'){
                sign = 1;
            }
            else if(cur == '-'){
                sign = -1;
            }
            //number
            else if(Character.isDigit(cur)){
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                String prefix = sign * stack.peek() == 1 ? "+" : "-";
                res += prefix + num;
                i--;
            }
            //
            else if(map.containsKey(cur)){
                int num = map.get(cur);
                String prefix = sign * stack.peek() == 1 ? "+" : "-";
                res += prefix + num;
            }
            else if(cur == '('){
                stack.push(sign * stack.peek());
                //set default value
                sign = 1;
            }
            else if(cur == ')'){
                stack.pop();
            }
            else if(cur == ' ')
                continue;
            else {
                String str = stack.peek() * sign == 1 ? "+" : "-";
                notMappedVariables.add(str + cur);
            }
        }
        res = "" + calculator(res);
        for(String str : notMappedVariables)
            res += str;
        return res;
    }

    public static String calculatorWords(String s, Map<String, Integer> map) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        String res = "";
        Deque<Integer> signStack = new LinkedList<>();
        int sign = 1;
        signStack.push(1);
        List<String> notMappedVariables = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                signStack.push(sign * signStack.peek());
                sign = 1;
            } else if (ch == ')') {
                signStack.pop();
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (Character.isDigit(ch)) {
                int num = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(++i) - '0';
                }
                String prefix = sign * signStack.peek() == 1 ? "+":"-";
                res += prefix + num;
            } else if (Character.isLowerCase(ch)) {
                String v = "" + ch;
                while (i + 1 < s.length() && Character.isLowerCase(s.charAt(i + 1))) {
                    v += s.charAt(++i);
                }
                if (map.containsKey(v)) {
                    v = "" + map.get(v);
                    String prefix = sign * signStack.peek() == 1 ? "+":"-";
                    res += prefix + v;
                } else {
                    String variableString = (signStack.peek() * sign == 1 ? "+" : "-") + v;
                    notMappedVariables.add(variableString);
                }
            }
        }
        System.out.println(notMappedVariables);
        res = "" + calculator(res);
        for (String each : notMappedVariables) {
            res += each;
        }
        return res;
    }


    //q1 no stack
    public static int calculatorNoStack(String input){
        int val = 0;
        int curVal = 0;
        int operator = 1;
        for(int i = 0; i < input.length(); i++){
            while (i < input.length() && input.charAt(i) == ' ')
                i++;
            while(i < input.length() && input.charAt(i) >= '0' && input.charAt(i) <= '9'){
                curVal = curVal * 10 + input.charAt(i) - '0';
                i++;
            }
            if(i < input.length() && (input.charAt(i) == '+' || input.charAt(i) == '-')){
                val += curVal * operator;
                curVal = 0;
                operator = (input.charAt(i) == '+' ? 1: -1);
            }
        }
        val += curVal * operator;
        return val;
    }
}
