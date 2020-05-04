package Tree;

import java.util.Stack;

public class LC331 {
}
class solutionIntuitive{
    public boolean isValidSerialization(String preorder) {
        //基本就是两个#抵消一个node，然后抵消完再加个#
        String[] strs = preorder.split(",");
        if(strs.length == 1)
            return strs[0].equals("#");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            if(i != 0 && stack.isEmpty())
                return false;
            else if(str.equals("#")){
                if(stack.isEmpty())
                    return false;
                else if(stack.peek().equals("#")){
                    while(!stack.isEmpty() && stack.peek().equals("#")){
                        stack.pop();
                        if(stack.isEmpty())
                            return false;
                        stack.pop();
                        if(!stack.isEmpty() && !stack.peek().equals("#")){
                            stack.push("#");
                            break;
                        }
                    }
                }
                else{
                    stack.push("#");
                }
            }
            else{
                stack.push(str);
            }
        }
        return stack.isEmpty();
    }
}
//node(个数) + 1 == #(个数), why?
class solutionEasy{
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        //相差1
        int count = 1;
        for(String str : strs){
            if(str.equals("#"))
                count--;
            else{
                if(count <= 0)
                    return false;
                count++;
            }
        }
        return count == 0;
    }
}