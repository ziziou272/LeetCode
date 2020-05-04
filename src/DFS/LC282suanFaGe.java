package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC282suanFaGe {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        dfs(res, new StringBuilder(), num, 0, target, 0, 0);
        return res;
    }
    private void dfs(List<String> res, StringBuilder path, String num, int index, int target, long sum, long lastVal){
        //last val是basic calculator的思想
        if(index == num.length() && sum == target){
            res.add(path.toString());
            return;
        }
        if(index >= num.length()) return;
        long val = 0;
        for(int i = index; i < num.length();i++){
            val = val * 10 + (num.charAt(i) - '0');
            int len = path.length();
            if(len == 0){
                path.append(val);
                dfs(res, path, num, i + 1, target, val, val);
                //setback
                path.setLength(len);
            }
            else{//+val *val -val   这样不用carry符号
                //+
                path.append("+");
                path.append(val);
                dfs(res, path, num, i + 1, target, sum + val, val);
                path.setLength(len);
                //-
                path.append("-");
                path.append(val);
                dfs(res, path, num, i + 1, target, sum - val, -val);
                path.setLength(len);
                //*
                path.append("*");
                path.append(val);
                dfs(res, path, num, i + 1, target, (sum - lastVal) + lastVal * val, val * lastVal);
                path.setLength(len);
            }
            //防止1000009这种情况
            if(val == 0) break;
        }
    }
}
