package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    public List<String> generateParenthesis(int n) {
        if(n == 0)
            return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        generateParenthesis(0, 0, n, sb, res);
        return res;
    }
    private void generateParenthesis(int left, int right, int n, StringBuilder sb, List<String> res){
        // must check if left = n and right = n instead of check sb.length() == 2n
        if(left == n && right == n){
            res.add(sb.toString());
            return;
        }
        if(left < right || left > n)
            return;
        int len = sb.length();
        generateParenthesis(left + 1, right, n, sb.append('('), res);
        sb.setLength(len);//sb.deleteCharAt(sb.length() - 1)
        generateParenthesis(left, right + 1, n, sb.append(')'),res);
        sb.setLength(len);
    }
}
