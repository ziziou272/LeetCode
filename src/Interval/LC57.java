package Interval;

import java.util.LinkedList;

public class LC57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0){
            int[][] res = new int[1][2];
            res[0][0] = newInterval[0];
            res[0][1] = newInterval[1];
            return res;
        }

        LinkedList<int[]> temp = new LinkedList<>();
        boolean inserted = false;
        for(int i = 0; i < intervals.length; i++){
            //insert to left
            if(!inserted){
                if(newInterval[1] < intervals[i][0]){
                    temp.add(newInterval);
                    i--;
                    inserted = true;
                }
                else if(newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]){
                    int x = Math.min(intervals[i][0], newInterval[0]);
                    int y = Math.max(intervals[i][1], newInterval[1]);
                    temp.add(new int[]{x,y});
                    inserted = true;
                }
                else if(i + 1 >= intervals.length || newInterval[1] < intervals[i + 1][0]){//insert to right
                    temp.add(intervals[i]);
                    temp.add(newInterval);
                    inserted = true;
                }
                else{
                    temp.add(intervals[i]);
                }
            }
            else{
                if(temp.getLast()[0] <= intervals[i][0] && temp.getLast()[1] >= intervals[i][0]){
                    int x = Math.min(intervals[i][0], temp.getLast()[0]);
                    int y = Math.max(intervals[i][1], temp.getLast()[1]);
                    temp.removeLast();
                    temp.add(new int[]{x,y});
                }
                else{
                    temp.add(intervals[i]);
                }
            }

        }
        return temp.toArray(new int[temp.size()][2]);
    }
}

