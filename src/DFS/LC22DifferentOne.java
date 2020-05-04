package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC22DifferentOne {
    public List<String> generateParenthesis(int n) {
        if(n == 0)
            return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        generateParenthesis(0, 0, n, sb, res);
        return res;
    }
    private void generateParenthesis(int left, int right, int n, StringBuilder sb, List<String> res){
        if( left + right == 2 * n){
            res.add(sb.toString());
            return;
        }
        if(left < n){
            generateParenthesis(left + 1, right, n, sb.append('('), res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            generateParenthesis(left, right + 1, n, sb.append(')'), res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
