package DP;

import java.util.ArrayList;
import java.util.List;

public class LC119 {
    public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<>();
    if(rowIndex < 0) return res;

    getRow(res, rowIndex,0);
    return res;
    }

    private void getRow(List<Integer> res, int rowIndex, int cur){
        if(cur > rowIndex ) return;
        if(cur == 0) res.add(1);
        if(cur == 1) res.add(1);
        if(cur > 1){
            for(int i = cur - 1; i > 0; i--){
                int temp = res.get(i) + res.get(i - 1);
                res.remove(i);
                res.add(i,temp);
            }
            res.add(1);
        }

        getRow(res, rowIndex,cur + 1);

    }

}
