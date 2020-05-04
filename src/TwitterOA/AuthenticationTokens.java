package TwitterOA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class AuthenticationTokens {
    /*
     get   id    time
    * [0,   1,   1]
    *reset  id   time
      [1,   1,   5]
    *
    *
    *
    * */

    public static int numberOfTokens(int[][] commands, int expiryLimit){
        //corner case
        if(commands == null || commands.length == 0 || commands[0] == null || commands[0].length == 0) return 0;
        int[] expireTime = new int[commands.length + 1];
        Arrays.fill(expireTime, -1);
        for(int[] command : commands){
            int curId = command[1];
            int curTime = command[2];
            //get -> create new
            if(command[0] == 0 && expireTime[curId] == -1){
                if(expireTime[curId] == - 1 || expireTime[curId] >= curTime) {
                    expireTime[curId] = curTime + expiryLimit;
                }
            }
            //reset token
            else if(command[0] == 1 && expireTime[curId] != -1){
                if(expireTime[curId] >= curTime)
                    expireTime[curId] = curTime + expiryLimit;
            }
        }
        int endTime = commands[commands.length - 1][2];
        int count = 0;
        for(int i = 1; i < expireTime.length; i++){
            if(expireTime[i] >= endTime) count++;
        }
        return count;
    }

    public static void main(String[] args){
        int[][] commands = new int[][]{{0,1,1},{0,2,2},{1,3,3},{0,4,4},{1,1,5},{1,2,7}};
        int k = 4;
        System.out.println(numberOfTokens(commands, k));
    }
}
