package stringAndArray;

import java.util.ArrayList;
import java.util.List;

public class LC6ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++) list.add(new StringBuilder());
        int index = 0, rowIndex = 0;
        while(index < s.length()){
            for(rowIndex = 0; rowIndex < numRows && index < s.length(); rowIndex++){
                list.get(rowIndex).append(s.charAt(index++));
            }
            for(rowIndex = numRows - 2; rowIndex > 0 && index < s.length(); rowIndex--){
                list.get(rowIndex).append(s.charAt(index++));
            }
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list){
            res.append(sb.toString());
        }
        return res.toString();
    }
}
