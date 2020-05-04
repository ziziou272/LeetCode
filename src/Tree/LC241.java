package Tree;

import java.util.ArrayList;
import java.util.List;
class Solution2020_04_21 {
    public List<Integer> diffWaysToCompute(String input) {
        return form(input, 0, input.length() - 1);
    }
    private List<Integer> form(String input, int left, int right){
        List<Integer> res = new ArrayList<>();
        int len = input.length();
        if(left > right){
            res.add(0);
            return res;
        }
        if(left == right){
            res.add(input.charAt(left) - '0');
            return res;
        }
        boolean singleNumber = true;
        for(int i = left; i <= right; i++){
            char cur = input.charAt(i);
            if(cur == '+' || cur == '-' || cur == '*'){
                singleNumber = false;
                List<Integer> rightResList = form(input, i + 1, right);
                List<Integer> leftResList = form(input, left, i - 1);
                int curRes = 0;
                for(int leftRes : leftResList){
                    for(int rightRes : rightResList){
                        if(cur == '+')
                            curRes = rightRes + leftRes;
                        else if(cur == '-')
                            curRes = leftRes - rightRes;
                        else
                            curRes = rightRes * leftRes;
                        res.add(curRes);
                    }
                }
            }
        }
        if(singleNumber){
            int num = 0;
            while(left <= right)
                num = num * 10 + input.charAt(left++) - '0';
            res.add(num);
        }
        return res;
    }

}
/*
find a operator as a root
then form left child and right child
        3 - 2 - 1 * 3
          r

2nd

                    *
               -            3
           -        1
        3    2
1st tree
                    -
           3                -
                        2       *
                            1       3
*/
public class LC241 {
    //build different syntax tree
    public List<Integer> diffWaysToCompute(String input) {
        //(n/2)^(n/2)
        return dfs(input, 0, input.length() - 1);
    }
    private List<Integer> dfs(String input, int start, int end){
        //base case is in for loop
        boolean isSingleNum = true;
        List<Integer> res = new ArrayList<>();
        for(int i = start; i <= end; i++){
            char curChar = input.charAt(i);
            //check if it is a operand
            if(curChar == '*' || curChar == '-' || curChar == '+'){
                List<Integer> leftRes = dfs(input, start, i - 1);
                List<Integer> rightRes = dfs(input, i + 1, end);
                res.addAll(combine(leftRes, rightRes, curChar));
                isSingleNum = false;
            }
        }
        if(isSingleNum) res.add(Integer.valueOf(input.substring(start, end + 1)));
        return res;
    }
    private List<Integer> combine(List<Integer> leftRes, List<Integer> rightRes, char operand){
        List<Integer> res = new ArrayList<>();
        for(int leftVal : leftRes){
            for(int rightVal : rightRes){
                if(operand == '*'){
                    res.add(leftVal * rightVal);
                }
                else if(operand == '+'){
                    res.add(leftVal + rightVal);
                }
                else if(operand == '-'){
                    res.add(leftVal - rightVal);
                }
                else throw new IllegalArgumentException("Invalid operand");
            }
        }
        return res;
    }
}
