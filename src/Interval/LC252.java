package Interval;

import java.util.Arrays;

public class LC252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length <= 1 || intervals[0] == null || intervals[0].length == 0)
            return true;
        Arrays.sort(intervals,(c1, c2) -> c1[0] - c2[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i - 1][1])
                return false;
        }
        return true;
    }
}
