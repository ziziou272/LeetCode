package DP;

import java.util.ArrayList;
import java.util.List;

public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        generate(1,numRows,res);
        return res;
    }

    private void generate(int cur,int numRows,List<List<Integer>> res ){
        if(cur == numRows + 1 ) return;

        List<Integer> level = new ArrayList<>();
        for(int i = 0; i < cur; i++){
            if(i == 0 || i == cur - 1) {
                level.add(1);
                continue;
            }
            int temp = res.get(cur - 2).get(i - 1) + res.get(cur - 2).get(i);
            level.add(temp);
        }
        res.add(new ArrayList<>(level));

        generate(cur + 1,numRows,res);
    }
}
