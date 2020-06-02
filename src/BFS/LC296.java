package BFS;

import java.util.ArrayList;
import java.util.List;

public class LC296 {
}
class Solution296 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    rows.add(i);
            }
        }
        for(int j = 0; j < grid[0].length;j++){
            for(int i = 0; i < grid.length; i++){
                if(grid[i][j] == 1)
                    cols.add(j);
            }
        }
        int x = rows.get(rows.size() / 2);
        int y = cols.get(cols.size() / 2);
        //calculate distance
        int total = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    total += Math.abs(i - x) + Math.abs(j - y);
            }
        }
        return total;
    }
}
/*

1 0 1 0 0
1 0 0 0 1
0 0 1 0 0


0 0 0 0 0
0 0 0 0 0
0 0 0 0 0


1. find all possible points -> m*n and calculate distance (m*n)
2. k *(m*n)
3. 1d -> 2d
mathmatics
find midlle point
*/