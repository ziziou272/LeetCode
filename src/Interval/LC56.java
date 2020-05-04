package Interval;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0)
            return new int[0][0];
        Arrays.sort(intervals,(c1, c2) -> c1[0] - c2[0]);
        LinkedList<int[]> temp = new LinkedList<>();
        temp.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= intervals[i - 1][1]){//merge
                temp.getLast()[1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            }
            else{
                temp.add(intervals[i]);
            }
        }
        return temp.toArray(new int[temp.size()][2]);
    }
}
