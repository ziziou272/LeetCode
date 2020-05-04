package Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC253 {
    private class Point{
        private boolean isStart;
        private int val;
        public Point(boolean isStart, int val){
            this.isStart = isStart;
            this.val = val;
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        //cc
        List<Point> myList = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            myList.add(new Point(true,intervals[i][0]));
            myList.add(new Point(false,intervals[i][1]));
        }

        Collections.sort(myList, (l1, l2) -> {
            if(l1.val != l2.val)
                return l1.val - l2.val;
            else
                return l1.isStart ? 1 : -1;
        });


        int max = 0;
        int count = 0;
        //2n
        for(int i = 0; i < myList.size(); i++){
            Point cur = myList.get(i);
            if(cur.isStart)
                max= Math.max(++count,max);
            else
                max = Math.max(--count, max);
        }
        return max;
    }
}
